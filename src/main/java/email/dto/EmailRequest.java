package email.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailRequest(

    @NotBlank
    String sender,

    @NotBlank
    String emailFrom,

    @NotBlank
    @Email
    String emailTo,

    @NotBlank
    String subject,

    @NotBlank
    String body
) {}
