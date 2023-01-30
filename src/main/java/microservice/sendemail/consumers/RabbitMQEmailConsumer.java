package microservice.sendemail.consumers;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import microservice.sendemail.dtos.EmailDTO;
import microservice.sendemail.models.EmailModel;
import microservice.sendemail.services.EmailService;

@Component
public class RabbitMQEmailConsumer {
    
    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen( @Payload  EmailDTO emailDto){
        EmailModel emailModel = new EmailModel();

        BeanUtils.copyProperties(emailDto, emailModel);

        emailService.sendEmail(emailModel);
    }
    
}
