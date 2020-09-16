package com.assignment.GLHackathon.models;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaderboardResponse {
    private List<String> teamids;
    private String contestid;
}
