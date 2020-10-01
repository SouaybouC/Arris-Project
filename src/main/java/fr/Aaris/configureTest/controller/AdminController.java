package fr.Aaris.configureTest.controller;


import fr.Aaris.configureTest.repository.CommandeRepository;
import fr.Aaris.configureTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommandeRepository commandeRepository;
    @GetMapping("profile")
    public String admin() {
        return "admin/profile";
    }

    @GetMapping("users")
    public String listUser(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin/users";
    }

    @GetMapping("user/commande")
    public String commmande(){


        return "admin/commandes";
    }
}
