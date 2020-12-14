/*
 * Copyright (C) Topcoder 2020. All Rights Reserved.
 */

package com.topcoder.assignment.utils;

/**
 * Author: Vinod
 * This will have all the JUnit testing done for ModelUtility Class.
 */

import com.topcoder.assignment.model.Incoming;
import com.topcoder.assignment.model.Outgoing;
import com.topcoder.assignment.repository.IncomingRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author: Vinod
 * This will have all the JUnit testing done for ModelUtility Class.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class ModelUtilityTest {

    @Autowired
    IncomingRepository incomingRepository;

    Incoming incomingDataSample;

    /**
     * This will be executed before all the Testcases.
     */
    @Before
    public void setUp(){
        incomingDataSample = new Incoming();
        incomingDataSample.setId(432);
        incomingDataSample.setWhiteSpacesGalore("Sample data with White Spaces");
        List<Integer> numbersMeetNumbers1 = new ArrayList<>();
        numbersMeetNumbers1.add(44);
        numbersMeetNumbers1.add(123);
        numbersMeetNumbers1.add(435);
        numbersMeetNumbers1.add(-944);
        numbersMeetNumbers1.add(442);
        numbersMeetNumbers1.add(5);
        incomingDataSample.setNumbersMeetNumbers(numbersMeetNumbers1);
        incomingDataSample.setFindDuplicates("Sample Data to Get Duplicate Characters");
    }

    /**
     * This will test the Transform method in the ModelUtility class.
     */
    @Test
    public void transformIncomingData() {
        Outgoing outgoing = ModelUtility.transform(incomingDataSample);
        // Validate the findDuplicates method
        assertThat(outgoing.getFindDuplicates()).isEqualTo("aple Dtcr");
        // Validate the removeSpaceWithoutReplace method
        assertThat(outgoing.getLargestNumbersMeetNumbers()).isEqualTo(442);
        // Validate the getLargestNumber method
        assertThat(outgoing.getWhiteSpacesGalore()).isEqualTo("SampledatawithWhiteSpaces");
    }


}