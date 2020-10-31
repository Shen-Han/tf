package sample;

/*
Shen Han 100088024
 */
import java.util.Date;

import static java.lang.Math.*;

public class Athelete {

    private int run1=0,
                run2=0,
                id,
                bib,
                fastestRun,
                yearOfBirth;
    private double combinedTime;
    private String fullName,
                   gender,
                   club,
                   combinedTimeString;
    private String reGex = "[A-Z][a-z]*[-.]*? [A-Z][a-z]*( [A-Z])?";

    public Athelete(int id, int bib, String fullName, int yearOfBirth, int run1, int run2, String gender, String club, int fastestRun, double combinedTime, String combinedTimeString) {
        setRun1(run1);
        setRun2(run2);
        setYearOfBirth(yearOfBirth);
        setId(id);
        setFullName(fullName);
        setGender(gender);
        setBib(bib);
        setClub(club);
        setFastestRun(fastestRun);
        setCombinedTime(combinedTime);
        setCombinedTimeString(combinedTimeString);
    }

    public double getCombinedTime() {
        return combinedTime;
    }

    public void setCombinedTime(double combinedTime) {
        combinedTime = run1 + run2;
    }

    public String getCombinedTimeString() {
        return combinedTimeString;
    }

    public void setCombinedTimeString(String combinedTimeString) {
        combinedTimeString = String.format("%.2f", getCombinedTime());
    }

    public int getRun1() {
        return run1;
    }

    public void setRun1(int run1) {
        if(run2 > 40) {
            this.run1 = run1;
        } else throw new IllegalArgumentException("Either this time was recorded wrong or this person took a huge shortcut.");
    }

    public int getBib(){
        return bib;
    }

    public void setBib (int bib){
        this.bib = bib;
    }

    public String getClub(){
        return club;
    }

    public void setClub (String club){
        this.club = club;
    }

    public int getRun2() {
        return run2;
    }

    public void setRun2(int run2) {
        if(run2 > 40) {
            this.run2 = run2;
        } else throw new IllegalArgumentException("Either this time was recorded wrong or this person took a huge shortcut.");
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth == 2004 || yearOfBirth == 2005) {
            this.yearOfBirth = yearOfBirth;
        } else throw new IllegalArgumentException("Participants can only be born in 2004 or 2005");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        if(id > 0) {
            this.id = id;
        } else System.out.printf("ID must be greater than 0");
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String firstName) {
        if (fullName.matches(reGex)) {
            this.fullName = fullName;
        } else throw new IllegalArgumentException("Name is invalid, non-name characters found.");
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender.equals("male")||gender.equals("female")) {
            this.gender = gender;
        } else throw new IllegalArgumentException("Gender must be male or female.");
    }

    public int getFastestRun() {
        return fastestRun;
    }

    public void setFastestRun(int fastestRun) {
        this.fastestRun = fastestRun;
        //Ran out of time
        //Math.max(run1, run2) = fastestRun;
    }
}
