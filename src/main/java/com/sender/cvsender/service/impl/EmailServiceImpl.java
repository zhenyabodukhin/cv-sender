package com.sender.cvsender.service.impl;

import com.sender.cvsender.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

  private final JavaMailSender javaMailSender;

  @Override
  public void sendEmail(String subject, String from, String to, File file) throws MessagingException {
      MimeMessage message = javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true);
      helper.setSubject(subject);
      helper.setFrom(from);
      helper.setTo(to);
      helper.setReplyTo(from);
      helper.setText("Добрый день, Клава!", false);
      helper.addAttachment("Junior_Java_Developer_Bodukhin.pdf", file);
      javaMailSender.send(message);
  }
}
