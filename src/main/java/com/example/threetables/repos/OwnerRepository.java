package com.example.threetables.repos;

import com.example.threetables.entities.Item;
import com.example.threetables.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {


}