package com.middleware.company_website;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String redirect() {
        return "forward:/index.html";
    }

    @RequestMapping("/{path:[^\\.]*}")
    public String forward() {
        return "forward:/index.html";
    }

    @GetMapping("/index.php")
    public String redirectIndex() {
        return "redirect:/index.html";
    }

    @GetMapping("/about-middleware-talents.php")
    public String redirectAbout() {
        return "redirect:/index.html";
    }

    @GetMapping("/contact-middleware-talents.php")
    public String redirectContact() {
        return "redirect:/index.html";
    }

    @GetMapping("/services-offering.php")
    public String redirectServices() {
        return "redirect:/index.html";
    }

    @GetMapping("/recruitment-middleware-talents.php")
    public String redirectReceuitment() {
        return "redirect:/index.html";
    }

    @GetMapping("/consulting-middleware-talents.php")
    public String redirectConsulting() {
        return "redirect:/index.html";
    }

    @GetMapping("/managed-service-provider.php")
    public String redirectManaged() {
        return "redirect:/index.html";
    }

    @GetMapping("/contract-staffing.php")
    public String redirectContract() {
        return "redirect:/index.html";
    }

    @GetMapping("/permanent-staffing.php")
    public String redirectPermanent() {
        return "redirect:/index.html";
    }

    @GetMapping("/recruitment-process-outsourcing.php")
    public String redirectRecruitment() {
        return "redirect:/index.html";
    }

   

    @GetMapping("/technologies-middleware-talents.php")
    public String redirectTechnologies() {
        return "redirect:/index.html";
    }

    @GetMapping("/software-development.php")
    public String redirectSoftware() {
        return "redirect:/index.html";
    }

    @GetMapping("/cyber-and-cloud-security.php")
    public String redirectCyberAndCloud() {
        return "redirect:/index.html";
    }

    @GetMapping("it-services.php")
    public String redirectItServices() {
        return "redirect:/index.html";
    }

    @GetMapping("/cloud-solutions.php")
    public String redirectCloud() {
        return "redirect:/index.html";
    }

    @GetMapping("/integration.php")
    public String redirectIntegration() {
        return "redirect:/index.html";
    }

    @GetMapping("/digital-technologies.php")
    public String redirectDigital() {
        return "redirect:/index.html";
    }

    @GetMapping("/business-process-outsourcing.php")
    public String redirectBPO() {
        return "redirect:/index.html";
    }

    @GetMapping("/careers.php")
    public String redirectCarers() {
        return "redirect:/index.html";
    }
}
