package com.rama.springbootquickstart.courseapi.topic;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    List<Topic> topics =   Arrays.asList(
            new Topic("string", "spring framework","spring framework description"),
        new Topic("Java", "  Core Java","Core Java description"),
        new Topic("JavaScript", "JavaScript","JavaScript description")
        );
    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }
}
