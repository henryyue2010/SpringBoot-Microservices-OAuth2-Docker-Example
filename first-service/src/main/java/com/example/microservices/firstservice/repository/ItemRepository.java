package com.example.microservices.firstservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservices.firstservice.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
