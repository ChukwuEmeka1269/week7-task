package com.example.week7task.model;

import com.example.week7task.model.Post;
import com.example.week7task.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long likeId;
    @ManyToOne
    private User user;
    @ManyToOne
    private Post post;

}
