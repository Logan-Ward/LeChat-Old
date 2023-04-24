package com.LeChat.LeChat.discussion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DiscussionService {

  @Autowired
  DiscussionRepository discussionRepository;

  public Discussion addDiscussion(Discussion discussion) {
    return discussionRepository.save(discussion);
  }

  public ResponseEntity<List<Discussion>> findAll() {

    List<Discussion> discussions = new ArrayList<Discussion>();
    discussionRepository.findAll().forEach(discussions::add);
    return ResponseEntity.ok(discussions);
  }

  public ResponseEntity<Discussion> findById(String id) {

    if (discussionRepository.existsById(id)) {
      return ResponseEntity.ok(discussionRepository.findById(id).get());
    }

    return ResponseEntity.notFound().build();
  }
}
