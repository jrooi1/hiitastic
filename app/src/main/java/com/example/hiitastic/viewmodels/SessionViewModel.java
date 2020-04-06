package com.example.hiitastic.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hiitastic.controllers.DataRepository;
import com.example.hiitastic.models.ExerciseModel;
import com.example.hiitastic.models.SessionModel;
import com.example.hiitastic.models.SessionWithExercise;

import java.util.List;

public class SessionViewModel extends AndroidViewModel{

    private DataRepository repo;
    private LiveData<List<SessionWithExercise>> sessions;
    private LiveData<SessionWithExercise> currentSession;
    private SessionWithExercise session;

    public SessionViewModel(@NonNull Application application) {
        super(application);
        repo =  DataRepository.getInstance(application);
        sessions = repo.getSessions();
    }

    public void insert(String name, int sets, int repsIntervalTime, int restTime, List<ExerciseModel> exercises) {
        SessionModel session = new SessionModel(name, sets, repsIntervalTime, restTime);
        this.setSession( new SessionWithExercise(session, exercises));

        repo.insertSession(session, exercises);
    }

    public LiveData<List<SessionWithExercise>> getSessions() {
        return this.sessions;
    }

    public void setSession(SessionWithExercise session) {
        this.session = session;
    }

    public SessionWithExercise getSession() {
        return this.session;
    }


}
