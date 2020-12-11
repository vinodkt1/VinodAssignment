/*
 * Copyright (C) Topcoder 2020. All Rights Reserved.
 */

package com.topcoder.assignment.repository;

import com.topcoder.assignment.model.Incoming;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Vinod
 * This is the repository for the Incoming data
 */

public interface IncomingRepository extends MongoRepository<Incoming, Integer> {
}
