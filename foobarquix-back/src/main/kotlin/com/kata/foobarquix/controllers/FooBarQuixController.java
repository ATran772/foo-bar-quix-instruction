package com.kata.foobarquix.controllers;

import com.kata.foobarquix.services.FooBarQuixService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foo-bar-quix")
public class FooBarQuixController{

	private FooBarQuixService fooBarQuixService;
	
	public FooBarQuixController(FooBarQuixService service) {
		this.fooBarQuixService = service;
	}
	
    @GetMapping( value = "/{inputNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200" })
    public ResultDto convertNumber(@PathVariable(name = "inputNumber") int inputNumber) {
        return new ResultDto(fooBarQuixService.convertNumber(inputNumber));
    }

    public class ResultDto{
    	private String result;
    
    	public ResultDto(String result){
    		this.setResult(result);
    	}

		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}
    }

}