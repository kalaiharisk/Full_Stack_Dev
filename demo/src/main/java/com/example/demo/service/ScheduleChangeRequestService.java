package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ScheduleChangeRequest;
import com.example.demo.repository.ScheduleChangeRequestRepository;

@Service
public class ScheduleChangeRequestService {

    @Autowired
    private ScheduleChangeRequestRepository repository;

    public List<ScheduleChangeRequest> getAllRequests() {
        return repository.findAll();
    }

    public ScheduleChangeRequest saveRequest(ScheduleChangeRequest request) {
        return repository.save(request);
    }

    public ScheduleChangeRequest getRequestById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }

    public ScheduleChangeRequest approveChangeRequest(Long id) {
        ScheduleChangeRequest request = repository.findById(id).orElseThrow(() -> 
            new ResourceNotFoundException("Change request not found with ID: " + id)
        );
        request.setStatus("Approved");
        return repository.save(request);
    }
    
    public ScheduleChangeRequest rejectChangeRequest(Long id) {
        ScheduleChangeRequest request = repository.findById(id).orElseThrow(() -> 
            new ResourceNotFoundException("Change request not found with ID: " + id)
        );
        request.setStatus("Rejected");
        return repository.save(request);
    }
    
}
