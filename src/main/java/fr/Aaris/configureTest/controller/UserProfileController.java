package fr.Aaris.configureTest.controller;

import fr.Aaris.configureTest.model.User;
import fr.Aaris.configureTest.repository.UserRepository;
import fr.Aaris.configureTest.service.GetUserDetails;
import fr.Aaris.configureTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("user")
public class UserProfileController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("profile")
    public String profile(Model model, @AuthenticationPrincipal GetUserDetails userDetails){
        String email = userDetails.getUsername();
        User user = userRepository.findByEmail(email);
        model.addAttribute("user", user);

        return "user/profile";
    }
}
