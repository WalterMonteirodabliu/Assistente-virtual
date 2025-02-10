package com.walter.mordomo.model;

import jakarta.persistence.*;

@Entity
public class VirtualAssistant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ai_id")
    private AI intelligence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AI getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(AI intelligence) {
        this.intelligence = intelligence;
    }
}
