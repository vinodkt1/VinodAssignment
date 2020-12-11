/*
 * Copyright (C) Topcoder 2020. All Rights Reserved.
 */

package com.topcoder.assignment.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


/**
 * @author Vinod
 * This is the model class for the outgoing data
 */

@Getter
@Setter
@ToString

@Document(collection = "Outgoing")
public class Outgoing {
    @Id
    private Integer id;
    private String findDuplicates;
    private String whiteSpacesGalore;
    private Boolean validateMeOnlyIActuallyShouldBeABoolean;
    private List<Integer> numbersMeetNumbers;
    private Integer largestNumbersMeetNumbers;
}
