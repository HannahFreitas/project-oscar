package Main;

import ReadFile.ReadFile;

import java.util.Scanner;

public class Main {
    private static ReadFile readFileFemale;
    private static ReadFile readFileMale;


    public static void main(String[] args) {
        readFileFemale = new ReadFile("oscar_age_female.csv");
        readFileMale = new ReadFile("oscar_age_male.csv");

        readFileMale.actorOscarMinAge();

        readFileFemale.actressMoreAwarded();
        readFileFemale.actress20and30YearsWinOscar();

        readFileFemale.listActorsAndActressMoreOneOscar(readFileMale);



    }
}
