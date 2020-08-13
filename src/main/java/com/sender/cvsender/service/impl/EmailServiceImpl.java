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
  public void sendEmail(String from, String to, File file) throws MessagingException {

    MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true);
    helper.setSubject("Java Developer");
    helper.setFrom(from);
    helper.setTo(to);
    helper.setReplyTo(from);
    helper.setText(getText().toString());
    helper.addAttachment("Junior_Java_Developer_Bodukhin.pdf", file);
    javaMailSender.send(message);
  }

  private StringBuilder getText() {
    StringBuilder sb = new StringBuilder();
    sb.append("Добрый день! Я, начинающий Java разработчик, в поисках своего первого места работы в данной сфере.");
    sb.append(System.lineSeparator());
    sb.append("Очень хочу получать новые знания, навыки, опыт в сфере IT.");
    sb.append(System.lineSeparator());
    sb.append("Надеюсь, что в Вашей компании имеется вакансия для такого специалиста, как Я.");
    sb.append(System.lineSeparator());
    sb.append(System.lineSeparator());
    sb.append("Ниже прикреплено мое резюме, которое, так же, содержит способы коммуникации со мной.");
    sb.append(System.lineSeparator());
    sb.append(System.lineSeparator());
    sb.append("Спасибо за уделенное время и хорошего рабочего дня Вам!");
    sb.append(System.lineSeparator());
    sb.append(System.lineSeparator());
    sb.append(System.lineSeparator());
    sb.append(System.lineSeparator());
    sb.append("С уважением, Бодухин Евгений.");

    return sb;
  }
}
