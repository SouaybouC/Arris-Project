package fr.Aaris.configureTest.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("admin")
public class AdminController {

    @GetMapping("index")
    @RolesAllowed("ADMIN")
    public String admin(){

        return"admin/index";
    }


}
