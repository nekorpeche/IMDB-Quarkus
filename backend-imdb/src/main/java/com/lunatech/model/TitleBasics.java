package com.lunatech.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Page;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "title_basics")
public class TitleBasics extends PanacheEntityBase {
    @Id
    @Column(name = "tconst", columnDefinition = "varchar(10)")
    private String tconst;
    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private Boolean isAdult;
    private Integer startYear;
    private Integer endYear;
    private Integer runtimeMinutes;
    private String genres;

    @JsonManagedReference
    @OneToMany(mappedBy = "titleBasics")
    private List<TitlePrincipals> titlePrincipals;

    @JsonManagedReference
    @OneToOne(mappedBy = "titleBasics")
    private TitleRatings titleRatings;

    /**
     * Find by primary title or original title list.
     *
     * @param keyword the keyword
     * @return the list
     */
    public static List<TitleBasics> findByPrimaryTitleOrOriginalTitle(String keyword) {
        return find("lower(primaryTitle) like ?1 or lower(originalTitle) like ?1", "%" + keyword.toLowerCase() + "%").page(Page.ofSize(10)).list();
    }

    /**
     * Find top rated movies by genre list.
     *
     * @param genre the genre
     * @return the list
     */
    public static List<TitleBasics> findTopRatedMoviesByGenre(String genre) {
        return find(" lower(genres) like ?1 order by titleRatings.averageRating DESC", "%" + genre.toLowerCase() + "%").page(Page.ofSize(10)).list();
    }

}
