package glim.antony.tomotime.services.email;


import glim.antony.tomotime.utils.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class MailService {
    private JavaMailSender sender;
    private MailMessageBuilder messageBuilder;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Autowired
    public void setSender(JavaMailSender sender) {
        this.sender = sender;
    }

    @Autowired
    public void setMessageBuilder(MailMessageBuilder messageBuilder) {
        this.messageBuilder = messageBuilder;
    }

    private void sendMail(String email, String subject, String text) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        try {
            helper.setTo(email);
            helper.setText(text, true);
            helper.setSubject(subject);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            executorService.submit(() -> sender.send(message));
        } catch (MailException e) {
            e.printStackTrace();
        }
    }

    public void sendConfirmMail(UserDTO userDTO) {
        sendMail(
                userDTO.getEmail(),
                String.format("%s, поздравляем с успешной регистраццией!", userDTO.getFirstName()),
                messageBuilder.buildRegistrationConfirmMail(userDTO)
        );
    }
}