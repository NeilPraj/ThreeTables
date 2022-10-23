package com.example.threetables.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
public class Type{

    @Id
    @Column(name = "type_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String typename;



}
