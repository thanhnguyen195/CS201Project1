import java.util.Scanner;
import java.io.*;

class inputProducer {
    static final int cap = 1000000000;

    public static void main (String[] args){
        int n = 10;
        int t = 30;
        double[] input = new double[n];
        inputProducer ip = new inputProducer();
        
        //create input for average case with size n and t trial
        PrintWriter aOutput = null;
        try {
            aOutput = new PrintWriter(new FileWriter("AverageInput.dat"));
        } catch (Exception e){
            System.exit(1);
        }
        for (int j=0; j<t; j++){
            aOutput.println(j+1+" "+n);
            input = ip.averageInput(n);
            for (int i=0; i<n; i++){
                aOutput.println(input[i]);
            }
        }
        aOutput.close();
        
        //create input for best and worst case with size n and t trial
        PrintWriter bwOutput = null;
        try {
            bwOutput = new PrintWriter(new FileWriter("BestWorstInput.dat"));
        } catch (Exception e){
            System.exit(1);
        }
        for (int j=0; j<t; j++){
            bwOutput.println(j+1+" "+n);
            input = ip.BestWorstInput(n);
            for (int i=0; i<n; i++){
                bwOutput.println(input[i]);
            }
        }
        bwOutput.close();
        
        
    }
    
    public double[] averageInput(int n){
        double[] result = new double[n];
        for (int i=0; i<n; i++){
            result[i] = Math.random() * cap;
        }
        return result;
    }
    
    public double[] BestWorstInput(int n){
        double[] result = new double[n];
        for (int i=0; i<n; i++){
            result[i] = Math.random() * cap;
        }
        QSort qs = new QSort();
        qs.quickSort(result,0,n-1);
        return result;
    }
    
    
}