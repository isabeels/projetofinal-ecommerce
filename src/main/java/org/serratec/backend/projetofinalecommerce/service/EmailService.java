package org.serratec.backend.projetofinalecommerce.service;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.serratec.backend.projetofinalecommerce.entity.Pedido;
import org.serratec.backend.projetofinalecommerce.exceptions.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EmailService {
	
	@Autowired
	private JavaMailSender emailSender;
	
	@Value("${spring.mail.username}")
	private String username;
	
	@Value("${spring.mail.password}")
	private String senha;
	
	
private final String emailRemetente = "renan.ribeiro15@hotmail.com";
	
	public JavaMailSender javaMailSender() {
		
		JavaMailSenderImpl enviarEmail = new JavaMailSenderImpl();
		Properties prop = new Properties();
		
		enviarEmail.setHost("smtp.gmail.com");
		enviarEmail.setPort(465);
		enviarEmail.setUsername(username);
		enviarEmail.setPassword(senha);
		enviarEmail.setDefaultEncoding("UTF-8");
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.ssl.enable", true);
		enviarEmail.setJavaMailProperties(prop);
		
		return enviarEmail;
	}
	
	public void sendMessage(String to, String subject, String text) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(emailRemetente);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}
	
	public void emailPedido(Pedido pedido) throws  EmailException, MessagingException {
		
		this.emailSender = javaMailSender();
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		try {
			helper.setFrom("serratecRenan@gmail.com");
			helper.setTo("renan.ribeiro15@hotmail.com");
			
			helper.setSubject("Pedido Gerado");
			
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html> <p1>Parabéns " );
			sBuilder.append(pedido.getCliente().getNomeCliente());
			sBuilder.append(" seu pedido foi criado com número ");
			sBuilder.append(pedido.getIdPedido());
			sBuilder.append("<p1></html>");
			
			helper.setText(sBuilder.toString(), true);
			
			emailSender.send(message);
			
		} catch (Exception e) {
			throw new EmailException("Houve um erro ao enviar esse email" + e.getMessage());
			
			}
		}

}
