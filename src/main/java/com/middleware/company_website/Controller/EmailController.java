package com.middleware.company_website.Controller;

import com.middleware.company_website.Entity.CareerPage;
import com.middleware.company_website.Entity.ContactUs;
import com.middleware.company_website.Entity.GetInTouch;
import com.middleware.company_website.Service.EmailService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/companyWebsite")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/contact")
    public String saveContactUs(@RequestBody ContactUs contactUs) {
        emailService.sendContactUsEmail(" info@middlewaretalents.com", contactUs);
        emailService.sendContactUsEmail("marketing@middlewaretalents.com", contactUs);
        return "Contact form submitted successfully!";
    }

    @PostMapping("/getInTouch")
    public String submitGetInTouch(@RequestBody GetInTouch getInTouch) {
        emailService.sendGetInTouchRequest("ksekhar@middlewaretalents.com", getInTouch);
        // emailService.sendGetInTouchRequest("marketing@middlewaretalents.com", getInTouch);
        return "Get in-touch request submitted successfully!";
    }

    @PostMapping("/careerPage")
    public String submitCareerPage(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("contactNo") Long contactNo,
            @RequestParam("country") String country,
            @RequestParam("applyingFor") String applyingFor,
            @RequestParam("skills") String skills,
            @RequestParam("resume")MultipartFile resume){
        try {
            CareerPage careerPage=new CareerPage();
            careerPage.setName(name);
            careerPage.setEmail(email);
            careerPage.setContactNo(contactNo);
            careerPage.setCountry(country);
            careerPage.setApplyingFor(applyingFor);
            careerPage.setSkills(skills);

            byte[] resumeBytes=null;
            String resumeFilename=null;
            if(resume != null && !resume.isEmpty()){
                resumeBytes = resume.getBytes();
                resumeFilename =resume.getOriginalFilename();
            }
            emailService.sendCareerEmailRequest("careers@middlewaretalents.com", careerPage, resumeBytes, resumeFilename);
            emailService.sendCareerEmailRequest("yamuna@middlewaretalents.com", careerPage, resumeBytes, resumeFilename);
            return "CareerPage form submitted successfully!";
        } catch (Exception e) {
            throw new RuntimeException("Error processing resume file ",e);
        }
    }
}
