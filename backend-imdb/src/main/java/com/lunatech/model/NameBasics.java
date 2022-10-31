package com.lunatech.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "name_basics")
public class NameBasics extends PanacheEntityBase {
    @Id
    @Column(name = "nconst", columnDefinition = "varchar")
    private String nconst;
    private String primaryName;
    private Integer birthYear;
    private Integer deathYear;
    private String primaryProfession;
    private String knownForTitles;
}
