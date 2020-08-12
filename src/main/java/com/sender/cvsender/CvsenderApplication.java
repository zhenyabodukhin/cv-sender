package com.sender.cvsender;

import com.sender.cvsender.service.impl.EmailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@SpringBootApplication
@RequiredArgsConstructor
public class CvsenderApplication {

  private final EmailServiceImpl emailService;

  public static void main(String[] args) {
    SpringApplication.run(CvsenderApplication.class, args);
  }

  @Bean
  public void getEmails() throws IOException {
    String fileName = "C:\\Cvsender\\itemail.txt";
    Path path = Paths.get(fileName);
    Scanner scanner = new Scanner(path);

    scanner.useDelimiter(System.getProperty("line.separator"));
    while (scanner.hasNext()) {
      Send(scanner.next());
    }
    scanner.close();
  }

  public void Send(String to) {
    File cv = new File("C:\\Cvsender\\forsender.pdf");
    try {
      emailService.sendEmail("zhenyabodukhin@gmail.com", to, cv);
      System.out.println("Отправлено " + to);
    } catch (MessagingException e) {
      System.out.println("Произошла ошибка " + to);
    }
  }
}
