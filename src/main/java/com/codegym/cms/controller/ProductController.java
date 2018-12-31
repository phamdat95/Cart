package com.codegym.cms.controller;

import com.codegym.cms.model.Vote;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("vote")
public class ProductController {

    @GetMapping("/home")
    public String show(){
        return "/product/home";
    }

    @ModelAttribute("vote")
    public Vote setUpUserForm() {
        return new Vote();
    }

    @GetMapping("/home/p1")
    public String showP1(){
        return "/product/p1";
    }

    @PostMapping("/home/p1")
    public String result(@ModelAttribute("vote") Vote vote, Model model){
        if (vote.getQuantity().equals("0")){
            vote.setQuantity(null);
            model.addAttribute("message" , "Product wasn't added into your cart!");
        } else {
        model.addAttribute("message" , "Product was added into your cart!");
        }
        return "/product/p1";
    }

    @GetMapping("/home/cart")
    public String yourCart(@ModelAttribute("vote") Vote vote, Model model){
        if (vote.getQuantity() != null){
            int inter = Integer.parseInt(vote.getQuantity());
            model.addAttribute("inter", inter);
        }
        return "/product/cart";
    }

    @PostMapping("/home/cart")
    public String changeQuantity(Model model, @ModelAttribute("vote") Vote vote){
        int inter = Integer.parseInt(vote.getQuantity());
        model.addAttribute("inter", inter);
        model.addAttribute("message" , "Changed quantity of product success");
        return "/product/cart";
    }
    @PostMapping("/home/delete")
    public String deleteProduct(@ModelAttribute("vote") Vote vote){
        vote.setQuantity(null);
        return "redirect:cart";
    }
}
