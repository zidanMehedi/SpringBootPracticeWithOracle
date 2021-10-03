package org.springbootpractice.subtopic;

import org.springbootpractice.topic.Topic;

import javax.persistence.*;

@Entity
public class SubTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ST_SEQ")
    @SequenceGenerator(name = "ST_SEQ", sequenceName = "SUBTOPIC_SEQ")
    private int id;
    private String name;

    @ManyToOne
    private Topic topic;

    public SubTopic() {
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public SubTopic(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
