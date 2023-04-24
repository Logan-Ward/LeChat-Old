package com.LeChat.LeChat.service;

import java.util.List;

import com.LeChat.LeChat.model.Discussion;

import org.springframework.http.ResponseEntity;

public interface IDiscussionService {
  ResponseEntity<List<Discussion>> findAll();
  ResponseEntity<Discussion> findById(String id);
}
