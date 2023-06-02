package rs.ftn.uns.btb.core.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String body, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("skstefankalicanin@gmail.com");
        message.setTo(to);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail send...");

    }


    
}
