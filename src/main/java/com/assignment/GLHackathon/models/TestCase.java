package com.assignment.GLHackathon.models;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestCase {
    private List<String> inputs;
    private double weight;
    private String expectedOutput;
}
