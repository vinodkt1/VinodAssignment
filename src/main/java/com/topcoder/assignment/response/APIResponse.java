/*
 * Copyright (C) Topcoder 2020. All Rights Reserved.
 */

package com.topcoder.assignment.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vinod.Kumar
 * This class contains the template for API response.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class APIResponse {
    private int status;
    private String message;
}


