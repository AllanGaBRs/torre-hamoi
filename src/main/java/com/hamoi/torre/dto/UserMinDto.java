package com.hamoi.torre.dto;

import com.hamoi.torre.entity.User;

public class UserMinDto {

    private Long id;
    private String name;

    public UserMinDto(){

    }

    public UserMinDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserMinDto(User entity){
        id = entity.getId();
        name = entity.getUsername();
    }

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
}
