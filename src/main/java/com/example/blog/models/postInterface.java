package com.example.blog.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface postInterface extends CrudRepository<Post, Long> {
    Post findByTitle(String title);
}
