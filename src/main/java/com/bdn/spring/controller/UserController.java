package com.bdn.spring.controller;

import com.bdn.spring.domain.Role;
import com.bdn.spring.domain.User;
import com.bdn.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model){
        model.addAttribute("users",userService.findAll());

        return "userList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user",user);
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(
            @RequestParam("userId") User user,
            @RequestParam Map<String,String> form,
            @RequestParam String username

            ){
        userService.saveUser(user,username,form);

        return "redirect:/user";
    }
    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email",user.getEmail());
        return "profile";
    }
    @PostMapping("profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String email
    ){
        userService.updateProfile(user,password,email);
        return "redirect:/user/profile";

    }

    @GetMapping("subscribers/{user}")
    public String subscribe(
            @PathVariable User user,
            @AuthenticationPrincipal User currentUser
    )
    {
        userService.subscribe(currentUser,user);
        return "redirect:/user-messages/"+user.getId();

    }

    @GetMapping("unsubscribe/{user}")
    public String unsubscribe(
            @PathVariable User user,
            @AuthenticationPrincipal User currentUser
    )
    {
        userService.unsubscribe(currentUser,user);
        return "redirect:/user-messages/"+user.getId();

    }
    @GetMapping("{type}/{user}/{list}")
    public String userList(
            Model model,
            @PathVariable User user,
            @PathVariable String type
    ){
        model.addAttribute("userChannel",user);
        model.addAttribute("type",type);

        if("subscriptions".equals(type)){
            model.addAttribute("users", user.getSubscriptions());
        }else {
            model.addAttribute("users", user.getSubscribers());
        }

        return "subscriptions";
    }
}
