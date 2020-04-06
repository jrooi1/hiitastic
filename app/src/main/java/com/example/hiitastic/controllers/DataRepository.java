package com.example.hiitastic.controllers;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.hiitastic.db.AppDatabase;
import com.example.hiitastic.db.daos.SessionDao;
import com.example.hiitastic.db.daos.SessionExerciseCrossRefDao;
import com.example.hiitastic.models.ExerciseModel;
import com.example.hiitastic.models.SessionExcerciseCrossRef;
import com.example.hiitastic.models.SessionModel;
import com.example.hiitastic.models.SessionWithExercise;

import java.util.List;

public class DataRepository {

    private static DataRepository INSTANCE;

    private AppDatabase database;
    private LiveData<List<SessionWithExercise>> sessions;
    private SessionDao sessionDao;
    private SessionExerciseCrossRefDao secfDao;

    private DataRepository(Application application) {
        this.database = AppDatabase.getAppDatabase(application.getApplicationContext());
        sessionDao = this.database.sessionDao();
        secfDao = this.database.secfDao();
        sessions = sessionDao.getAll();
    }

    public static DataRepository getInstance(Application application) {
        if( INSTANCE == null) {
            synchronized (DataRepository.class) {
                if( INSTANCE == null ) {
                    INSTANCE = new DataRepository(application);
                }
            }
        }

        return INSTANCE;
    }

    public LiveData<List<SessionWithExercise>> getSessions() {
        return sessions;
    }

    public void insertSession(SessionModel session, List<ExerciseModel> exercises) {
        sessionDao.insert(session);
        int sessionId = session.getId();

        for(ExerciseModel exercise : exercises) {
            secfDao.insert(new SessionExcerciseCrossRef(sessionId, exercise.id));
        }
    }
}
