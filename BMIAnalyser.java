/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 12045806
 */
public class BMIAnalyser {

//declaring variables of Record type

    private int nrecords;
    private Record[] data;

    public BMIAnalyser() {
    }
	//Constructor calling methods inside BMIAnalyser class

    public Record find(String sid) {
	//using linear sort we do the unsorted list of student ID beore that it uses binary search
        
	sortByid();
        int low = 0;
        int high = data.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (data[mid].getSubjectid().compareTo(sid) < 0) {
                low = mid + 1;
            } else if (data[mid].getSubjectid().compareTo(sid) > 0) {
                high = mid - 1;
            } else {
                return data[mid];
            }
        }
        return null;
    }
	// using this method we declare the subjetc id's. hieght, wegiht, array and intilized, BMI values are calculated and stored in a array
    public void loadFromTables() {
        String[] subject = {"S03", "S01", "S04", "S08", "S06","S02"};
        double[] height = {1.82, 1.82, 1.78, 1.68, 1.98,1.82};
        double[] weight = {80.0, 100.0, 120, 110, 70, 60};
        nrecords = subject.length;
        data = new Record[nrecords];
        for (int i = 0; i < nrecords; i++) {
            double v = weight[i] / (height[i] * height[i]);
            String c = classify(v);
            Record r = new Record(subject[i], height[i], weight[i], v, c);
            data[i] = r;

        }
    }
//this method is used to take two bmi values from the given range in between 0 to 100

    public ArrayList<Record> find(double bmi1, double bmi2) {
        ArrayList<Record> alr = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i].getBmiValue() >= bmi1 && data[i].getBmiValue() <= bmi2) {
                alr.add(data[i]);
            }
        }
        return alr;
    }

// 
    public ArrayList<Record> getArray() {
        ArrayList<Record> alr = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            alr.add(data[i]);
        }
        return alr;
    }
// lowest bmi value is calculated
    public double lowestBMI() {
        Record r = data[0];
        for (int i = 0; i < data.length; i++) {
            if (r.getBmiValue() >= data[i].getBmiValue()) {
                r = data[i];
            }
        }
        return r.getBmiValue();
    }
// highest Bmi value is calculated

    public double highestBMI() {
        Record r = data[0];
        for (int i = 0; i < data.length; i++) {
            if (r.getBmiValue() <= data[i].getBmiValue()) {
                r = data[i];
            }
        }
        return r.getBmiValue();
    }
// avaregare Bmi value is calculated

    public double averageBMI() {
        double sum = 0;
        double avg = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i].getBmiValue();
        }
        avg = sum / data.length;
        return avg;
    }

    //used insertion sort
    public void sortByid() {
        int i, j;
        Record key;
        for (j = 1; j < data.length; j++) { //the condition has changed
            key = data[j];
            i = j - 1;
            while (i >= 0) {
                if (key.getSubjectid().compareTo(data[i].getSubjectid()) > 0) {//here too
                    break;
                }
                data[i + 1] = data[i];
                i--;
            }
            data[i + 1] = key;
        }
    }

    public String classify(double bmi) {
        String message = null;
        if (bmi < 15) {
            message = "Very severely underweight";
        } else if (bmi >= 15 && bmi < 16) {
            message = "Severely underweight";
        } else if (bmi >= 16 && bmi < 18.5) {
            message = "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            message = "Normal (healthy weight)";
        } else if (bmi >= 25 && bmi < 30) {
            message = "Overweight";
        } else if (bmi >= 30 && bmi < 36) {
            message = "Obese Class I (Moderately obese)";
        } else if (bmi >= 35 && bmi < 40) {
            message = "Obese Class II (Severely obese)";
        } else if (bmi >= 40) {
            message = "Obese Class III (Very severely obese)";
        }
        return message;
    }
}
