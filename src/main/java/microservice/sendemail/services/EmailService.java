package microservice.sendemail.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import microservice.sendemail.repositories.EmailRepository;
import microservice.sendemail.enums.StatusEmail;
import microservice.sendemail.models.EmailModel;


@Service
public class EmailService {
    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public EmailModel sendEmail( EmailModel emailModel ){
		emailModel.setSendDate(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("${spring.rabbitmq.username}");
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatus(StatusEmail.SENT);
        } catch (Exception e) {
            System.out.println(e);
            emailModel.setStatus(StatusEmail.ERROR);
        } 
        System.out.println(emailModel);
        return emailRepository.save(emailModel);
	}
}
