package com.LeChat.LeChat.discussion;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Discussion")
public class Discussion implements Serializable {
  public String id;
  public String topic;
  String description;
  String creatorId;
  String[] moderators;
  public String[] participants;
  
  public Discussion(String id, String topic, String[] participants) {
    this.id = id;
    this.topic = topic;
    this.participants = participants;
  }
}
