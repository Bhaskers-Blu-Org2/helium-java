package com.microsoft.azure.helium.app.actor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * ActorsService
 */
@Service
public class ActorsService {

    @Autowired
    private ActorsRepository repository;

    public List<Actor> getAllActors(Optional<String> query) {
        if (query.isPresent() && !StringUtils.isEmpty(query.get())) {
            return repository.findByTextSearchContaining(query.get().toLowerCase());
        } else {
            return (List<Actor>) repository.findAll();
        }
    }

    public Optional<Actor> getActor(String actorId) {
        if (StringUtils.isEmpty(actorId)) {
            throw new NullPointerException("actorId cannot be empty or null");
        }

        Actor actor = repository.findByActorId(actorId);
        if (actor == null) {
            return Optional.empty();
        } else {
            return Optional.of(actor);
        }
    }
}