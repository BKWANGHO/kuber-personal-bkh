package com.turing.api.user;


import com.turing.api.article.Article;
import com.turing.api.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@AllArgsConstructor
@Setter
@ToString(exclude = {"id"})
public class User extends BaseEntity {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String name;
    private String phone;
    private Long addressId;
    private String job;
    private double height;
    private double weight;

    @OneToMany(mappedBy = "writer")
    private List<Article> articles;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phone +
                ", address='" + addressId + '\'' +
                ", job='" + job + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}' + '\n';
    }

    public void setPassword(String password) {
        this.password = password;
    }
}