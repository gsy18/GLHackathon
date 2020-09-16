package com.assignment.GLHackathon.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ContestDetails")
public class ContestDetails {
    private String contestid;
    private List<QuestionDetail> questionDetailsList;
}
