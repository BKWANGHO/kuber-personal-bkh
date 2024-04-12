package com.turing.api.user.model;


import com.turing.api.article.model.Article;
import com.turing.api.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@AllArgsConstructor
@Setter
public class User extends BaseEntity {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String name;
    private String phone;
    private String job;

    @OneToMany(mappedBy = "writer",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Article> articles;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phone +
                ", job='" + job + '\'' +
                '}' + '\n';
    }

    public void setPassword(String password) {
        this.password = password;
    }
}