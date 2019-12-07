package com.example.web.abc.service;

import com.example.web.abc.domain.ItemAddForm;
import com.example.web.abc.domain.Item;
import com.example.web.abc.domain.User;

import java.util.List;



public interface ItemService {
   

    void addItem(ItemAddForm form);

    Iterable<Item> getItems();

    Item assignItem(String username, long itemId);

 
}
