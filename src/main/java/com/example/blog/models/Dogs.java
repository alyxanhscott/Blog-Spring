package com.example.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "Dogs")
public class Dogs {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private long age;

    @Column(nullable = false, length = 10)
    private String state_residing;

    public Dogs(String name, long age, String state_residing) {
        this.name = name;
        this.age = age;
        this.state_residing = state_residing;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getState_residing() {
        return state_residing;
    }

    public void setState_residing(String state_residing) {
        this.state_residing = state_residing;
    }
}
