package org.springbootpractice.subtopic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubTopicController {

    @Autowired
    private SubTopicService subTopicService;

    @RequestMapping("topics/subtopics")
    public List<SubTopicDTO> mapGetAllCourses(){
        return subTopicService.getAllSubTopics();
    }

    @RequestMapping("topics/subtopics/{id}")
    public SubTopicDTO mapGetCourse(@PathVariable int id){
        return subTopicService.getSubTopic(id);
    }

    @RequestMapping("topics/{topicId}/subtopics/{id}")
    public SubTopicDTO mapGetCourse(@PathVariable int topicId, @PathVariable int id){
        return subTopicService.getSubTopicByTopic(topicId, id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "topics/{topicId}/subtopics")
    public void mapAddCourse(@PathVariable int topicId, @RequestBody SubTopic subTopic){
        subTopicService.addSubTopic(topicId, subTopic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "topics/{topicId}/subtopics")
    public void mapUpdateCourse(@PathVariable int topicId, @RequestBody SubTopic subTopic){
        subTopicService.updateSubTopic(topicId, subTopic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "topics/subtopics/{id}")
    public void mapDeleteCourse(@PathVariable int id){
        subTopicService.deleteSubTopic(id);
    }
}
