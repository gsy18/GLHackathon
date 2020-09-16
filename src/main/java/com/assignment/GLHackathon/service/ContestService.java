package com.assignment.GLHackathon.service;

import com.assignment.GLHackathon.models.ContestDetails;
import com.assignment.GLHackathon.repository.ContestDetailsRepository;
import com.assignment.GLHackathon.repository.LeaderboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestService {
    @Autowired
    private ContestDetailsRepository contestDetailsRepository;

    @Autowired
    private LeaderboardRepository leaderboardRepository;

    public void saveContest(ContestDetails contestDetails){
        contestDetailsRepository.save(contestDetails);
    }

    public ContestDetails getContest(String contestid){
        return contestDetailsRepository.findBycontestid(contestid);
    }


    public List<String> getLeaderBoard(String contestid){
        return leaderboardRepository.getLeaderBoard(contestid);
    }
}
