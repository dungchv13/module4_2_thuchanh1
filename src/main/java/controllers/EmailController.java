package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    private final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public boolean isValidate(String input){
        Pattern patten = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = patten.matcher(input);

        return matcher.matches();
    }
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @PostMapping("/validate")
    public String validateEmail(@RequestParam("email") String email, Model model){
        boolean isvalid = this.isValidate(email);
        if (!isvalid) {
            model.addAttribute("message", "Email is invalid");
        }else{
            model.addAttribute("message", "Email is valid");
        }
        return "home";
    }

}
