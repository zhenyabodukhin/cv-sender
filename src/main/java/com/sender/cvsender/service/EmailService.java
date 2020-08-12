package com.sender.cvsender.service;

import javax.mail.MessagingException;
import java.io.File;

public interface EmailService {

  void sendEmail(String from, String to, File file) throws MessagingException;
}
