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
public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  	
	//using this main class for calling all other sub classes used for executing the code

        BMIAnalyser a = new BMIAnalyser();
        a.loadFromTables();
        View v = new View(a);
        v.commandLoop();
    }
}
