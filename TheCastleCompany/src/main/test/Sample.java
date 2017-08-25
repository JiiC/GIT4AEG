package main.test;

import main.java.Analyse;

public class Sample {

    public static void main(String[] args) {
        System.out.println("The Castle Company \n==================\n");

        // null case
//        int[] sample = null;
        // single case
//        int[] sample = {45};
        // flat case
//        int[] sample = {6, 6, 6, 6, 6};
        // negative only
//        int[] sample = {-1, -33, -4};
        // higher only
//        int[] sample = {-100, 2, 3, 4, 5};
        // lower only
//        int[] sample = {500, -2, -3, -4, -5};
        // sample 1: start + 2 peaks + 1 valley
//        int[] sample = {2, 6, 2, 6, 2};
        // sample 2: start + 1 peak + 1 valley
        int[] sample = {2, -1, -1, 6, 2};
        // sample 3: start + 1 peak + 1 valley
//        int[] sample = {2, 2, 6, 2, 8};
        // sample 4: start + 1 peak 
//        int[] sample = {2, 6, 2, 2, 2};
        // example 1
//        int[] sample = {2, 6, 6, 6, 1};
        // example 2
//        int[] sample = {6, 1, 4};
        
        Analyse analyse = new Analyse(sample);
        analyse.doAnalyse();
        
        
      
    }

}