package com.middleware.company_website.Service;

import com.middleware.company_website.Entity.CareerPage;
import com.middleware.company_website.Entity.ContactUs;
import com.middleware.company_website.Entity.GetInTouch;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void sendContactUsEmail(String adminEmail, ContactUs contactUs) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(adminEmail);
            helper.setSubject("New Contact Inquiry from " + contactUs.getLastName() + " " + contactUs.getFirstName());

            String htmlContent = String.format("""
                            <!DOCTYPE html>
                            <html lang="en">
                            <head>
                                <meta charset="UTF-8">
                                <style>
                                    body {
                                        margin: 0;
                                        padding: 0;
                                        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                                        background-color: #f4f4f7;
                                        color: #333;
                                    }
                                    .container {
                                        max-width: 600px;
                                        margin: 20px auto;
                                        background-color: #ffffff;
                                        padding: 30px;
                                        border-radius: 10px;
                                        box-shadow: 0 4px 20px rgba(0,0,0,0.05);
                                    }
                                    .header {
                                        text-align: center;
                                        border-bottom: 1px solid #ddd;
                                        padding-bottom: 15px;
                                        margin-bottom: 20px;
                                    }
                                    .header h2 {
                                        margin: 0;
                                        color: #4A90E2;
                                    }
                                    .section {
                                        margin-bottom: 20px;
                                    }
                                    .section h4 {
                                        margin-bottom: 8px;
                                        color: #333;
                                    }
                                    .section p {
                                        margin: 0;
                                        font-size: 15px;
                                        line-height: 1.5;
                                    }
                                    .footer {
                                        border-top: 1px solid #ddd;
                                        padding-top: 15px;
                                        text-align: center;
                                        font-size: 12px;
                                        color: #888;
                                    }
                                    @media (max-width: 768px) {
                                        .container {
                                            margin: 10px;
                                            padding: 20px;
                                        }
                                        .section p {
                                            font-size: 14px;
                                        }
                                    }
                                    @media (max-width: 480px) {
                                        .container {
                                            padding: 15px;
                                        }
                                        .header h2 {
                                            font-size: 20px;
                                        }
                                        .section h4 {
                                            font-size: 16px;
                                        }
                                        .section p {
                                            font-size: 13px;
                                        }
                                    }
                                </style>
                            </head>
                            <body>
                                <div class="container">
                                    <div class="header">
                                        <h2>New Contact Us Inquiry</h2>
                                    </div>
                                    <div class="section">
                                        <h4>Name:</h4>
                                        <p>%s %s</p>
                                    </div>
                                    <div class="section">
                                        <h4>Role:</h4>
                                        <p>%s</p>
                                    </div>
                                    <div class="section">
                                        <h4>Country:</h4>
                                        <p>%s</p>
                                    </div>
                                    <div class="section">
                                        <h4>Email:</h4>
                                        <p>%s</p>
                                    </div>
                                    <div class="section">
                                        <h4>Message:</h4>
                                        <p>%s</p>
                                    </div>
                                    <div class="footer">
                                        This email was generated automatically from the Contact Us form.
                                    </div>
                                </div>
                            </body>
                            </html>
                            """,
                    contactUs.getFirstName(),
                    contactUs.getLastName(),
                    contactUs.getRole(),
                    contactUs.getCountry(),
                    contactUs.getEmail(),
                    contactUs.getMessageForUs());

            helper.setText(htmlContent, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Error sending contact email", e);
        }
    }


    public void sendGetInTouchRequest(String touchEmail, GetInTouch getInTouch) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(touchEmail);
            helper.setSubject("Get In-Touch Request from " + getInTouch.getLastName() + " " + getInTouch.getFirstName());

            String htmlContent = String.format("""
                            <!DOCTYPE html>
                            <html lang="en">
                            <head>
                                <meta charset="UTF-8">
                                <style>
                                    body {
                                        margin: 0;
                                        padding: 0;
                                        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                                        background-color: #f8f9fa;
                                        color: #212529;
                                    }
                            
                                    .email-wrapper {
                                        max-width: 600px;
                                        margin: 20px auto;
                                        background: #ffffff;
                                        border-radius: 10px;
                                        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
                                        padding: 30px;
                                    }
                            
                                    .email-header {
                                        text-align: center;
                                        margin-bottom: 30px;
                                    }
                            
                                    .email-header h2 {
                                        margin: 0;
                                        color: #007bff;
                                        font-size: 24px;
                                    }
                            
                                    .info-block {
                                        margin-bottom: 20px;
                                    }
                            
                                    .info-block label {
                                        font-weight: bold;
                                        display: block;
                                        margin-bottom: 5px;
                                        color: #343a40;
                                    }
                            
                                    .info-block p {
                                        margin: 0;
                                        font-size: 15px;
                                        line-height: 1.5;
                                        color: #495057;
                                    }
                            
                                    .email-footer {
                                        margin-top: 30px;
                                        text-align: center;
                                        font-size: 12px;
                                        color: #6c757d;
                                        border-top: 1px solid #dee2e6;
                                        padding-top: 15px;
                                    }
                            
                                    @media (max-width: 768px) {
                                        .email-wrapper {
                                            padding: 20px;
                                            margin: 10px;
                                        }
                                    }
                            
                                    @media (max-width: 480px) {
                                        .email-wrapper {
                                            padding: 15px;
                                        }
                            
                                        .email-header h2 {
                                            font-size: 20px;
                                        }
                                    }
                                </style>
                            </head>
                            <body>
                                <div class="email-wrapper">
                                    <div class="email-header">
                                        <h2>New Get In-Touch Request</h2>
                                    </div>
                            
                                    <div class="info-block">
                                        <label>Name:</label>
                                        <p>%s %s</p>
                                    </div>
                            
                                    <div class="info-block">
                                        <label>Company:</label>
                                        <p>%s</p>
                                    </div>
                            
                                    <div class="info-block">
                                        <label>Email:</label>
                                        <p>%s</p>
                                    </div>
                            
                                    <div class="info-block">
                                        <label>Message:</label>
                                        <p>%s</p>
                                    </div>
                            
                                    <div class="email-footer">
                                        This message was submitted via the Get In-Touch form on your website.
                                    </div>
                                </div>
                            </body>
                            </html>
                            """,
                    getInTouch.getFirstName(),
                    getInTouch.getLastName(),
                    getInTouch.getCompany(),
                    getInTouch.getEmail(),
                    getInTouch.getMessageForUs()
            );

            helper.setText(htmlContent, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


    public void sendCareerEmailRequest(String careerEmail, CareerPage careerPage, byte[] resumeBytes, String resumeFilename) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(careerEmail);
            helper.setSubject("New Career Application from " + careerPage.getName());

            String htmlContent = String.format("""
                            <!DOCTYPE html>
                            <html lang="en">
                            <head>
                                <meta charset="UTF-8">
                                <style>
                                    body {
                                        margin: 0;
                                        padding: 0;
                                        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                                        background-color: #f4f4f7;
                                        color: #333;
                                    }
                            
                                    .container {
                                        max-width: 600px;
                                        margin: 20px auto;
                                        background-color: #ffffff;
                                        padding: 30px;
                                        border-radius: 10px;
                                        box-shadow: 0 4px 20px rgba(0,0,0,0.05);
                                    }
                            
                                    .header {
                                        text-align: center;
                                        border-bottom: 1px solid #ddd;
                                        padding-bottom: 15px;
                                        margin-bottom: 20px;
                                    }
                            
                                    .header h2 {
                                        margin: 0;
                                        color: #4A90E2;
                                    }
                            
                                    .section {
                                        margin-bottom: 20px;
                                    }
                            
                                    .section h4 {
                                        margin-bottom: 8px;
                                        color: #333;
                                    }
                            
                                    .section p {
                                        margin: 0;
                                        font-size: 15px;
                                        line-height: 1.5;
                                    }
                            
                                    .footer {
                                        border-top: 1px solid #ddd;
                                        padding-top: 15px;
                                        text-align: center;
                                        font-size: 12px;
                                        color: #888;
                                    }
                            
                                    @media (max-width: 768px) {
                                        .container {
                                            margin: 10px;
                                            padding: 20px;
                                        }
                                        .section p {
                                            font-size: 14px;
                                        }
                                    }
                            
                                    @media (max-width: 480px) {
                                        .container {
                                            padding: 15px;
                                        }
                                        .header h2 {
                                            font-size: 20px;
                                        }
                                        .section h4 {
                                            font-size: 16px;
                                        }
                                        .section p {
                                            font-size: 13px;
                                        }
                                    }
                                </style>
                            </head>
                            <body>
                                <div class="container">
                                    <div class="header">
                                        <h2>New Career Application</h2>
                                    </div>
                            
                                    <div class="section">
                                        <h4>Name:</h4>
                                        <p>%s</p>
                                    </div>
                            
                                    <div class="section">
                                        <h4>Email:</h4>
                                        <p>%s</p>
                                    </div>
                            
                                    <div class="section">
                                        <h4>Contact Number:</h4>
                                        <p>%s</p>
                                    </div>
                            
                                    <div class="section">
                                        <h4>Country:</h4>
                                        <p>%s</p>
                                    </div>
                            
                                    <div class="section">
                                        <h4>Applying For:</h4>
                                        <p>%s</p>
                                    </div>
                            
                                    <div class="section">
                                        <h4>Skills:</h4>
                                        <p>%s</p>
                                    </div>
                            
                                    <div class="section">
                                        <h4>Resume:</h4>
                                        <p><strong>%s</strong> is attached with this email.</p>
                                    </div>
                            
                                    <div class="footer">
                                        This email was generated automatically from the Career Page.
                                    </div>
                                </div>
                            </body>
                            </html>
                            """,
                    careerPage.getName(),
                    careerPage.getEmail(),
                    careerPage.getContactNo(),
                    careerPage.getCountry(),
                    careerPage.getApplyingFor(),
                    careerPage.getSkills(),
                    resumeFilename
            );

            helper.setText(htmlContent, true);

            if (resumeBytes != null && resumeFilename != null) {
                helper.addAttachment(resumeFilename, new ByteArrayResource(resumeBytes));
            }

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Error sending career email", e);
        }
    }


}
