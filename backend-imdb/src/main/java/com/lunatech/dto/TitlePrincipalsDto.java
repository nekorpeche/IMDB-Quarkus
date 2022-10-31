package com.lunatech.dto;

import com.lunatech.model.NameBasics;
import com.lunatech.model.TitleBasics;
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
public class TitlePrincipalsDto {
    private TitleBasics titleBasics;
    private NameBasics nameBasics;
    private String tconst;
    private String nconst;
    private Integer ordering;
    private String category;
    private String job;
    private String characters;
}
