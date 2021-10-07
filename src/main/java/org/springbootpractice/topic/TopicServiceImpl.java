package org.springbootpractice.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<TopicDTO> getAllTopics() {
        try{
            List<TopicDTO> topics = new ArrayList<TopicDTO>();
            topicRepository.findAll()
                    .stream().map(this::convertEntityToDTO)
                    .collect(Collectors.toList())
                    .forEach(topics::add);

            return topics;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public TopicDTO getTopic(int id) {
        try{
            TopicDTO topicDTO = new TopicDTO();
            Topic topic = new Topic();
            topic = topicRepository.findOne(id);
            topicDTO.setTopicId(topic.getId());
            topicDTO.setTopicName(topic.getName());

            return topicDTO;
        }catch (Exception e){
            return null;
        }
    }

    public TopicDTO convertEntityToDTO(Topic topic){
        TopicDTO topicDTO = new TopicDTO();
        topicDTO.setTopicId(topic.getId());
        topicDTO.setTopicName(topic.getName());

        return topicDTO;
    }

    @Override
    public void addTopic(Topic topic) {
        try{topicRepository.save(topic);}
        catch(Exception e){
            System.out.println(e.getMessage());
        };
    }

    @Override
    public void updateTopic(Topic topic) {
        try{topicRepository.save(topic);}
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteTopic(int id) {
        try{topicRepository.delete(id);}
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
