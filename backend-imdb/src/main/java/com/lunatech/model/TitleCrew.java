package com.lunatech.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lunatech.utils.NameBasicsConverter;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "title_crew")
public class TitleCrew extends PanacheEntityBase {

    @JsonBackReference
    @OneToOne()
    @JoinColumn(name = "tconst")
    TitleBasics titleBasics;

    @Id
    private String tconst;

    @Column(name = "writers")
    @Convert(converter = NameBasicsConverter.class)
    private List<NameBasics> writers;

    @Column(name = "directors")
    private String directors;


    @Override
    public String toString() {
        return super.toString();
    }
}