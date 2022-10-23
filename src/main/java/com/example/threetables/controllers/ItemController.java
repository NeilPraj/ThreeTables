package com.example.threetables.controllers;

import com.example.threetables.entities.Item;
import com.example.threetables.repos.ItemRepository;
import com.example.threetables.repos.OwnerRepository;
import com.example.threetables.repos.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepo;

    @Autowired
    private OwnerRepository ownerRepo;

    @Autowired
    private TypeRepository typeRepo;

    @PostMapping("/saveItem")
    public ResponseEntity<String> saveItem(@RequestBody List<Item> itemData){
        itemRepo.saveAll(itemData);
        return ResponseEntity.ok("The data was saved successfully");
    }

    @GetMapping("/items/name")
    public ResponseEntity<List<Item>> findItemByName(@RequestParam String name){
        return new ResponseEntity<List<Item>>(itemRepo.findByName(name), HttpStatus.OK);
    }



}
