package com.codeup.zenithspringadlister.controllers;

import com.codeup.zenithspringadlister.models.Ad;
import com.codeup.zenithspringadlister.models.User;
import com.codeup.zenithspringadlister.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository usersDao;

    public UserController(UserRepository usersDao){
        this.usersDao = usersDao;
    }
    @GetMapping("/register")
    public String goToRegister(){
        return "/registration";
    }


    @PostMapping("/register")
    public String registerUser(@RequestParam(name="username") String username, @RequestParam(name="email") String email, @RequestParam(name="password") String password){
        User user = new User(username, email, password);
        usersDao.save(user);
        return "redirect:/ads";
    }

    @GetMapping("/user/{id}/ads")
    public String userAds(@PathVariable long id, Model model){
        User user = usersDao.findById(id).get();
        List<Ad> userAds = user.getAds();
        model.addAttribute("userAds", userAds);
        return "/ads/userAds";
    }
}
