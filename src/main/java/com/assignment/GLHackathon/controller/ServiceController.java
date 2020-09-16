package com.assignment.GLHackathon.controller;

import com.assignment.GLHackathon.models.*;
import com.assignment.GLHackathon.service.EvaluateService;
import com.assignment.GLHackathon.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    private EvaluateService evaluateService;

    @Autowired
    private ContestService contestService;

    @RequestMapping(value = "/_addcontest", method = RequestMethod.POST)
    public ResponseEntity<?> addcontest(@RequestBody ContestDetails contestDetails) {
        contestService.saveContest(contestDetails);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/_getscore", method = RequestMethod.POST)
    public @ResponseBody
    ScoreResponse getScore(@RequestBody ScoreRequest getScoreRequest) {
        double submissionScore=  evaluateService.evaluateSubmission(getScoreRequest);
        ScoreResponse scoreResponse = ScoreResponse.builder().score(submissionScore).build();
        return scoreResponse;
    }

    @RequestMapping(value = "/_getleaderboard", method = RequestMethod.POST)
    public @ResponseBody
    LeaderboardResponse getLeaderBoard(@RequestBody LeaderboardRequest getLeaderboardRequest){
        String contestid = getLeaderboardRequest.getContestid();
        List<String> teamids=contestService.getLeaderBoard(contestid);
        LeaderboardResponse leaderboardResponse = LeaderboardResponse.builder().contestid(contestid).teamids(teamids).build();
        return leaderboardResponse;
    }
}
