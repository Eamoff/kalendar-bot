package com.epam.kalendar.backend.controllers;

import com.epam.kalendar.dto.Message;
import com.epam.kalendar.dto.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController("/message")
public class MessageController {

  private static final User APP_USER = new User()
      .setId(0)
      .setFirstName("Kalendar")
      .setLastName("Backend")
      .setUsername("kalendar-backend");

  @PostMapping
  public Message postMessage(@RequestBody Message message) {
    String username = message.getUser().getUsername();
    return new Message()
        .setUser(APP_USER)
        .setTimestamp(new Date().toString())
        .setMessage(username + " says: " + message.getMessage());
  }
}
