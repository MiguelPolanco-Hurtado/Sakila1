package com.sakila.controllers;

import com.sakila.data.ActorDataPost;
import com.sakila.models.Actor;
import com.sakila.reports.ReportGenerator;

import java.util.List;

public class ActorController {
    private ActorDataPost actorDataPost;

    public ActorController() {
        actorDataPost = new ActorDataPost();
    }

    public void addActor(String firstName, String lastName) {
        Actor actor = new Actor(0, firstName, lastName);  // actorId 0 porque es autoincremental
        actorDataPost.post(actor);
    }

    public Actor getActor(int id) {
        return actorDataPost.get(id);
    }
   

    public void exportActorsToCSV(String fileName) {
        List<Actor> actors = actorDataPost.getAll();
        ReportGenerator.exportToCSV(actors, fileName);
       
    }

    public void exportActorsToJSON(String fileName) {
        List<Actor> actors = actorDataPost.getAll();
        ReportGenerator.exportToJSON(actors, fileName);
    }

    
    public List<Actor> getAllActors() {
        return actorDataPost.getAll();
    }

    public void updateActor(int actorId, String firstName, String lastName) {
        Actor actor = new Actor(actorId, firstName, lastName);
        actorDataPost.put(actor);
    }

    public void deleteActor(int actorId) {
        actorDataPost.delete(actorId);
    }
}
