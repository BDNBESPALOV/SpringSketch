package com.bdn.spring.repos;


import com.bdn.spring.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepos extends CrudRepository<Message, Integer> {
}
