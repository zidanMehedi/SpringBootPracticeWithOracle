package org.springbootpractice.subtopic;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springbootpractice.topic.Topic;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class SubTopic implements Serializable {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ST_SEQ")
    @SequenceGenerator(name = "ST_SEQ", sequenceName = "SUBTOPIC_SEQ")
    private int id;

    @NonNull
    private String name;

    @ManyToOne
    private Topic topic;
}
