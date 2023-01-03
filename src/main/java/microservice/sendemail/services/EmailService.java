package microservice.sendemail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservice.sendemail.repositories.EmailRepository;

@Service
public class EmailService {
    @Autowired
    EmailRepository emailRepository;
}
