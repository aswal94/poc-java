package com.zoomla.poc.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
//@Table(name = "posts")
@Table(name = Post.TABLE_NAME)
public class Post {

    public static final String TABLE_NAME = "posts";
    @Id
    @GeneratedValue
    Long id;

    private String title;
    private String slug;
    private String body;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public Post(String title, String slug, String body) {
        this.title = title;
        this.slug = slug;
        this.body = body;
    }
}
