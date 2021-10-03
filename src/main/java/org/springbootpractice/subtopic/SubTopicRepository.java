package org.springbootpractice.subtopic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubTopicRepository extends JpaRepository<SubTopic, Integer>{

    public List<SubTopic> findByTopicId(int topicId);
}
