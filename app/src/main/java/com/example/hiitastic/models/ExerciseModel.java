package com.example.hiitastic.models;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "exercises")
public class ExerciseModel {

    @PrimaryKey(autoGenerate = true)
    public long id;
    @ColumnInfo(name = "exercise_name")
    public String exerciseName;

    @Embedded
    public Timestamps timestamps;
}
