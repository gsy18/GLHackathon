package com.assignment.GLHackathon.models;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreRequest {
    private String contestid;
    private String teamid;
    private List<AnswerDetail> answerDetailsList;
}
