package com.example.threetables.controllers;

import com.example.threetables.entities.Item;
import com.example.threetables.entities.Owner;
import com.example.threetables.exceptions.ResourceNotFoundException;
import com.example.threetables.repos.ItemRepository;
import com.example.threetables.repos.OwnerRepository;
import com.example.threetables.repos.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /*
    @DeleteMapping("/items/deleteitem")
    public ResponseEntity<List<Item>> deleteItemByName(@RequestParam String name){
        List<Item> items= itemRepo.findByName(name);
        return new ResponseEntity<List<Item>>(itemRepo.delete((Item) items), HttpStatus.OK);
    }

     */

    @DeleteMapping("/items/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Item item = itemRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        itemRepo.delete(item);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }





}
