package com.example.threetables.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@ToString
public class Item{

    @Id
    @Column(name = "type_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_type_id")
    private Type type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_type_id", referencedColumnName = "type_id")
    private List<Owner> owner;

}
