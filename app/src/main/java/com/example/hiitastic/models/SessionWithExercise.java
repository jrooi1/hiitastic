package com.example.hiitastic.models;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class SessionWithExercise {

    @Embedded
    public SessionModel session;

    @Relation(
            parentColumn = "id",
            entityColumn = "sessionId",
            associateBy = @Junction(SessionExcerciseCrossRef.class)
    )
    public List<ExerciseModel> exercises;

    public SessionWithExercise(SessionModel session, List<ExerciseModel> exercises) {
        this.session = session;
        this.exercises = exercises;
    }

    public SessionModel getSession() {
        return session;
    }

    public List<ExerciseModel> getExercises() {
        return exercises;
    }


}
