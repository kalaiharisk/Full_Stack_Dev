package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ScheduleChangeRequest;
import com.example.demo.service.ScheduleChangeRequestService;

@RestController
@RequestMapping("/api/changerequests")
public class ScheduleChangeRequestController {

    @Autowired
    private ScheduleChangeRequestService service;

    @GetMapping
    public ResponseEntity<List<ScheduleChangeRequest>> getAllRequests() {
        List<ScheduleChangeRequest> requests = service.getAllRequests();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleChangeRequest> getRequestById(@PathVariable Long id) {
        ScheduleChangeRequest request = service.getRequestById(id);
        if (request != null) {
            return new ResponseEntity<>(request, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ScheduleChangeRequest> createRequest(@RequestBody ScheduleChangeRequest request) {
        ScheduleChangeRequest savedRequest = service.saveRequest(request);
        return new ResponseEntity<>(savedRequest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleChangeRequest> updateRequest(
            @PathVariable Long id,
            @RequestBody ScheduleChangeRequest request) {
        ScheduleChangeRequest existingRequest = service.getRequestById(id);
        if (existingRequest != null) {
            request.setId(id);
            ScheduleChangeRequest updatedRequest = service.saveRequest(request);
            return new ResponseEntity<>(updatedRequest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        ScheduleChangeRequest existingRequest = service.getRequestById(id);
        if (existingRequest != null) {
            service.deleteRequest(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}/approve")
    public ResponseEntity<ScheduleChangeRequest> approveRequest(@PathVariable Long id) {
        try {
            ScheduleChangeRequest approvedRequest = service.approveChangeRequest(id);
            // Notify user or perform any additional action here
            return new ResponseEntity<>(approvedRequest, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PatchMapping("/{id}/reject")
    public ResponseEntity<ScheduleChangeRequest> rejectRequest(@PathVariable Long id) {
        try {
            ScheduleChangeRequest rejectedRequest = service.rejectChangeRequest(id);
            // Notify user or perform any additional action here
            return new ResponseEntity<>(rejectedRequest, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

}
