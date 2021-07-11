package com.example.microservices.firstservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.microservices.firstservice.entity.Item;
import com.example.microservices.firstservice.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item getItemById(Long id) {
		// TODO Auto-generated method stub
		return itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item Id:" + id));
	}

	@Override
	public Item createItem(Item item) {
		// TODO Auto-generated method stub
		return itemRepository.save(item);
	}

	@Override
	public Item updateItem(Long id, Item item) {
		// TODO Auto-generated method stub
		Item foundItem = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item Id:" + id));

		if (item != null && item.getName() != null)
			foundItem.setName(item.getName());

		if (item != null && item.getWeight() != null)
			foundItem.setWeight(item.getWeight());

		if (item != null && item.getPrice() != null)
			foundItem.setPrice(item.getPrice());

		return itemRepository.save(item);
	}

	@Override
	public void deleteItemById(Long id) {
		// TODO Auto-generated method stub
		itemRepository.deleteById(id);
	}

}
