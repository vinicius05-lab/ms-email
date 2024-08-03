# Sobre o funcionamento do Microservice:
Para que este microservice funcione corretamente na sua máquina você deve realizar as configurações corretas do banco de dados mysql e do JavaMailSender no "application.properties":

1. **Banco de Dados MySQL:**
   - Configure o acesso ao seu banco de dados MySQL no arquivo `application.properties`.
   - Exemplo:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost/mydbs
     spring.datasource.username=seu_usuario
     spring.datasource.password=sua_senha
     ```

2. **JavaMailSender:**
   - Configure o JavaMailSender com as credenciais de uma conta de email do Gmail.
   - É importante lembrar que você deve gerar uma senha de app do Google para que o JavaMailSender possa realizar o envio dos emails corretamente. [Clique aqui para saber como criar uma senha de app](https://support.google.com/accounts/answer/185833?hl=pt-BR).
   - Exemplo:
     ```properties
     spring.mail.host=smtp.gmail.com
     spring.mail.port=587
     spring.mail.username=seu_email@gmail.com
     spring.mail.password=sua_senha_de_app
     spring.mail.properties.mail.smtp.auth=true
     spring.mail.properties.mail.smtp.starttls.enable=true

# Sobre o envio de requisição:
As requisições devem ser feitas no seguinte formato JSON:
```json
{
  "sender": "Vinícius",
  "emailFrom": "sender@example.com",
  "emailTo": "recipient@example.com",
  "subject": "Meeting Reminder",
  "body": "Just a reminder about our meeting tomorrow at 10 AM."
}
```

# Descrição dos Campos:

- **sender:** Nome do remetente, ou seja, a pessoa que está enviando o email.
- **emailFrom:** Endereço de email do remetente.
- **emailTo:** Endereço de email do destinatário, ou seja, a pessoa que vai receber o email.
- **subject:** Título/assunto do email.
- **body:** Conteúdo do email em si.
