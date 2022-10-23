package com.example.threetables.repos;

import com.example.threetables.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByName(String name);
}