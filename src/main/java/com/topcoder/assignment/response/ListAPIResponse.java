/*
 * Copyright (C) Topcoder 2020. All Rights Reserved.
 */

package com.topcoder.assignment.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Vinod.Kumar
 * This class contains the template for API response.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListAPIResponse extends APIResponse{
    private List<Object> dataList;
}


