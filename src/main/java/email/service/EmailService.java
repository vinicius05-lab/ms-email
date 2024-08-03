package email.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import email.dto.EmailRequest;
import email.model.Email;
import email.repository.EmailRepository;
import email.status.EmailStatus;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    JavaMailSender emailSender;

    public ResponseEntity<Email> sendEmail(EmailRequest data){

        Email email = new Email(data);
        email.setSendDateEmail(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getBody());

            emailSender.send(message);
            email.setEmailStatus(EmailStatus.SENT);
            return ResponseEntity.ok(email);

        } catch (Exception e) {

            email.setEmailStatus(EmailStatus.ERROR);
            throw new RuntimeException(e.getMessage());
        }finally{
            emailRepository.save(email);
        }
    }
}
