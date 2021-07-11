package com.example.microservices.firstservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.firstservice.entity.Item;
import com.example.microservices.firstservice.service.ItemServiceImpl;

@RestController
@RequestMapping("/api1")
public class ItemController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ItemServiceImpl itemService;

	@GetMapping(value = "/items/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> findItemById(@PathVariable final Long itemId) {
		try {
			Item item = itemService.getItemById(itemId);
			return new ResponseEntity<>(item, HttpStatus.OK); // return 200, with json body
		} catch (ResourceNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // return 404, with null body
		}

	}

	@PostMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> createPost(@RequestBody Item item) {

		try {
			Item createdItem = itemService.createItem(item);
			return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping(value = "/items/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> updateItem(@PathVariable final Long itemId, @RequestBody Item item) {

		try {
			Item updatedItem = itemService.updateItem(itemId, item);

			return new ResponseEntity<>(updatedItem, HttpStatus.OK);
		} catch (ResourceNotFoundException ex) {
			// log exception first, then return Not Found (404)
			logger.error(ex.getMessage());
			return ResponseEntity.notFound().build();
		} catch (Exception ex) {
			// log exception first, then return Bad Request (400)
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@DeleteMapping(value = "/items/{itemId}")
	public ResponseEntity<String> deleteItemById(@PathVariable("itemId") final Long itemId) {
		try {
			itemService.deleteItemById(itemId);
			return new ResponseEntity<>("Success", HttpStatus.OK);
		} catch (ResourceNotFoundException ex) {
			logger.error(ex.getMessage());
			return ResponseEntity.notFound().build();
		}
	}
}
