package com.bdn.spring.domain;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Message {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String text;
    private String tag;

    public Message() {
    }

    public Message(Integer id, String text, String tag) {
        this.id = id;
        this.text = text;
        this.tag = tag;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }
}
