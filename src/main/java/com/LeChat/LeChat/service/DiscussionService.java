package com.LeChat.LeChat.service;


import java.util.ArrayList;
import java.util.List;

import com.LeChat.LeChat.model.Discussion;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DiscussionService implements IDiscussionService {
  
  private final List<Discussion> discussions = new ArrayList<>();
  
  public DiscussionService() {
    discussions.add(new Discussion("asjvbskjc", "ajkbdcjcnjcjncsdnjkc", new String[] {"aol", "john", "doe"}));
    discussions.add(new Discussion("bsjvbskjc", "bjkbdcjcnjcjncsdnjkc", new String[] {"bol", "john", "doe"}));
    discussions.add(new Discussion("csjvbskjc", "cjkbdcjcnjcjncsdnjkc", new String[] {"col", "john", "doe"}));
  }
  
  @Override
  public ResponseEntity<List<Discussion>> findAll() {
    return ResponseEntity.ok(discussions);
  }
  
  public ResponseEntity<Discussion> findById(String id) {
    
    for(int i = 0; i < discussions.size(); i++) {
      if(discussions.get(i).id == id) {
        return ResponseEntity.ok(discussions.get(i));
      }
    }
    
    return ResponseEntity.notFound().build();
  }
}
