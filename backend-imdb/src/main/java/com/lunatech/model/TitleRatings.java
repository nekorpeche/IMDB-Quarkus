package com.lunatech.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "title_ratings")
public class TitleRatings {
    @Id
    private String tconst;
    private double averageRating;
    private Integer numVotes;
    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "tconst")
    private TitleBasics titleBasics;

}