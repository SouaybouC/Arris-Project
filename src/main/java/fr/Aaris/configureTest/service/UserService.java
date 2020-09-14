package fr.Aaris.configureTest.service;

import fr.Aaris.configureTest.model.User;
import fr.Aaris.configureTest.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

    
}
