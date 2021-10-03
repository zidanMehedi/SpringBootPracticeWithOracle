package org.springbootpractice.subtopic;

import org.springbootpractice.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubTopicServiceImpl implements SubTopicService {

    @Autowired
    private SubTopicRepository subTopicRepository;

    @Override
    public List<SubTopic> getAllSubTopics() {
        List<SubTopic> subTopic = new ArrayList<SubTopic>();
        subTopicRepository.findAll().forEach(subTopic::add);
        return subTopic;
    }

    @Override
    public SubTopic getSubTopic(int id) {
        return subTopicRepository.findOne(id);
    }

    @Override
    public SubTopic getSubTopicByTopic(int topicId, int id) {
        try {
            List<SubTopic> st = new ArrayList<SubTopic>();
            subTopicRepository.findByTopicId(topicId).forEach(st::add);
            return st.stream().filter(c->c.getId() == id).findFirst().get();
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public void addSubTopic(int topicId, SubTopic subTopic) {
        try {
            subTopic.setTopic(new Topic(topicId,""));
            subTopicRepository.save(subTopic);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateSubTopic(int topicId, SubTopic subTopic) {
        try {
            subTopic.setTopic(new Topic(topicId,""));
            subTopicRepository.save(subTopic);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteSubTopic(int id) {
        try {
            subTopicRepository.delete(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
