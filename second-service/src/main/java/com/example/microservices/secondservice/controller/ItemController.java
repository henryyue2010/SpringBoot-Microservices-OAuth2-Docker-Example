package com.example.microservices.secondservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.secondservice.entity.Item;
import com.example.microservices.secondservice.service.ItemServiceImpl;

@RestController
@RequestMapping("/api2")
public class ItemController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ItemServiceImpl itemService;

	@GetMapping(value = "/items/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Item>> findAllItems() {
		List<Item> items = itemService.foundAllItems();
		return new ResponseEntity<>(items, HttpStatus.OK); // return 200, with json body
	}
}
