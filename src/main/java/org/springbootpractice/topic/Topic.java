package org.springbootpractice.topic;

import org.springbootpractice.subtopic.SubTopic;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Topic{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "TOPIC_SEQ")
    private int id;
    private String name;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
//    @JoinColumn(name = "topic_id", referencedColumnName = "id")
    private List<SubTopic> subtopic;

    public Topic() {
    }

    public Topic(int id, String name) {
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