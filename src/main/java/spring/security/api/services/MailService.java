package spring.security.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import spring.security.api.Pojos.MailPojo;
import spring.security.api.config.AppConfig;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service("mailService")
public class MailService {

    @Autowired
    JavaMailSender mailSender;

    public void sendEmail(String mailTO, String subject, String content) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {

            MailPojo mail = setEmailParameters(mailTO, subject, content);

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject(mail.getMailSubject());
            mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom(), AppConfig.APP_EMAIL_ADDRESS));
            mimeMessageHelper.setTo(mail.getMailTo());
            mimeMessageHelper.setText(mail.getMailContent());

            mailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public MailPojo setEmailParameters(String mailTo, String subject, String content){
        MailPojo mail = new MailPojo();
        mail.setMailFrom(AppConfig.APP_EMAIL_ADDRESS);
        mail.setMailTo(mailTo);
        mail.setMailSubject(subject);
        mail.setMailContent(content);

        return mail;
    }

}
