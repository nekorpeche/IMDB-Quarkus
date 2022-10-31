package com.lunatech.resource;

import com.lunatech.model.TitleCrew;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/title-crew")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TitleCrewResource {
    @GET
    public TitleCrew count() {
        return TitleCrew.find("order by tconst").firstResult();
    }


}

