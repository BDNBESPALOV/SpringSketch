package com.bdn.spring.repos;


import com.bdn.spring.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepos extends CrudRepository<Message, Long> {

   List<Message> findByTag(String tag);

}
