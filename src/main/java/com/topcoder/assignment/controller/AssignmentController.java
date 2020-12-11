/*
 * Copyright (C) Topcoder 2020. All Rights Reserved.
 */

package com.topcoder.assignment.controller;


import com.topcoder.assignment.model.*;
import com.topcoder.assignment.repository.IncomingRepository;
import com.topcoder.assignment.repository.OutgoingRepository;
import com.topcoder.assignment.response.APIResponse;
import com.topcoder.assignment.response.ErrorAPIResponse;
import com.topcoder.assignment.response.ListAPIResponse;
import com.topcoder.assignment.utils.ModelUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

/**
 * @author Vinod
 * This will be the controller class for our service to manage the incoming and outgoing.
 */


@RestController
public class AssignmentController {

    @Autowired
    private IncomingRepository incomingRepository;

    @Autowired
    private OutgoingRepository outgoingRepository;

    /**
     * This method will be mapped to POST request which accepts the Incoming data.
     * Incoming data will be saved to Incoming Collection and data will be transformed and then
     * saved into Outgoing Collection in Mongo DB.
     * @param incoming data of time Incoming
     * @return
     */
    @PostMapping("/incoming")
    public ResponseEntity<APIResponse> storeIncoming(@Valid @RequestBody Incoming incoming) {
        APIResponse apiResponse = new APIResponse();
        try {
            incomingRepository.save(incoming);
            outgoingRepository.save(ModelUtility.transform(incoming));
            apiResponse.setStatus(HttpStatus.CREATED.value());
            apiResponse.setMessage("Incoming data has been saved with Id : " + incoming.getId() + ". Transformed Outgoing data is also saved with the same Id : " + incoming.getId());
        }
        // This will only handle the Unit Testing scenario. The ControllerAdvice will handle all other exceptions.
        catch (Exception e)
        {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMessage("Invalid Data");
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    /**
     * This method will get all the Incoming data from the Mongo Collection Incoming
     * @return list of data
     */
    @GetMapping("/incoming")
    public ResponseEntity<ListAPIResponse> getAllIncomingData() {
        ListAPIResponse listAPIResponse = new ListAPIResponse();
        listAPIResponse.setStatus(HttpStatus.OK.value());
        listAPIResponse.setMessage("Incoming data has been retrieved successfully");
        listAPIResponse.setDataList(Collections.singletonList(incomingRepository.findAll()));
        return new ResponseEntity<>(listAPIResponse, HttpStatus.OK);
    }

    /**
     * This methond will get all the Outgoing data from the Mongo Collection Outgoing
     * @return
     */
    @GetMapping("/outgoing")
    public ResponseEntity<ListAPIResponse> getAllOutgoingData() {
        ListAPIResponse listAPIResponse = new ListAPIResponse();
        listAPIResponse.setStatus(HttpStatus.OK.value());
        listAPIResponse.setMessage("Outgoing data has been retrieved successfully");
        listAPIResponse.setDataList(Collections.singletonList(outgoingRepository.findAll()));
        return new ResponseEntity<>(listAPIResponse, HttpStatus.OK);
    }
}
