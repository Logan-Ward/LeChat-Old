package com.LeChat.LeChat.discussion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussionRepository extends CrudRepository<Discussion, String> {
  
}
