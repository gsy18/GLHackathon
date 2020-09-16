package com.assignment.GLHackathon.repository.builder;

import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class QueryBuilder {
    private String SELECT_QUERY = "select score from contest_details where contestid= ? and teamid=?";
    private String UPDATE_QUERY= "update contest_details set score=?, submissiontime=? where contestid= ? and teamid=?";
    private String INSERT_QUERY= "insert into contest_details values (?, ?, ?, ?, ?)";
    private String GET_LEADERBOARD_QUERY= "select teamid from contest_details where contestid= ? order by score desc";
}
