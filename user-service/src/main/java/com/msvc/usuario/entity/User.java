package com.msvc.usuario.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

  @Id
  @Column(name = "id")
  private String userId;

  @Column(name = "name")
  private String name;
  
  @Column(name = "email")
  private String email;

  @Column(name = "information")
  private String information;

  public User(String name, String email, String information) {
    super();
    this.name = name;
    this.email = email;
    this.information = information;
  }

  @Transient
  List<Rating> ratings = new ArrayList<>();
}
