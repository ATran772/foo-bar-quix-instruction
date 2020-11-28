package com.kata.foobarquix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kata.foobarquix.controllers.FooBarQuixController;
import com.kata.foobarquix.controllers.FooBarQuixController.ResultDto;
import com.kata.foobarquix.services.FooBarQuixService;

@SpringBootTest
class FooBarQuixApplicationTests {

	@Autowired
	private FooBarQuixController controller;
	
	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}

	@Test
	public void testDivisionBy5(){
		ResultDto convertNumber = controller.convertNumber(5);
		assertEquals(convertNumber.getResult(), FooBarQuixService.BAR);
	}

	@Test
	public void testDivisionBy3(){
		ResultDto convertNumber = controller.convertNumber(3);
		assertEquals(convertNumber.getResult(), FooBarQuixService.FOO);
	}
	
	@Test
	public void testContains7(){
		ResultDto convertNumber = controller.convertNumber(7);
		assertEquals(convertNumber.getResult(), FooBarQuixService.QUIX);
	}

	@Test
	public void testNoMatch(){
		ResultDto convertNumber = controller.convertNumber(34);
		assertEquals(convertNumber.getResult(), "34");
	}
	
	@Test
	public void testSevaralCase(){
		ResultDto convertNumber = controller.convertNumber(27);
		assertEquals(convertNumber.getResult(), "FooQuix");
	}
}
