package com.kata.foobarquix.services;

import org.springframework.stereotype.Component;

@Component
public class FooBarQuixService {

	public static final String FOO = "Foo";

	public static final String BAR = "Bar";
	
	public static final String QUIX = "Quix";
			
    public String  convertNumber(int inputNumber) {
		StringBuilder valueToBeReturn = new StringBuilder();
		
		if(isInputDividedBy(inputNumber,3)){
			valueToBeReturn.append(FOO);
		}
		
		if(isInputDividedBy(inputNumber,5)){
			valueToBeReturn.append(BAR);
		}
		
		if(containsOccurence(inputNumber, 7)){
			valueToBeReturn.append(QUIX);
		}
		
        return valueToBeReturn.length() == 0 ? String.valueOf(inputNumber) : valueToBeReturn.toString();
    }
    
    public boolean isInputDividedBy(int input,int divisor){
    	return input%divisor == 0;
    }
    
	public boolean containsOccurence(int input,int divisor){
    	return String.valueOf(input).contains(String.valueOf(divisor));
    }

}