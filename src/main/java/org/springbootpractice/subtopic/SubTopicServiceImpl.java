package org.springbootpractice.subtopic;

import org.springbootpractice.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubTopicServiceImpl implements SubTopicService {

    @Autowired
    private SubTopicRepository subTopicRepository;

    @Override
    public List<SubTopicDTO> getAllSubTopics() {
        try{
            List<SubTopicDTO> subTopic = new ArrayList<SubTopicDTO>();
            subTopicRepository.findAll()
                    .stream().map(this::convertEntityToDTO)
                    .collect(Collectors.toList())
                    .forEach(subTopic::add);

            return subTopic;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public SubTopicDTO getSubTopic(int id) {
        try{
            SubTopicDTO subTopicDTO = new SubTopicDTO();
            SubTopic subTopic = new SubTopic();
            subTopic = subTopicRepository.findOne(id);
            subTopicDTO.setSubTopicId(subTopic.getId());
            subTopicDTO.setSubTopicName(subTopic.getName());

            return subTopicDTO;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public SubTopicDTO getSubTopicByTopic(int topicId, int id) {
        try {
            List<SubTopicDTO> st = new ArrayList<SubTopicDTO>();
            subTopicRepository.findByTopicId(topicId).stream().map(this::convertEntityToDTO).forEach(st::add);
            return st.stream().filter(c->c.getSubTopicId() == id).findFirst().get();
        }catch(Exception e){
            return null;
        }
    }

    public SubTopicDTO convertEntityToDTO(SubTopic subTopic){
        SubTopicDTO subTopicDTO = new SubTopicDTO();
        subTopicDTO.setSubTopicId(subTopic.getId());
        subTopicDTO.setSubTopicName(subTopic.getName());

        return subTopicDTO;
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
