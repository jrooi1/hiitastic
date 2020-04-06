package com.example.hiitastic.db.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hiitastic.models.ExerciseModel;

import java.util.List;

@Dao
public interface ExerciseDao {

    @Insert
    void insert(ExerciseModel exercise);

    @Update
    void update(ExerciseModel exercise);

    @Delete
    void delete(ExerciseModel exercise);

    @Query("SELECT * FROM exercises")
    List<ExerciseModel> getAll();
}
