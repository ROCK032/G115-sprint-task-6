package kz.task.G115TASK.service;

import kz.task.G115TASK.models.ApplicationRequest;
import kz.task.G115TASK.repost.ApplicationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationRequestService {
    @Autowired
    private ApplicationRequestRepository applicationRequestRepository;
    public void addAppReq(ApplicationRequest appReq){
        appReq.setHandled(false);
        applicationRequestRepository.save(appReq);

    }

    public List<ApplicationRequest> getAppRequest() {
        return applicationRequestRepository.findAll();
    }

    public ApplicationRequest getAppReqById(Long id) {
        return applicationRequestRepository.findById(id).orElseThrow();
    }
}
