package com.example.microservices.firstservice.service;

import com.example.microservices.firstservice.entity.Item;

public interface ItemService {

	Item getItemById(Long id);

	Item createItem(Item item);

	Item updateItem(Long id, Item item);

	void deleteItemById(Long id);
}
