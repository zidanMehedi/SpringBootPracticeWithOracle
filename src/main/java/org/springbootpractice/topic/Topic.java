package org.springbootpractice.topic;

import lombok.*;
import org.springbootpractice.subtopic.SubTopic;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Topic implements Serializable{

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "TOPIC_SEQ")
    private int id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)               // Remove mappedBy incase of using Unidirectional Relation
//    @JoinColumn(name = "topic_id", referencedColumnName = "id")           // Uncomment this line for Unidirectional Relation
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private List<SubTopic> subtopic;
}