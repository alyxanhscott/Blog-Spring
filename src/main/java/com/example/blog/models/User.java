package com.example.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne
    private Post posts;

    public User() {}

    public User(Long id, String username, String email, String password, Post posts) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
        this.id = id;
    }

    public User(String username, String email, String password, Post posts) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
    }

        public User(User copy) {
            id = copy.id; // This line is SUPER important! Many things won't work if it's absent
            email = copy.email;
            username = copy.username;
            password = copy.password;
        }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Post getPosts() {
        return posts;
    }

    public void setPosts(Post posts) {
        this.posts = posts;
    }
}
