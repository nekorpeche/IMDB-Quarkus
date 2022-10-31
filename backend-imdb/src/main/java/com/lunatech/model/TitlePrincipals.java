package com.lunatech.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "title_principals")
public class TitlePrincipals extends PanacheEntityBase implements Serializable {
    @Id
    @Column(name = "ordering")
    private int ordering;

    @Id
    @Column(name = "tconst", columnDefinition = "varchar(10)")
    private String tconst;

    @Id
    @Column(name = "nconst")
    private String nconst;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "tconst")
    private TitleBasics titleBasics;
    @ManyToOne
    @JoinColumn(name = "nconst")
    private NameBasics nameBasics;

    private String category;
    private String job;
    private String characters;

    /**
     * Gets title by tconst.
     *
     * @param tconst the tconst
     * @return the title by tconst
     */
    public static List<TitlePrincipals> getTitleByTconst(String tconst) {
        return find("lower(tconst) = ?1 ", tconst).list();
    }

    /**
     * Gets title by nconst.
     *
     * @param nconst the nconst
     * @return the title by nconst
     */
    public static List<TitlePrincipals> getTitleByNconst(String nconst) {
        return find("lower(nconst) = ?1 ", nconst).list();
    }


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TitlePrincipals)) {
            return false;
        }
        TitlePrincipals other = (TitlePrincipals) o;
        boolean tconstEquals = (this.titleBasics.getTconst() == null && other.titleBasics.getTconst() == null)
                || (this.titleBasics.getTconst() != null && this.titleBasics.getTconst().equals(other.titleBasics.getTconst()));
        boolean nconstEquals = (this.nameBasics.getNconst() == null && other.nameBasics.getNconst() == null)
                || (this.nameBasics.getNconst() != null && this.nameBasics.getNconst().equals(other.nameBasics.getNconst()));
        boolean orderingEquals = (this.ordering == 0 && other.ordering == 0)
                || (this.ordering != 0 && this.ordering == other.ordering);
        return tconstEquals && nconstEquals && orderingEquals;
    }

    @Override
    public int hashCode() {
        return ordering * tconst.hashCode() * nconst.hashCode();
    }
}