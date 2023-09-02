package com.rest.webservices.versining;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersiningController {
    
	@GetMapping("v1/person")
	public Personv1 personv1() {
		return new Personv1("Alex Vinni");
	}
	@GetMapping("v2/person")
	public Personv2 personv2() {
		return new Personv2(new Name("Alex","Vinni"));
	}
	
	@GetMapping(value="/person/param",params="version=1")
	public Personv1 paramv1() {
		return new Personv1("Alex Vinni");
	}
	@GetMapping(value="/person/param",params="version=2")
	public Personv2 param2() {
		return new Personv2(new Name("Alex","Vinni"));
	}
	
	@GetMapping(value="/person/header",headers="X-API-VERSION=1")
	public Personv1 header1() {
		return new Personv1("Alex Vinni");
	}
	@GetMapping(value="/person/header",headers="X-API-VERSION=2")
	public Personv2 header2() {
		return new Personv2(new Name("Alex","Vinni"));
	}
	
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json")
	public Personv1 produces() {
		return new Personv1("Alex Vinni");
	}
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v2+json")
	public Personv2 produces2() {
		return new Personv2(new Name("Alex","Vinni"));
	}
}
