package com.example.microservices.secondservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservices.secondservice.repository.ItemRepository;
import com.example.microservices.secondservice.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public List<Item> foundAllItems() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

}
