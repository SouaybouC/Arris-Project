package fr.Aaris.configureTest.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chatbot")
public class ChatbotController {

    @GetMapping("index")
    public String index(){
        return "chatbot/index";
    }

    @GetMapping("fenetre")
    public String fenetre(){
        return "chatbot/fenetre";
    }
}
