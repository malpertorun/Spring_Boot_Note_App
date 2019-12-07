package com.example.web.abc.repository;

import  com.example.web.abc.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Item findByInventoryCode(String inventoryCode);
}
