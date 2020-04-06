package com.example.hiitastic.db.daos;

import androidx.room.Delete;
import androidx.room.Insert;

import com.example.hiitastic.models.SessionExcerciseCrossRef;

public interface SessionExerciseCrossRefDao {

    @Insert
    void insert(SessionExcerciseCrossRef secf);

    @Delete
    void delete(SessionExcerciseCrossRef secf);
}
