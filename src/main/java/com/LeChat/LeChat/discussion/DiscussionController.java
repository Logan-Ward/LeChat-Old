package com.LeChat.LeChat.discussion;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DiscussionController {
  
  private final DiscussionService discussionService;
  
  public DiscussionController(DiscussionService discussionService) {
    this.discussionService = discussionService;
  }

  @RequestMapping(value = "/discussions", method = RequestMethod.GET)
  public ResponseEntity<List<Discussion>> getDiscussions() {
    // discussionService.addDiscussion(new Discussion("asjvbskjc", "ajkbdcjcnjcjncsdnjkc", new String[] { "aol", "john", "doe" }));
    // discussionService.addDiscussion(new Discussion("bsjvbskjc", "bjkbdcjcnjcjncsdnjkc", new String[] { "bol", "john", "doe" }));
    // discussionService.addDiscussion(new Discussion("csjvbskjc", "cjkbdcjcnjcjncsdnjkc", new String[] { "col", "john", "doe" }));
    return discussionService.findAll();
  }
  
  @RequestMapping(value = "/discussions/{id}", method = RequestMethod.GET)
  public ResponseEntity<Discussion> getDiscussion(@PathVariable("id") String id) {
    return discussionService.findById(id);
  }
}