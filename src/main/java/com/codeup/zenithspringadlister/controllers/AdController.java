package com.codeup.zenithspringadlister.controllers;

import com.codeup.zenithspringadlister.models.Ad;
import com.codeup.zenithspringadlister.models.User;
import com.codeup.zenithspringadlister.models.Users;
import com.codeup.zenithspringadlister.repository.AdRepository;
import com.codeup.zenithspringadlister.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdController {
    private final AdRepository adsDao;
    private final UserRepository usersDao;

    public AdController(AdRepository adsDao, UserRepository userDao){
        this.adsDao = adsDao;
        this.usersDao = userDao;
    }

    @GetMapping("/ads")
    public String allAds(Model model){
        model.addAttribute("ads", adsDao.findAll());
        return "/ads/index";
    }

    @GetMapping("/ads/create")
    public String postAdForm(){
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String postAd(@RequestParam(name="title") String title, @RequestParam(name="description") String description){
        User user = Users.randomUser(usersDao);
        Ad ad = new Ad(title, description, user);
        adsDao.save(ad);
        return "redirect:/ads";
    }

    @GetMapping("/ads/{id}")
    public String showOneAd(@PathVariable long id, Model model){
        Ad ad = adsDao.findById(id);
        model.addAttribute(ad == null? new Ad("not found", "Could not find that ad") : ad);
        return "/ads/show";
    }
}







