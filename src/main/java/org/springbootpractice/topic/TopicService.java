package org.springbootpractice.topic;

import org.springframework.stereotype.Service;

import java.util.List;

public interface TopicService {

    public List<Topic> getAllTopics();
    public Topic getTopic(int id);
    public void addTopic(Topic topic);
    public void updateTopic(/*String id,*/ Topic topic);
    public void deleteTopic(int id);

}