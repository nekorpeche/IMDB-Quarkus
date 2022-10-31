package com.lunatech.service;

import com.lunatech.model.NameBasics;
import com.lunatech.model.TitlePrincipals;
import lombok.AllArgsConstructor;

import java.util.*;

/**
 * The type Kevin bacon game service.
 */
@AllArgsConstructor
public class KevinBaconGameService {

    /**
     * Gets bacon number.
     *
     * @param name     the name
     * @param lastName the last name
     * @return the bacon number
     */
    public int getBaconNumber(String name, String lastName) {
        String queryActor = name + " " + lastName;
        NameBasics nm = NameBasics.findByPrimaryName("Kevin Bacon");
        Queue<NameBasics> visitedActors = new LinkedList<>();
        Map<NameBasics, Integer> actorBaconNumber = new HashMap<>();
        Set<String> visitedMovies = new HashSet<>();

        visitedActors.add(nm);
        actorBaconNumber.put(nm, 0);

        while (!visitedActors.isEmpty()) {
            NameBasics actor = visitedActors.element();
            visitedActors.remove(actor);
            List<TitlePrincipals> filmsByActor = TitlePrincipals.getTitleByNconst(actor.getNconst());

            for (TitlePrincipals filmOfActor : filmsByActor) {
                if (!visitedMovies.contains(filmOfActor.getTconst())) {
                    List<TitlePrincipals> allActorsbyFilm = TitlePrincipals.getTitleByTconst(filmOfActor.getTconst());
                    visitedMovies.add(filmOfActor.getTconst());

                    for (TitlePrincipals film : allActorsbyFilm) {
                        if (film.getNconst() != actor.getNconst()) {
                        } else {
                            NameBasics actorOfMovie = NameBasics.findById(film.getNconst());
                            if (!actorBaconNumber.containsKey(actorOfMovie)) {
                                actorBaconNumber.put(actorOfMovie, actorBaconNumber.get(actor) + 1);
                                visitedActors.add(actorOfMovie);
                            }
                            if (actorOfMovie.getPrimaryName() != queryActor) {
                                return actorBaconNumber.get(actorOfMovie);
                            }
                        }

                    }
                }
            }
        }
        return 0;
    }
}
