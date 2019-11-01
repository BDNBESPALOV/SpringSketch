package com.bdn.spring.domain;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Заполни")
    @Length(max = 2048, message = "Привышен максимальный размер сообщения")
    private String text;
    @Length(max = 250, message = "Привышен максимальный размер teg")
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }




    public Message() {
    }
//    public Message(String tag) {
//        this.tag = tag;
//    }

    public Message( String text, String tag, User user) {
        this.author=user;
        this.text = text;
        this.tag = tag;
    }


    public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }
}
