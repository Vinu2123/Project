package com.rest.webservices.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class Filtiring {
	
	@GetMapping("/filtering")
    public MappingJacksonValue retrivsomebean() {
    	somebean somebean=new somebean("value1","value2", "value3");
    	
    	SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("feild1","feild2");
    	FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter );
    MappingJacksonValue mapping=new MappingJacksonValue(somebean);
    mapping.setFilters(filters);
    
    return mapping;
    }
}
