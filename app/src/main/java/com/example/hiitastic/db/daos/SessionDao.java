package com.example.hiitastic.db.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.hiitastic.models.SessionModel;
import com.example.hiitastic.models.SessionWithExercise;

import java.util.List;

@Dao
public interface SessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SessionModel session);

    @Update
    void update(SessionModel session);

    @Delete
    void delete(SessionModel session);

    @Transaction
    @Query("SELECT * FROM sessions")
    LiveData<List<SessionWithExercise>> getAll();

    @Transaction
    @Query("SELECT * FROM sessions WHERE id=:id")
    SessionWithExercise getSession(long id);
}
