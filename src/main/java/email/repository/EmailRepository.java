package email.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import email.model.Email;

public interface EmailRepository extends JpaRepository<Email, Long>{}