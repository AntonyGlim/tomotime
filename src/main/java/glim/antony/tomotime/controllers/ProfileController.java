package glim.antony.tomotime.controllers;

import glim.antony.tomotime.entities.User;
import glim.antony.tomotime.services.UserService;
import glim.antony.tomotime.utils.SystemUser;
import glim.antony.tomotime.utils.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/edit")
    public String showEditForm(
            Model model,
            Principal principal,
            @RequestParam(name = "id", required = false) Long id
    ) {
        if(principal != null && id != null && principal.getName().equals(userService.findById(id).getEmail())) {
            UserDTO user = new UserDTO(userService.findByEmail(principal.getName()));
            model.addAttribute("user", user);
        }
        return "edit-profile-form";
    }

    @PostMapping("/edit/process")
    public String processAddOrEdit(
            @ModelAttribute("user") UserDTO userDTO,
            Principal principal
    ) {
        System.out.println(userDTO);
        userService.updateFirstAndLastName(userDTO);
        return "redirect:/profile";
    }

}
