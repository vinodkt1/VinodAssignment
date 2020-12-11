/*
 * Copyright (C) Topcoder 2020. All Rights Reserved.
 */

package com.topcoder.assignment.controller;
import com.topcoder.assignment.repository.OutgoingRepository;
import com.topcoder.assignment.response.ListAPIResponse;
import static org.assertj.core.api.Assertions.assertThat;
import com.topcoder.assignment.model.Incoming;
import com.topcoder.assignment.repository.IncomingRepository;
import com.topcoder.assignment.response.APIResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Vinod
 * This will have all the JUnit testing done for AssignmentController Class
 * Note:- This will use the Embedded Mongo DB for Unit testing purpose. With this we can
 * Build the Application on a CI/CD pipeline where there is no Mongo DB installed.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class AssignmentControllerTest {

    @Autowired
    IncomingRepository incomingRepository;

    @Autowired
    OutgoingRepository outgoingRepository;

    @Autowired
    AssignmentController assignmentController;

    Incoming validIncomingData;
    Incoming invalidIncomingData;

    /**
     * This will be executed before all the Testcases.
     */
    @Before
    public void setUp(){
        validIncomingData = new Incoming();
        validIncomingData.setId(123);
        validIncomingData.setWhiteSpacesGalore("Sample data with White Spaces");
        List<Integer> numbersMeetNumbers = new ArrayList<>();
        numbersMeetNumbers.add(22);
        numbersMeetNumbers.add(35);
        validIncomingData.setNumbersMeetNumbers(numbersMeetNumbers);
        validIncomingData.setFindDuplicates("Sample Data to Get Duplicate Characters");

        invalidIncomingData = null;
    }

    /**
     * Test a valid Incoming data
     */
    @Test
    public void storeValidIncomingData() {
        APIResponse apiResponse = assignmentController.storeIncoming(validIncomingData).getBody();
        assertThat(apiResponse.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    /**
     * Test a Invalid Data
     */
    @Test
    public void storeInValidIncomingData() {
        APIResponse apiResponse = assignmentController.storeIncoming(invalidIncomingData).getBody();
        assertThat(apiResponse.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    /**
     * Test if Incoming Data is retrievable from collection
     */
    @Test
    public void getAllIncomingData() {
        ListAPIResponse listAPIResponse = assignmentController.getAllIncomingData().getBody();
        assertThat(listAPIResponse.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(incomingRepository.findAll().size()).isGreaterThan(0);
    }

    /**
     * Test if Outgoing Data is retrievable from collection
     */
    @Test
    public void getAllOutgoingData() {
        ListAPIResponse listAPIResponse = assignmentController.getAllOutgoingData().getBody();
        assertThat(listAPIResponse.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(outgoingRepository.findAll().size()).isGreaterThan(0);
    }
}