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
public class TitleCrewDto {
    private String tconst;
    private String directors;
    private String writers;
    private TitleBasicsDto titleBasics;
}
