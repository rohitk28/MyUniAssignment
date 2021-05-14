/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author 12045806
 */
public class Record {

    private String subjectid;
    private double height;
    private double weigth;
    private double bmiValue;
    private String category;

    public Record(String sid, double h, double w, double bmi, String c) {
        this.subjectid = sid;
        this.height = h;
        this.weigth = w;
        this.bmiValue = bmi;
        this.category = c;
    }

    public String getSubjectid() {
        return subjectid;
	//  returns subject id to view class

    }

    public double getHeight() {
        return height;
	//  returns height to View class
    }

    public double getWeigth() {
        return weigth;
	//  returns weight to View class
    }

    public double getBmiValue() {
        return bmiValue;
	//  returns BmiValue to View class
    }

    public String getCategory() {
        return category;
	//  returns category to View class
    }

}
