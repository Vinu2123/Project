package com.rest.webservices.user;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;


import jakarta.validation.Valid;

@RestController
public class UserResource {
    
	@Autowired 
	private UserDaoService service;
	 
	@GetMapping("/users")
	public List<User> retriveAllUser(){
		return service.findAll();	 
	}
	 
	@GetMapping("/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable int id) {
		User user= service.findUser(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		  // Create the link for retriveAllUser() in this method
		 Link allUsersLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retriveAllUser())
		            .withRel("all-users");
		        
		        EntityModel<User> userResource = EntityModel.of(user);
		        userResource.add(allUsersLink);
		
		
		return userResource;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser=service.save(user);
		
		UriComponents location = ServletUriComponentsBuilder
			    .fromCurrentRequest()
			    .path("/{id}")
			    .buildAndExpand(savedUser.getId());

			URI uri = location.toUri(); // Convert UriComponents to URI

			return ResponseEntity.created(uri).build();

		
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user= service.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
	
	}
	}
}
//after doing the moniterization  go with http://localhost:8080/actuator   and   http://localhost:8080/browser/index.html#/
