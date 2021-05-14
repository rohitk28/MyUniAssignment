/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 12045806
 */
public class View {

    private BMIAnalyser analyser;

    public View(BMIAnalyser a) {
        analyser = a;
    }

    public void commandLoop() {
        Scanner s = new Scanner(System.in);
        System.out.println(help());
        int command = s.nextInt();
        while (command != 9) {
            switch (command) {
 	// using switch case statement to execute command options to display 
                case 0:
                    System.out.println(help());
                    break;
                case 1:
	// case1 used to display the record for a specified subject ID
                    System.out.println("Enter any SubjectID(S01,S02,S03,S04,S06,S08)");
                    Scanner sc = new Scanner(System.in);
                    String sID = sc.nextLine();
                    Record r = analyser.find(sID);
                    if (r == null) {
                        System.out.println("SubjectID not found.");
                    } else {
                        System.out.println("SubjectID: " + r.getSubjectid() + "\n" + "Height: " + r.getHeight() + "\n" + "Weight: " + r.getWeigth() + "\n" + "BMI: " + r.getBmiValue() + "\n" + "Category: " + r.getCategory() + "\n");
                    }
                    System.out.println(help());
                    break;
                case 2:
	//checking and displaying the all subject Id in between given range 
                    double min;
                    double max;
                    boolean validityFailed = false;
                    do {
                        validityFailed = false;
                        System.out.println("Enter Min and Max BMI values between 0 and 100.");
                        min = s.nextInt();
                        max = s.nextInt();
                        if (!checkMin(min)) {
                            System.out.println("Check the Min value.");
                            validityFailed = true;
                            continue;
                        }
                        if (!checkMax(max)) {
                            System.out.println("Check the Max value");
                            validityFailed = true;
                            continue;
                        }
                        if (!checkRange(min, max)) {
                            System.out.println("Max value should be greater than Min value");
                            validityFailed = true;
                            continue;
                        }
                        if (!checkequal(min, max)) {
                            System.out.println("Max value should be greater than Min value");
                            validityFailed = true;
                            continue;
                        }
                    } while (validityFailed);

                    ArrayList range = analyser.find(min, max);
                    if (range.isEmpty()) {
                        System.out.println("No records between entered range.");
                    } else {
                        for (int i = 0; i < range.size(); i++) {
                            Record rec = (Record) range.get(i);
                            System.out.println("SubjectID: " + rec.getSubjectid() + "\n" + "Height: " + rec.getHeight() + "\n" + "Weight: " + rec.getWeigth() + "\n" + "BMI: " + rec.getBmiValue() + "\n" + "Category: " + rec.getCategory() + "\n");
                        }
                    }
                    System.out.println(help());
                    break;
                case 3:
	//Display the lowest, highest and average BMIs 
                    System.out.println("Min BMI value is" + analyser.lowestBMI());
                    System.out.println("Max BMI value is" + analyser.highestBMI());
                    System.out.println("Avg BMI value is" + analyser.averageBMI());
                    System.out.println();
                    System.out.println(help());
                    break;
                default:
                    System.out.println("Enter Correct option.");
                    System.out.println(help());
                    break;
            }
            command = s.nextInt();
        }
        s.close();
        System.out.println("End of Application");
    }

    private String help() {

        // using help() method

        return "The following commands are recognised\n"
                + "\tDisplay this message again                             > 0\n"
                + "\tDisplay a specific subject record:                     > 1\n"
                + "\tDisplay records for all subject records within a range > 2\n"
                + "\tDisplay statistics (minimum, maximum and average BMI)  > 3\n"
                + "\tExit the application                                   > 9\n"
                +"Enter only integer as your choice:";
    }

    private boolean checkMin(double min) {
        if (min < 0 || min > 100) {
            return false;
        }
        return true;
    }

    private boolean checkMax(double max) {
        if (max < 0 || max > 100) {
            return false;
        }
        return true;
    }

    private boolean checkRange(double min, double max) {
        if (min > max) {
            return false;
        }
        return true;
    }

    private boolean checkequal(double min, double max) {
         if (min== max) {
            return false;
        }
        return true;
    }

}
