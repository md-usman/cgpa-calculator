package com.example.android.cgpacalculator.database;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.android.cgpacalculator.database.tables.Cgpa;
import com.example.android.cgpacalculator.database.tables.Marks;
import com.example.android.cgpacalculator.database.tables.Sgpa;
import com.example.android.cgpacalculator.database.tables.Student;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Student.class, Cgpa.class, Marks.class, Sgpa.class}, version = 1)
public abstract class StudentDatabase extends RoomDatabase {

    public static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static StudentDatabase instance;
    public static final RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Executors.newSingleThreadExecutor().execute(() -> {
                StudentDao studentDao = instance.databaseDao();

                studentDao.deleteAllStudents();
                studentDao.insert(new Student("4MH18XXXXX", "Your Name", "Your branch name"));


                studentDao.deleteAllCgpa();
                studentDao.insert(new Cgpa(0.0));

                //studentDao.deleteAllSgpa();
                studentDao.deleteAllSgpa();
                studentDao.insert(new Sgpa(1, 0.0, 0));
                studentDao.insert(new Sgpa(2, 0.0, 0));
                studentDao.insert(new Sgpa(3, 0.0, 0));
                studentDao.insert(new Sgpa(4, 0.0, 0));
                studentDao.insert(new Sgpa(5, 0.0, 0));
                studentDao.insert(new Sgpa(6, 0.0, 0));
                studentDao.insert(new Sgpa(7, 0.0, 0));
                studentDao.insert(new Sgpa(8, 0.0, 0));

                // deleting all previous marks
                studentDao.deleteAllMarks();

                // reset first sem
                studentDao.insert(new Marks(1, "18XXX11", 0, 0));
                studentDao.insert(new Marks(1, "18XXX12", 0, 0));
                studentDao.insert(new Marks(1, "18XXX13", 0, 0));
                studentDao.insert(new Marks(1, "18XXX14", 0, 0));
                studentDao.insert(new Marks(1, "18XXX15", 0, 0));
                studentDao.insert(new Marks(1, "18XXX16", 0, 0));
                studentDao.insert(new Marks(1, "18XXX17", 0, 0));
                studentDao.insert(new Marks(1, "18XXX18", 0, 0));

                // reset second sem
                studentDao.insert(new Marks(2, "18XXX21", 0, 0));
                studentDao.insert(new Marks(2, "18XXX22", 0, 0));
                studentDao.insert(new Marks(2, "18XXX23", 0, 0));
                studentDao.insert(new Marks(2, "18XXX24", 0, 0));
                studentDao.insert(new Marks(2, "18XXX25", 0, 0));
                studentDao.insert(new Marks(2, "18XXX26", 0, 0));
                studentDao.insert(new Marks(2, "18XXX27", 0, 0));
                studentDao.insert(new Marks(2, "18XXX28", 0, 0));

                // reset third sem
                studentDao.insert(new Marks(3, "18XXX31", 0, 0));
                studentDao.insert(new Marks(3, "18XX32", 0, 0));
                studentDao.insert(new Marks(3, "18XX33", 0, 0));
                studentDao.insert(new Marks(3, "18XX34", 0, 0));
                studentDao.insert(new Marks(3, "18XX35", 0, 0));
                studentDao.insert(new Marks(3, "18XX36", 0, 0));
                studentDao.insert(new Marks(3, "18XXX37", 0, 0));
                studentDao.insert(new Marks(3, "18XXX38", 0, 0));
                studentDao.insert(new Marks(3, "18XXX39", 0, 0));

                // reset fourth sem
                studentDao.insert(new Marks(4, "18XXX41", 0, 0));
                studentDao.insert(new Marks(4, "18XX42", 0, 0));
                studentDao.insert(new Marks(4, "18XX43", 0, 0));
                studentDao.insert(new Marks(4, "18XX44", 0, 0));
                studentDao.insert(new Marks(4, "18XX45", 0, 0));
                studentDao.insert(new Marks(4, "18XX46", 0, 0));
                studentDao.insert(new Marks(4, "18XXX47", 0, 0));
                studentDao.insert(new Marks(4, "18XXX48", 0, 0));
                studentDao.insert(new Marks(4, "18XXX49", 0, 0));

                // reset fifth sem
                studentDao.insert(new Marks(5, "18XX51", 0, 0));
                studentDao.insert(new Marks(5, "18XX52", 0, 0));
                studentDao.insert(new Marks(5, "18XX53", 0, 0));
                studentDao.insert(new Marks(5, "18XX54", 0, 0));
                studentDao.insert(new Marks(5, "18XX55", 0, 0));
                studentDao.insert(new Marks(5, "18XX56", 0, 0));
                studentDao.insert(new Marks(5, "18XXX57", 0, 0));
                studentDao.insert(new Marks(5, "18XXX58", 0, 0));
                studentDao.insert(new Marks(5, "18XXX59", 0, 0));

                // reset sixth sem
                studentDao.insert(new Marks(6, "18XX61", 0, 0));
                studentDao.insert(new Marks(6, "18XX62", 0, 0));
                studentDao.insert(new Marks(6, "18XX63", 0, 0));
                studentDao.insert(new Marks(6, "18XX64X", 0, 0));
                studentDao.insert(new Marks(6, "18XX65X", 0, 0));
                studentDao.insert(new Marks(6, "18XXX66", 0, 0));
                studentDao.insert(new Marks(6, "18XXX67", 0, 0));
                studentDao.insert(new Marks(6, "18XXX68", 0, 0));

                // reset seventh sem
                studentDao.insert(new Marks(7, "18XX71", 0, 0));
                studentDao.insert(new Marks(7, "18XX72", 0, 0));
                studentDao.insert(new Marks(7, "18XX73X", 0, 0));
                studentDao.insert(new Marks(7, "18XX74X", 0, 0));
                studentDao.insert(new Marks(7, "18XX75X", 0, 0));
                studentDao.insert(new Marks(7, "18XXX76", 0, 0));
                studentDao.insert(new Marks(7, "18XXX77", 0, 0));
                studentDao.insert(new Marks(7, "18XXX78", 0, 0));

                // reset eighth sem
                studentDao.insert(new Marks(8, "18XX81", 0, 0));
                studentDao.insert(new Marks(8, "18XX82X", 0, 0));
                studentDao.insert(new Marks(8, "18XXX83", 0, 0));
                studentDao.insert(new Marks(8, "18XXX84", 0, 0));
                studentDao.insert(new Marks(8, "18XXX85", 0, 0));

            });
        }
    };

    public static synchronized StudentDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    StudentDatabase.class, "StudentDatabase")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    public static void resetDatabase() {

        databaseWriteExecutor.execute(() -> {
            StudentDao studentDao = instance.databaseDao();
            studentDao.deleteAllCgpa();
            studentDao.insert(new Cgpa(0.0));

            studentDao.deleteAllStudents();
            studentDao.insert(new Student("4MH18XXXXX", "Your Name", "Your branch name"));

            studentDao.deleteAllSgpa();
            studentDao.insert(new Sgpa(1, 0.0, 0));
            studentDao.insert(new Sgpa(2, 0.0, 0));
            studentDao.insert(new Sgpa(3, 0.0, 0));
            studentDao.insert(new Sgpa(4, 0.0, 0));
            studentDao.insert(new Sgpa(5, 0.0, 0));
            studentDao.insert(new Sgpa(6, 0.0, 0));
            studentDao.insert(new Sgpa(7, 0.0, 0));
            studentDao.insert(new Sgpa(8, 0.0, 0));

            // deleting all previous marks
            studentDao.deleteAllMarks();

            // reset first sem
            studentDao.insert(new Marks(1, "18XXX11", 0, 0));
            studentDao.insert(new Marks(1, "18XXX12", 0, 0));
            studentDao.insert(new Marks(1, "18XXX13", 0, 0));
            studentDao.insert(new Marks(1, "18XXX14", 0, 0));
            studentDao.insert(new Marks(1, "18XXX15", 0, 0));
            studentDao.insert(new Marks(1, "18XXX16", 0, 0));
            studentDao.insert(new Marks(1, "18XXX17", 0, 0));
            studentDao.insert(new Marks(1, "18XXX18", 0, 0));

            // reset second sem
            studentDao.insert(new Marks(2, "18XXX21", 0, 0));
            studentDao.insert(new Marks(2, "18XXX22", 0, 0));
            studentDao.insert(new Marks(2, "18XXX23", 0, 0));
            studentDao.insert(new Marks(2, "18XXX24", 0, 0));
            studentDao.insert(new Marks(2, "18XXX25", 0, 0));
            studentDao.insert(new Marks(2, "18XXX26", 0, 0));
            studentDao.insert(new Marks(2, "18XXX27", 0, 0));
            studentDao.insert(new Marks(2, "18XXX28", 0, 0));

            // reset third sem
            studentDao.insert(new Marks(3, "18XXX31", 0, 0));
            studentDao.insert(new Marks(3, "18XX32", 0, 0));
            studentDao.insert(new Marks(3, "18XX33", 0, 0));
            studentDao.insert(new Marks(3, "18XX34", 0, 0));
            studentDao.insert(new Marks(3, "18XX35", 0, 0));
            studentDao.insert(new Marks(3, "18XX36", 0, 0));
            studentDao.insert(new Marks(3, "18XXX37", 0, 0));
            studentDao.insert(new Marks(3, "18XXX38", 0, 0));
            studentDao.insert(new Marks(3, "18XXX39", 0, 0));

            // reset fourth sem
            studentDao.insert(new Marks(4, "18XXX41", 0, 0));
            studentDao.insert(new Marks(4, "18XX42", 0, 0));
            studentDao.insert(new Marks(4, "18XX43", 0, 0));
            studentDao.insert(new Marks(4, "18XX44", 0, 0));
            studentDao.insert(new Marks(4, "18XX45", 0, 0));
            studentDao.insert(new Marks(4, "18XX46", 0, 0));
            studentDao.insert(new Marks(4, "18XXX47", 0, 0));
            studentDao.insert(new Marks(4, "18XXX48", 0, 0));
            studentDao.insert(new Marks(4, "18XXX49", 0, 0));

            // reset fifth sem
            studentDao.insert(new Marks(5, "18XX51", 0, 0));
            studentDao.insert(new Marks(5, "18XX52", 0, 0));
            studentDao.insert(new Marks(5, "18XX53", 0, 0));
            studentDao.insert(new Marks(5, "18XX54", 0, 0));
            studentDao.insert(new Marks(5, "18XX55", 0, 0));
            studentDao.insert(new Marks(5, "18XX56", 0, 0));
            studentDao.insert(new Marks(5, "18XXX57", 0, 0));
            studentDao.insert(new Marks(5, "18XXX58", 0, 0));
            studentDao.insert(new Marks(5, "18XXX59", 0, 0));

            // reset sixth sem
            studentDao.insert(new Marks(6, "18XX61", 0, 0));
            studentDao.insert(new Marks(6, "18XX62", 0, 0));
            studentDao.insert(new Marks(6, "18XX63", 0, 0));
            studentDao.insert(new Marks(6, "18XX64X", 0, 0));
            studentDao.insert(new Marks(6, "18XX65X", 0, 0));
            studentDao.insert(new Marks(6, "18XXX66", 0, 0));
            studentDao.insert(new Marks(6, "18XXX67", 0, 0));
            studentDao.insert(new Marks(6, "18XXX68", 0, 0));

            // reset seventh sem
            studentDao.insert(new Marks(7, "18XX71", 0, 0));
            studentDao.insert(new Marks(7, "18XX72", 0, 0));
            studentDao.insert(new Marks(7, "18XX73X", 0, 0));
            studentDao.insert(new Marks(7, "18XX74X", 0, 0));
            studentDao.insert(new Marks(7, "18XX75X", 0, 0));
            studentDao.insert(new Marks(7, "18XXX76", 0, 0));
            studentDao.insert(new Marks(7, "18XXX77", 0, 0));
            studentDao.insert(new Marks(7, "18XXX78", 0, 0));

            // reset eighth sem
            studentDao.insert(new Marks(8, "18XX81", 0, 0));
            studentDao.insert(new Marks(8, "18XX82X", 0, 0));
            studentDao.insert(new Marks(8, "18XXX83", 0, 0));
            studentDao.insert(new Marks(8, "18XXX84", 0, 0));
            studentDao.insert(new Marks(8, "18XXX85", 0, 0));

        });
    }

    public abstract StudentDao databaseDao();

}
