package com.example.hiitastic.models;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sessions")
public class SessionModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String session_name;
    public int set;
    public int repsTime; // in secs
    public int restTime; // in secs

    @Embedded
    public Timestamps timestamps;

    public SessionModel( String session_name, int set, int repsTime, int restTime) {
        this.session_name = session_name;
        this.set = set;
        this.repsTime = repsTime;
        this.restTime = restTime;
        this.timestamps = new Timestamps(System.currentTimeMillis(),System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public String getSession_name() {
        return session_name;
    }

    public int getSet() {
        return set;
    }

    public long getRepsTime() {
        return repsTime;
    }

    public long getRestTime() {
        return restTime;
    }
}
