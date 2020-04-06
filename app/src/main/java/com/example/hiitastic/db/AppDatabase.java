package com.example.hiitastic.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.hiitastic.db.daos.ExerciseDao;
import com.example.hiitastic.db.daos.SessionDao;
import com.example.hiitastic.db.daos.SessionExerciseCrossRefDao;
import com.example.hiitastic.models.ExerciseModel;
import com.example.hiitastic.models.SessionExcerciseCrossRef;
import com.example.hiitastic.models.SessionModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities={SessionModel.class, ExerciseModel.class,
        SessionExcerciseCrossRef.class}, version=1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

     public abstract ExerciseDao exerciseDao();
     public abstract SessionDao sessionDao();
     public abstract SessionExerciseCrossRefDao secfDao();

     private static volatile AppDatabase INSTANCE;
     private static final int THREAD_COUNT = 4;
     private static final String DATABASE_NAME = "hiitastic_db";

     static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(THREAD_COUNT);

     public static AppDatabase getAppDatabase(final Context context) {
         if(INSTANCE == null) {
             synchronized (AppDatabase.class) {
                 if (INSTANCE == null) {
                     INSTANCE = buildDatabase(context);

                 }
             }
         }

         return INSTANCE;
     }

     private static AppDatabase buildDatabase(final Context context) {
         return Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME).build();
     }
}
