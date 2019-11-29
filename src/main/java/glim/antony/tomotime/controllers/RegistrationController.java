package glim.antony.tomotime.controllers;

import glim.antony.tomotime.entities.User;
import glim.antony.tomotime.services.UserService;
import glim.antony.tomotime.services.email.MailService;
import glim.antony.tomotime.utils.SystemUser;
import glim.antony.tomotime.utils.dto.UserDTO;
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
    private MailService mailService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
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
        existingUser = userService.save(systemUser);
        mailService.sendConfirmMail(new UserDTO(existingUser));
        return "registration-confirmation";
    }
}
