package com.bdn.spring.controller;

import com.bdn.spring.domain.Message;
import com.bdn.spring.domain.User;
import com.bdn.spring.repos.MessageRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepos messagesRepos;

    @GetMapping("/")
    public String greeting( Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model){
        Iterable<Message> messages = messagesRepos.findAll();
        if(filter !=null && !filter.isEmpty()){
            messages = messagesRepos.findByTag(filter);
        }else {
            messages = messagesRepos.findAll();
        }
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
    return "main";
    }

    @PostMapping("add")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model){
        Message message = new Message(text,tag,user);
        messagesRepos.save(message);
        Iterable<Message> messages = messagesRepos.findAll();
        model.put("messages",messages);
        return "main";

    }




//    @PostMapping("filter")
//    public String filter(@RequestParam String filter,  Map<String, Object> model){
//        Iterable<Message> messages;
//        if(filter !=null && !filter.isEmpty()){
//            messages = messagesRepos.findByTag(filter);
//        }else {
//            messages = messagesRepos.findAll();
//        }
//        model.put("messages",messages);
//        return "main";
//    }



    @PostMapping("delete")
    public String delete( Map<String, Object> model, String  id){
        Iterable<Message> messages;
        try{
            Integer Iid = Integer.parseInt(id+"");
            if( messagesRepos.existsById(Iid)){
                messagesRepos.deleteById(Iid);
            }
        }catch (NumberFormatException e){
            System.out.println("Заглушка NumberFormatException");
        }finally {
            messages = messagesRepos.findAll();
            model.put("messages",messages);
        }
        return "main";
    }


}