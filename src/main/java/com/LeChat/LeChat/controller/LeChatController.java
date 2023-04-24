package com.LeChat.LeChat.controller;

import java.util.List;

import com.LeChat.LeChat.model.Discussion;
import com.LeChat.LeChat.service.IDiscussionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeChatController {
  
  private final IDiscussionService discussionService;
  
  public LeChatController(IDiscussionService discussionService) {
    this.discussionService = discussionService;
  }

  @RequestMapping(value = "/discussions", method = RequestMethod.GET)
  public ResponseEntity<List<Discussion>> getDiscussions() {
    System.out.println("arrived");
    return discussionService.findAll();
  }
  
  @RequestMapping(value = "/discussions/{id}", method = RequestMethod.GET)
  public ResponseEntity<Discussion> getDiscussion(@PathVariable("id") String id) {
    return discussionService.findById(id);
  }
}