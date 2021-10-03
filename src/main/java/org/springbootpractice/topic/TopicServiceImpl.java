package org.springbootpractice.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<Topic>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    @Override
    public Topic getTopic(int id) {
        return topicRepository.findOne(id);
    }

    @Override
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public void updateTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public void deleteTopic(int id) {
        topicRepository.delete(id);
    }
}
