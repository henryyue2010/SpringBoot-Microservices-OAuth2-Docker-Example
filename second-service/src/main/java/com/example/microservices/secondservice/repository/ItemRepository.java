package com.example.microservices.secondservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservices.secondservice.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
