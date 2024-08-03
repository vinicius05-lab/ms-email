package email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import email.dto.EmailRequest;
import email.model.Email;
import email.service.EmailService;
import jakarta.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;
    
    @PostMapping("/email")
    public ResponseEntity<Email> sendEmail(@RequestBody @Valid EmailRequest data){
        return emailService.sendEmail(data);
    }
}
