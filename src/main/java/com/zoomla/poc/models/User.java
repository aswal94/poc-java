package com.zoomla.poc.models;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String fullName;
    private String username;
    private String password;

    public User(String fullName, String username, String password){
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("User [id=%d, fullName='%s', username='%s', password='%s']",
                id, fullName, username, password);
    }
}
