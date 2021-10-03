package org.springbootpractice.subtopic;

import java.util.List;

public interface SubTopicService {

    public List<SubTopic> getAllSubTopics();
    public SubTopic getSubTopic(int id);
    public SubTopic getSubTopicByTopic(int topicId, int id);
    public void addSubTopic(int topicId, SubTopic subTopic);
    public void updateSubTopic(int topicId, SubTopic subTopic);
    public void deleteSubTopic(int id);
}
