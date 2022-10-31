package com.lunatech.resource;

import com.lunatech.model.TitleBasics;
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
    @GET
    public List<TitleBasics> ListAllMovies() {
        return TitleBasics.findAll().page(Page.ofSize(10)).list();
    }

    @GET
    @Path("/{keyword}")
    public List<TitleBasics> ListByPrimaryTitleOrOriginalTitle(String keyword) {
        return TitleBasics.findByPrimaryTitleOrOriginalTitle(keyword);

    }

    @GET
    @Path("/topratedmovies/{genre}")
    public List<TitleBasics> ListTopRatedMoviesByGenre(String genre) {
        return TitleBasics.findTopRatedMoviesByGenre(genre);
    }

}
