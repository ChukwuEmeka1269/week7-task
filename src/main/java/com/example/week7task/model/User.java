package com.example.week7task.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String date_of_birth;

    @OneToMany
    private List<Post> posts = new ArrayList<>();

    @OneToMany
    private List<Likes> likes = new ArrayList<>();

    @OneToMany
    private List<Comment> comments = new ArrayList<>();


}
