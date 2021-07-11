package com.example.microservices.secondservice.service;

import java.util.List;

import com.example.microservices.secondservice.entity.Item;

public interface ItemService {

	List<Item> foundAllItems();
}
