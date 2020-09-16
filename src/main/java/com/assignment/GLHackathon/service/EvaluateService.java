package com.assignment.GLHackathon.service;

import com.assignment.GLHackathon.models.*;
import com.assignment.GLHackathon.repository.LeaderboardRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateService {

    @Autowired
    private ContestService contestService;

    @Autowired
    private MockService mockService;

    @Autowired
    private LeaderboardRepository leaderboardRepository;

    public double evaluateSubmission(ScoreRequest getScoreRequest){
        String contestid = getScoreRequest.getContestid();
        String teamid=getScoreRequest.getTeamid();
        ContestDetails contestDetails = contestService.getContest(contestid);
        List<AnswerDetail> answerDetailList=getScoreRequest.getAnswerDetailsList();
        List<QuestionDetail> questionDetailsList=contestDetails.getQuestionDetailsList();
        double score =0;
        // assuming answers in order
        for(int i=0;i<answerDetailList.size();i++)
        {
            AnswerDetail answerDetail=answerDetailList.get(i);
            QuestionDetail questionDetail=questionDetailsList.get(i);
            String submittedSourceCode = answerDetail.getSourceCode();
            for(TestCase testCase:questionDetail.getTestcases())
            {
                String expectedOutput = testCase.getExpectedOutput();
                String actualOutput = mockService.getOutput(submittedSourceCode,testCase.getInputs());
                if(StringUtils.equals(expectedOutput,actualOutput))
                {
                    score+=testCase.getWeight();
                }
            }

        }
        leaderboardRepository.updateScore(contestid,teamid,score);
        return  score;
    }
}
