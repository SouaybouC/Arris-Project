package fr.Aaris.configureTest.controller;

import fr.Aaris.configureTest.model.User;
import fr.Aaris.configureTest.repository.UserRepository;
import fr.Aaris.configureTest.service.GetUserDetails;
import fr.Aaris.configureTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("user")
public class UserProfileController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("profile")
    public String profile(Model model, @AuthenticationPrincipal GetUserDetails userDetails) {
        String email = userDetails.getUsername();
        User user = userRepository.findByEmail(email);
        model.addAttribute("user", user);

        return "user/profile";
    }

    @GetMapping("/edit/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "user/update-profile";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user,
                             BindingResult result) {

        String pass = user.getPassword();
        if (result.hasErrors()) {
            user.setId(id);
            return "user/update-profile";
        }

        user.setPassword(pass);
        userRepository.save(user);


        return "user/profile";
    }
}
