package com.assignment.GLHackathon.repository;

import com.assignment.GLHackathon.models.ContestDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContestDetailsRepository extends MongoRepository<ContestDetails, String> {
    ContestDetails findBycontestid(String contestid);
}
