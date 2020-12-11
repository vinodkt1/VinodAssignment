/*
 * Copyright (C) Topcoder 2020. All Rights Reserved.
 */

package com.topcoder.assignment.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/**
 * @author Vinod
 * This is the model class for the Incoming data
 */

@Getter
@Setter
@ToString

@Document(collection = "Incoming")
public class Incoming {

    @Id
    @NotNull(message = "Id cannot be Null")
    @PositiveOrZero(message = "Id has to be a valid integer greater than or equal to 0.")
    private Integer id;

    @NotNull(message = "FindDuplicates cannot be Null")
    @NotEmpty(message = "FindDuplicates cannot be empty")
    private String findDuplicates;

    @NotNull(message = "ValidateMeOnlyIActuallyShouldBeABoolean cannot be Null")
    @NotEmpty(message = "WhiteSpacesGalore cannot be empty")
    private String whiteSpacesGalore;

    @NotNull(message = "ValidateMeOnlyIActuallyShouldBeABoolean cannot be Null")
    private Boolean validateMeOnlyIActuallyShouldBeABoolean;

    @NotNull(message = "NumbersMeetNumbers cannot be Null")
    private List<Integer> numbersMeetNumbers;
}
