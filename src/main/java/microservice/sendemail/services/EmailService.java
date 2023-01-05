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
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailFrom());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);
            emailModel.setStatus(StatusEmail.SENT);
        } catch (Exception e) {
            emailModel.setStatus(StatusEmail.ERROR);
        } 
        return emailRepository.save(emailModel);
	}
}
