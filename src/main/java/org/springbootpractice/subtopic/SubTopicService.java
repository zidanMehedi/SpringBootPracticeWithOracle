package org.springbootpractice.subtopic;

import java.util.List;

public interface SubTopicService {

    public List<SubTopicDTO> getAllSubTopics();
    public SubTopicDTO getSubTopic(int id);
    public SubTopicDTO getSubTopicByTopic(int topicId, int id);
    public void addSubTopic(int topicId, SubTopic subTopic);
    public void updateSubTopic(int topicId, SubTopic subTopic);
    public void deleteSubTopic(int id);
}
