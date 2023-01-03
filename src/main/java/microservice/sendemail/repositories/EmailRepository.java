package microservice.sendemail.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import microservice.sendemail.models.EmailModel;


public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
    
}
