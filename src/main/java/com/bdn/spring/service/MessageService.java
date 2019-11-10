package com.bdn.spring.service;

import com.bdn.spring.domain.Message;
import com.bdn.spring.domain.User;
import com.bdn.spring.repos.MessageRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepos messageRepo;

    public Page<Message> messageList(Pageable pageable,String filter ){
        if (filter != null && !filter.isEmpty()) {
            return messageRepo.findByTag(filter,pageable);
        } else {
            return messageRepo.findAll(pageable);
        }
    }

    public Page<Message> messageListFromUser(Pageable pageable, User author) {
       return messageRepo.findByUser(pageable,author);
    }
}
