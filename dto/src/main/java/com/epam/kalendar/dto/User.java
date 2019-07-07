package com.epam.kalendar.dto;

public class User {

  private Long id;
  private String firstName;
  private String lastName;
  private String username;

  public User() {
  }

  public User(Long id, String firstName, String lastName, String username) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
  }

  public Long getId() {
    return id;
  }

  public User setId(long id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public User setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public User setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public User setUsername(String username) {
    this.username = username;
    return this;
  }

  @Override
  public String toString() {
    return "User{" +
        "id='" + id + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", username='" + username + '\'' +
        '}';
  }
}
