package ru.itis.servicecoffe.services;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.SpringTemplateLoader;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class MailServiceImpl implements MailService {
    @Autowired
    JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String emailFrom;
    private final Template confirmTemplate;

    public MailServiceImpl() {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateLoader(
                new SpringTemplateLoader(new ClassRelativeResourceLoader(this.getClass()), "/")
        );
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        try {
            this.confirmTemplate = configuration.getTemplate("templates/confirmMail.ftlh");
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void sendEmailForConfirm(String email, String code) {
        String emailText = getEmailText(code);
        MimeMessagePreparator mimeMessagePreparator = getEmail(email, emailText);
        javaMailSender.send(mimeMessagePreparator);
    }

    private MimeMessagePreparator getEmail(String email, String emailText){
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom(emailFrom);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject("Подтверждение пользователя");
            mimeMessageHelper.setText(emailText,true);
        };
        return mimeMessagePreparator;
    }

    private String getEmailText(String code){
        Map<String,String> attributes = new HashMap<>();
        attributes.put("confirmCode", code);

        StringWriter writer = new StringWriter();
        try {
            confirmTemplate.process(attributes, writer );
        } catch (TemplateException | IOException e) {
            throw new IllegalStateException(e);
        }
        return writer.toString();
    }
}
