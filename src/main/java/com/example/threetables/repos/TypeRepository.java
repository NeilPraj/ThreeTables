package com.example.threetables.repos;

import com.example.threetables.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
}