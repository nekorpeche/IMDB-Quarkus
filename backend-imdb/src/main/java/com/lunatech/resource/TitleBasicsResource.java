package com.lunatech.resource;

import com.lunatech.model.TitleBasics;
import com.lunatech.service.KevinBaconGameService;
import io.quarkus.panache.common.Page;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/title-basics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TitleBasicsResource {

    /**
     * The KevinBacomeGameService.
     */
    KevinBaconGameService kv = new KevinBaconGameService();

    /**
     * List all movies list.
     *
     * @return the list
     */
    @GET
    public List<TitleBasics> ListAllMovies() {
        return TitleBasics.findAll().page(Page.ofSize(10)).list();
    }

    /**
     * List by primary title or original title list.
     *
     * @param keyword the keyword
     * @return the list
     */
    @GET
    @Path("/{keyword}")
    public List<TitleBasics> ListByPrimaryTitleOrOriginalTitle(String keyword) {
        return TitleBasics.findByPrimaryTitleOrOriginalTitle(keyword);

    }

    /**
     * List top rated movies by genre list.
     *
     * @param genre the genre
     * @return the list
     */
    @GET
    @Path("/topratedmovies/{genre}")
    public List<TitleBasics> ListTopRatedMoviesByGenre(String genre) {
        return TitleBasics.findTopRatedMoviesByGenre(genre);
    }

    /**
     * Get bacon number int.
     *
     * @param name     the name
     * @param lastname the lastname
     * @return the int
     */
    @GET
    @Path("/baconNumber/{name}-{lastname}")
    public int GetBaconNumber(String name, String lastname) {
        return kv.getBaconNumber(name, lastname);
    }

}
