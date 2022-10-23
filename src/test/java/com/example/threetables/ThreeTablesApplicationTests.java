package com.example.threetables;

import com.example.threetables.entities.Item;
import com.example.threetables.repos.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThreeTablesApplicationTests {

    @Autowired
    private ItemRepository itemRepo;


    @Test
    void contextLoads() {
        Item item = new Item();
        item.setName("Soda bottle");
        itemRepo.save(item);
    }

}
