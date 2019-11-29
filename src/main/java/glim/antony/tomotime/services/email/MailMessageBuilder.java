package glim.antony.tomotime.services.email;


import glim.antony.tomotime.entities.Task;
import glim.antony.tomotime.utils.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailMessageBuilder {
    private TemplateEngine templateEngine; //обработчик таймлифа

    @Autowired
    public void setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String buildRegistrationConfirmMail(UserDTO userDTO) {
        Context context = new Context();
        context.setVariable("userDTO", userDTO); //context здесь что-то вроде model
        return templateEngine.process("registration-confirm-mail", context);
    }
}
