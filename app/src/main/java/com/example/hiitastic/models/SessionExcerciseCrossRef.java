package com.example.hiitastic.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(primaryKeys = {"sessionId","exerciseId"})
public class SessionExcerciseCrossRef {

    public long sessionId;
    public long exerciseId;

    public SessionExcerciseCrossRef(long sessionId, long exerciseId) {
        this.sessionId = sessionId;
        this.exerciseId = exerciseId;
    }
}
