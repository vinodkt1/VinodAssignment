/*
 * Copyright (C) Topcoder 2020. All Rights Reserved.
 */

package com.topcoder.assignment.repository;

import com.topcoder.assignment.model.Outgoing;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Vinod
 * This is the repository for the outgoing class
 */

public interface OutgoingRepository extends MongoRepository<Outgoing, Integer> {
}
