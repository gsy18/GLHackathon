package com.assignment.GLHackathon.models;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDetail {
    private String problemStatement;
    private List<TestCase> testcases;
}
