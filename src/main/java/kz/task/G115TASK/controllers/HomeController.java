package kz.task.G115TASK.controllers;

import kz.task.G115TASK.models.ApplicationRequest;
import kz.task.G115TASK.repost.ApplicationRequestRepository;
import kz.task.G115TASK.service.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ApplicationRequestService applicationRequestService;
    @GetMapping("/")
    public String homePage(Model model) {
        List<ApplicationRequest> applicationRequests =applicationRequestService.getAppRequest();
        model.addAttribute("posts",applicationRequests);
        return "home";
    }
    @PostMapping("/add-app-req")
    public String addAppReq(ApplicationRequest appReq){
        applicationRequestService.addAppReq(appReq);
        return "redirect:/";
    }
    @GetMapping("/details/{id}")
    public String details (@PathVariable Long id, Model model) {
        ApplicationRequest appReq = applicationRequestService.getAppReqById(id);
        model.addAttribute("zayavka",appReq);
        return "details";
    }
}
