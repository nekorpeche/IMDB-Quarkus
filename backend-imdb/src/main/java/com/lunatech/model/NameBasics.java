package com.lunatech.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany
    @Transient
    @JoinColumn(name = "nconst")
    private List<TitlePrincipals> titlePrincipalsList;

    /**
     * Find by primaryName in nameBasics.
     *
     * @param name the name
     * @return the name basics
     */
    public static NameBasics findByPrimaryName(String name) {
        return find("primaryName = ?1", name).firstResult();
    }

    /**
     * Gets list of titles.
     *
     * @return the list of titles
     */
    public List<TitlePrincipals> getListOfTitles() {
        return this.titlePrincipalsList;
    }


}
