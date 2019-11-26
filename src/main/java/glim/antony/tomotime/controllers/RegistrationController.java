package glim.antony.tomotime.controllers;

import glim.antony.tomotime.entities.User;
import glim.antony.tomotime.services.UserService;
import glim.antony.tomotime.utils.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @InitBinder //отпилит все пробелы
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("")
    public String showMyLoginPage(Model model) {
        model.addAttribute("systemUser", new SystemUser());
        return "registration-form";
    }

    @PostMapping("/process")
    public String processRegistrationForm(
            @Valid @ModelAttribute("systemUser") SystemUser systemUser,
            BindingResult bindingResult,
            Model model
    ){
        String userEmail = systemUser.getEmail();
        if (bindingResult.hasErrors()) { //если что-то не так
            return "registration-form";
        }
        User existingUser = userService.findByEmail(userEmail);
        if (existingUser != null) {
            // theSystemUser.setUserName(null);
            model.addAttribute("systemUser", systemUser);
            model.addAttribute("registrationError", "User with current username is already exist");
            return "registration-form";
        }
        userService.save(systemUser);
        return "registration-confirmation";
    }
}
