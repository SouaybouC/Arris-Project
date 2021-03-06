package fr.Aaris.configureTest.web;

import fr.Aaris.configureTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("user")
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("profile")
    public String profile(Model model, Principal principal) {
        String name = principal.getName();
        model.addAttribute("user", userService.loadUserByUsername(name));

        return "user/profile";
    }
}
