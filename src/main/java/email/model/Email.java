package email.model;

import java.time.LocalDateTime;

import email.dto.EmailRequest;
import email.status.EmailStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "emails")
public class Email {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sender;

    @Column(name = "email_from", nullable = false)
    private String emailFrom;

    @Column(name = "email_to", nullable = false)
    private String emailTo;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String body;

    @Column(name = "send_date_email", nullable = false)
    private LocalDateTime sendDateEmail;

    @Column(name = "status_email", nullable = false)
    private EmailStatus emailStatus;

    public Email(EmailRequest data){
        this.sender = data.sender();
        this.emailFrom = data.emailFrom();
        this.emailTo = data.emailTo();
        this.subject = data.subject();
        this.body = data.body();
    }
}