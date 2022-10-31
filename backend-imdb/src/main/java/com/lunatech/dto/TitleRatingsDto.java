package com.lunatech.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RegisterForReflection
public class TitleRatingsDto {
    private String tconst;
    private double averageRating;
    private Integer numVotes;
    private TitleBasicsDto titleBasics;
}
