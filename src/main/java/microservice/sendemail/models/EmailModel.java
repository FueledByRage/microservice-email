package microservice.sendemail.models;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import microservice.sendemail.enums.StatusEmail;


@Data
@Entity
@Table(name = "Email")
public class EmailModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ID;
    private String emailOwner;
    private String from;
    private String to;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDate;
    private StatusEmail status;

}
