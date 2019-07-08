package com.epam.kalendar.dto;

public class Message {

  private String timestamp;
  private User user;
  private String message;

  public Message() {
  }

  public Message(String timestamp, User user, String message) {
    this.timestamp = timestamp;
    this.user = user;
    this.message = message;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public Message setTimestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  public User getUser() {
    return user;
  }

  public Message setUser(User user) {
    this.user = user;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public Message setMessage(String message) {
    this.message = message;
    return this;
  }

  @Override
  public String toString() {
    return "Message{" +
        "timestamp=" + timestamp +
        ", user=" + user +
        ", message='" + message + '\'' +
        '}';
  }
}
