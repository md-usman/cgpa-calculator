package com.example.android.cgpacalculator;

import com.example.android.cgpacalculator.database.tables.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Data {


    public static List<Subjects> getFirstSemSubjects() {

        List<Subjects> firstSemSubjects = new ArrayList<>(8);

        firstSemSubjects.add(new Subjects("18XXX11", 1, 4));
        firstSemSubjects.add(new Subjects("18XXX12", 1, 4));
        firstSemSubjects.add(new Subjects("18XXX13", 1, 3));
        firstSemSubjects.add(new Subjects("18XXX14", 1, 3));
        firstSemSubjects.add(new Subjects("18XXX15", 1, 3));
        firstSemSubjects.add(new Subjects("18XXX16", 1, 1));
        firstSemSubjects.add(new Subjects("18XXX17", 1, 1));
        firstSemSubjects.add(new Subjects("18XXX18", 1, 1));

        return firstSemSubjects;

    }

    public static List<Subjects> getSecondSemSubjects() {

        List<Subjects> secondSemSubjects = new ArrayList<>(8);

        secondSemSubjects.add(new Subjects("18XXX21", 2, 4));
        secondSemSubjects.add(new Subjects("18XXX22", 2, 4));
        secondSemSubjects.add(new Subjects("18XXX23", 2, 3));
        secondSemSubjects.add(new Subjects("18XXX24", 2, 3));
        secondSemSubjects.add(new Subjects("18XXX25", 2, 3));
        secondSemSubjects.add(new Subjects("18XXX26", 2, 1));
        secondSemSubjects.add(new Subjects("18XXX27", 2, 1));
        secondSemSubjects.add(new Subjects("18XXX28", 2, 1));

        return secondSemSubjects;
    }

    public static List<Subjects> getThirdSemSubjects() {

        List<Subjects> thirdSemSubjects = new ArrayList<>(9);

        thirdSemSubjects.add(new Subjects("18XXX31", 3, 3));
        thirdSemSubjects.add(new Subjects("18XX32", 3, 4));
        thirdSemSubjects.add(new Subjects("18XX33", 3, 3));
        thirdSemSubjects.add(new Subjects("18XX34", 3, 3));
        thirdSemSubjects.add(new Subjects("18XX35", 3, 3));
        thirdSemSubjects.add(new Subjects("18XX36", 3, 3));
        thirdSemSubjects.add(new Subjects("18XXX37", 3, 2));
        thirdSemSubjects.add(new Subjects("18XXX38", 3, 2));
        thirdSemSubjects.add(new Subjects("18XXX39", 3,1));

        return thirdSemSubjects;
    }

    public static List<Subjects> getFourthSemSubjects() {

        List<Subjects> fourthSemSubjects = new ArrayList<>(9);

        fourthSemSubjects.add(new Subjects("18XXX41", 4, 3));
        fourthSemSubjects.add(new Subjects("18XX42", 4, 4));
        fourthSemSubjects.add(new Subjects("18XX43", 4, 3));
        fourthSemSubjects.add(new Subjects("18XX44", 4, 3));
        fourthSemSubjects.add(new Subjects("18XX45", 4, 3));
        fourthSemSubjects.add(new Subjects("18XX46", 4, 3));
        fourthSemSubjects.add(new Subjects("18XXX47", 4, 2));
        fourthSemSubjects.add(new Subjects("18XXX48", 4, 2));
        fourthSemSubjects.add(new Subjects("18XXX49", 4,1));
        return fourthSemSubjects;
    }

    public static List<Subjects> getFifthSemSubjects() {

        List<Subjects> fifthSemSubjects = new ArrayList<>(9);

        fifthSemSubjects.add(new Subjects("18XX51", 5, 3));
        fifthSemSubjects.add(new Subjects("18XX52", 5, 4));
        fifthSemSubjects.add(new Subjects("18XX53", 5, 4));
        fifthSemSubjects.add(new Subjects("18XX54", 5, 3));
        fifthSemSubjects.add(new Subjects("18XX55", 5, 3));
        fifthSemSubjects.add(new Subjects("18XX56", 5, 3));
        fifthSemSubjects.add(new Subjects("18XXX57", 5, 2));
        fifthSemSubjects.add(new Subjects("18XXX58", 5, 2));
        fifthSemSubjects.add(new Subjects("18XXX59", 5,1));

        return fifthSemSubjects;
    }

    public static List<Subjects> getSixthSemSubjects() {
        List<Subjects> sixthSemSubjects = new ArrayList<>(8);

        sixthSemSubjects.add(new Subjects("18XX61", 6, 4));
        sixthSemSubjects.add(new Subjects("18XX62", 6, 4));
        sixthSemSubjects.add(new Subjects("18XX63", 6, 4));
        sixthSemSubjects.add(new Subjects("18XX64", 6, 3));
        sixthSemSubjects.add(new Subjects("18XX65", 6, 3));
        sixthSemSubjects.add(new Subjects("18XXX66", 6, 2));
        sixthSemSubjects.add(new Subjects("18XXX67", 6, 2));
        sixthSemSubjects.add(new Subjects("18XXX68", 6, 2));
        return sixthSemSubjects;
    }

    public static List<Subjects> getSeventhSemSubjects() {
        List<Subjects> seventhSemSubjects = new ArrayList<>(8);

        seventhSemSubjects.add(new Subjects("18XX71", 7, 3));
        seventhSemSubjects.add(new Subjects("18XX72", 7, 3));
        seventhSemSubjects.add(new Subjects("18XX73", 7, 3));
        seventhSemSubjects.add(new Subjects("18XX74", 7, 3));
        seventhSemSubjects.add(new Subjects("18XX75", 7, 3));
        seventhSemSubjects.add(new Subjects("18XXX76", 7, 2));
        seventhSemSubjects.add(new Subjects("18XXX77", 7, 2));
        seventhSemSubjects.add(new Subjects("18XXX78", 7, 1));
        return seventhSemSubjects;
    }

    public static List<Subjects> getEightSemSubjects() {
        List<Subjects> eightSemSubjects = new ArrayList<>(5);

        eightSemSubjects.add(new Subjects("18XX81", 8, 3));
        eightSemSubjects.add(new Subjects("18XX82", 8, 3));
        eightSemSubjects.add(new Subjects("18XXX83", 8, 8));
        eightSemSubjects.add(new Subjects("18XXX84", 8, 1));
        eightSemSubjects.add(new Subjects("18XXX85", 8, 3));
        return eightSemSubjects;

    }

    public static List<Subjects> getSelectedSemSubjects(int semester) {
        switch (semester) {
            case 1:
                return getFirstSemSubjects();
            case 2:
                return getSecondSemSubjects();
            case 3:
                return getThirdSemSubjects();
            case 4:
                return getFourthSemSubjects();
            case 5:
                return getFifthSemSubjects();
            case 6:
                return getSixthSemSubjects();
            case 7:
                return getSeventhSemSubjects();
            default:
                return getEightSemSubjects();
        }
    }

    public static List<Sem> getAllSem() {
        List<Sem> allSem = new ArrayList<>(8);

        allSem.add(new Sem(1, 20));
        allSem.add(new Sem(2, 20));
        allSem.add(new Sem(3,24));
        allSem.add(new Sem(4, 24));
        allSem.add(new Sem(5, 25));
        allSem.add(new Sem(6,24));
        allSem.add(new Sem(7, 20));
        allSem.add(new Sem(8, 18));
        return allSem;

    }

    public static HashMap<Integer, Integer> semCredits = new HashMap<>();
    public static int getSemCredits(int semId) {
        semCredits.put(1 , 20);
        semCredits.put(2 , 20);
        semCredits.put(3 , 24);
        semCredits.put(4 , 24);
        semCredits.put(5 , 25);
        semCredits.put(6 , 24);
        semCredits.put(7 , 20);
        semCredits.put(8 , 18);
        return semCredits.get(semId);
    }

    public static HashMap<String, Integer> subjectCredits = new HashMap<String, Integer>();

    public static int getSubjectCredits(String subjectCode) {
        subjectCredits.put("18XXX11", 4);
        subjectCredits.put("18XXX12", 4);
        subjectCredits.put("18XXX13", 3);
        subjectCredits.put("18XXX14", 3);
        subjectCredits.put("18XXX15", 3);
        subjectCredits.put("18XXX16", 1);
        subjectCredits.put("18XXX17", 1);
        subjectCredits.put("18XXX18", 1);

        subjectCredits.put("18XXX21", 4);
        subjectCredits.put("18XXX22", 4);
        subjectCredits.put("18XXX23", 3);
        subjectCredits.put("18XXX24", 3);
        subjectCredits.put("18XXX25", 3);
        subjectCredits.put("18XXX26", 1);
        subjectCredits.put("18XXX27", 1);
        subjectCredits.put("18XXX28", 1);

        subjectCredits.put("18XXX31", 3);
        subjectCredits.put("18XX32", 4);
        subjectCredits.put("18XX33", 3);
        subjectCredits.put("18XX34", 3);
        subjectCredits.put("18XX35", 3);
        subjectCredits.put("18XX36", 3);
        subjectCredits.put("18XXX37", 2);
        subjectCredits.put("18XXX38", 2);
        subjectCredits.put("18XXX39", 1);

        subjectCredits.put("18XXX41", 3);
        subjectCredits.put("18XX42", 4);
        subjectCredits.put("18XX43", 3);
        subjectCredits.put("18XX44", 3);
        subjectCredits.put("18XX45", 3);
        subjectCredits.put("18XX46", 3);
        subjectCredits.put("18XXX47", 2);
        subjectCredits.put("18XXX48", 2);
        subjectCredits.put("18XXX49", 1);

        subjectCredits.put("18XX51", 3);
        subjectCredits.put("18XX52", 4);
        subjectCredits.put("18XX53", 4);
        subjectCredits.put("18XX54", 3);
        subjectCredits.put("18XX55", 3);
        subjectCredits.put("18XX56", 3);
        subjectCredits.put("18XXX57", 2);
        subjectCredits.put("18XXX58", 2);
        subjectCredits.put("18XXX59", 1);

        subjectCredits.put("18XX61", 4);
        subjectCredits.put("18XX62", 4);
        subjectCredits.put("18XX63", 4);
        subjectCredits.put("18XX64", 3);
        subjectCredits.put("18XX65", 3);
        subjectCredits.put("18XXX66", 2);
        subjectCredits.put("18XXX67", 2);
        subjectCredits.put("18XXX68", 2);

        subjectCredits.put("18XX71", 3);
        subjectCredits.put("18XX72", 3);
        subjectCredits.put("18XX73", 3);
        subjectCredits.put("18XX74", 3);
        subjectCredits.put("18XX75", 3);
        subjectCredits.put("18XXX76", 2);
        subjectCredits.put("18XXX77", 2);
        subjectCredits.put("18XXX78", 1);

        subjectCredits.put("18XX81", 3);
        subjectCredits.put("18XX82", 3);
        subjectCredits.put("18XXX83", 8);
        subjectCredits.put("18XXX84", 1);
        subjectCredits.put("18XXX85", 3);

        return subjectCredits.get(subjectCode);
    }


}
