package com.msvc.usuario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
}
