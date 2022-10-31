package com.lunatech.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RegisterForReflection()
public class TitleBasicsDto {
    private String tconst;
    private String titleType;
    private String primaryTitle;
    private Boolean isAdult;
    private Integer startYear;
    private Integer endYear;
    private Integer runtimeMinutes;
    private String genres;
    private TitleRatingsDto titleRatings;
    private List<TitlePrincipalsDto> titlePrincipals;
}
