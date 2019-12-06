package glim.antony.tomotime.controllers;

import glim.antony.tomotime.entities.User;
import glim.antony.tomotime.services.UserService;
import glim.antony.tomotime.utils.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String profile(Principal principal, Model model){
        if(principal != null) {
            UserDTO user = new UserDTO(userService.findByEmail(principal.getName()));
            model.addAttribute("user", user);
        }
        return "profile";
    }

}
