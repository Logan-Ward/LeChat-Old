package com.LeChat.LeChat.model;

public class Discussion {
  public String id;
  public String topic;
  String description;
  String creatorId;
  String[] moderators;
  public String[] participants;
  
  public Discussion(String idx, String topicx, String[] participantsx) {
    id = idx;
    topic = topicx;
    participants = participantsx;
  }
}
