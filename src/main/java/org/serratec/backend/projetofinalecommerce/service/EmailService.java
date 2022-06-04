package org.serratec.backend.projetofinalecommerce.service;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.serratec.backend.projetofinalecommerce.dto.PedidoDTO;
import org.serratec.backend.projetofinalecommerce.dto.ProdutoPedidoDTO;
import org.serratec.backend.projetofinalecommerce.entity.Pedido;
import org.serratec.backend.projetofinalecommerce.exceptions.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

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

	public void emailPedido(PedidoDTO pedido, String emailCliente, String nomeCliente) throws EmailException, MessagingException {
		double valorTotal = 0;
		
		this.emailSender = javaMailSender();
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		try {
			helper.setFrom("serratecRenan@gmail.com");
			helper.setTo(emailCliente);

			helper.setSubject("Pedido Gerado");

			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html> <p1>Parabéns ");
			sBuilder.append(nomeCliente);
			sBuilder.append(" seu pedido gerou a nota ");
			sBuilder.append(pedido.getPedidoNotaFiscal() + "<br><br>");
			sBuilder.append(" Produto(s) : <br>");
			for (ProdutoPedidoDTO produtoPedido : pedido.getListaProdutoPedido()) {
				sBuilder.append(" Nome Produto: " + produtoPedido.getNomeProduto() + "<br>");
				sBuilder.append(" Quantidade: " + produtoPedido.getQuantidadeProduto() + "<br>");
				sBuilder.append(" Valor unitário: R$ " + produtoPedido.getValorUnitario() + "<br><br>");
				valorTotal = valorTotal + (produtoPedido.getQuantidadeProduto() * produtoPedido.getValorUnitario());
			}
			sBuilder.append("Valor total: " + valorTotal);
			sBuilder.append("<p1></html>");
			helper.setText(sBuilder.toString(), true);

			emailSender.send(message);

		} catch (Exception e) {
			throw new EmailException("Houve um erro ao enviar esse email" + e.getMessage());

		}
	}

	public void emailEsqtoque(Pedido pedido) throws EmailException, MessagingException {

		this.emailSender = javaMailSender();
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		try {
			helper.setFrom("serratecRenan@gmail.com");
			helper.setTo("rfdrosana@gmail.com");

			helper.setSubject("Alerta posição de estoque!");

			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html> <p1>Atenção a quantidade de estoque do produto ");
			sBuilder.append(pedido.getProduto().getNomeProduto());
			sBuilder.append(" é de  ");
			sBuilder.append(pedido.getQuantidadeProduto());
			sBuilder.append(" unidades. <br><br>");
			sBuilder.append(" Por favor verificar reposição do item no estoque.");
			sBuilder.append("<p1></html>");

			helper.setText(sBuilder.toString(), true);

			emailSender.send(message);

		} catch (Exception e) {
			throw new EmailException("Houve um erro ao enviar esse email" + e.getMessage());

		}
	}

}
