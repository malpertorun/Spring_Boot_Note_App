package com.example.web.abc.service;
import com.example.web.abc.domain.Item;
import com.example.web.abc.domain.ItemAddForm;
import com.example.web.abc.domain.User;
import com.example.web.abc.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final UserService userService;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, UserService userService) {
        this.itemRepository = itemRepository;
        this.userService = userService;
    }

    public Item getItemByCode(String code) {
        return itemRepository.findByInventoryCode(code);
    }

    public Item getItemById(long id) {
        return itemRepository.findOne(id);
    }

    public void addItem(ItemAddForm form) {
       
            String inventoryCode = Long.toHexString(Double.doubleToLongBits(Math.random())).substring(10);
            Item item = new Item(inventoryCode, form.getItemType());
            itemRepository.save(item);
            assignItem(form.getAssingUser(), item.getId());
        // I took note and sent database.
    }

    public Iterable<Item> getItems() {
        return itemRepository.findAll();
    }

    
    @Override
    public Item assignItem(String username, long itemId) {
        User user = userService.getUserByUsername(username);
        Item item = getItemById(itemId);
        Set<Item> itemList = user.getItems();
        item.setUser(user);
        itemList.add(item);
        user.setItems(itemList);
     // I added user and assign informations.
        return itemRepository.save(item);
    }

   
}
