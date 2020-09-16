package com.assignment.GLHackathon.repository;

import com.assignment.GLHackathon.repository.builder.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Repository
public class LeaderboardRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private QueryBuilder queryBuilder;

    public void updateScore(String contestid, String teamid, double score){
        List<Double>existingScore=getscore(contestid,teamid);
        if(existingScore.isEmpty())
        {
            jdbcTemplate.update(queryBuilder.getINSERT_QUERY(),UUID.randomUUID().toString(),contestid,teamid,score,System.currentTimeMillis());
        }
        else if(existingScore.get(0)<score)
        {
            jdbcTemplate.update(queryBuilder.getUPDATE_QUERY(),score, System.currentTimeMillis(),contestid,teamid);
        }
        else{
            // do nothing, keep the best score i.e. last score
        }
    }

    public List<String> getLeaderBoard(String contestid){
        List<Object> preparedStmtList = Collections.singletonList(contestid);
        return jdbcTemplate.queryForList(queryBuilder.getGET_LEADERBOARD_QUERY(), preparedStmtList.toArray(), String.class);
    }

    public List<Double> getscore(String contestid, String teamid){

        List<Object> preparedStmtList = new ArrayList<>();
        preparedStmtList.add(contestid);
        preparedStmtList.add(teamid);
        return jdbcTemplate.queryForList(queryBuilder.getSELECT_QUERY(), preparedStmtList.toArray(), Double.class);
    }
}
