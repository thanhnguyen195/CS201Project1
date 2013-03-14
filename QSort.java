import java.util.Scanner;
import java.io.*;

class QSort {
    static PrintWriter aOutput = null;
    public static int counter;
    public static int sum=0;

    public static void main(String[] args){
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("AverageInput.dat"));
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
        
        try {
            aOutput = new PrintWriter(new FileWriter("AverageOutput.dat"));
        } catch(Exception e){
            System.exit(1);
        }
        
        QSort qs = new QSort();
        while (sc.hasNextInt()){
            qs.runOneTrial(sc);
            sum = sum + counter;
        }
        aOutput.println(sum);
        aOutput.close();
    }
    
    public void runOneTrial(Scanner sc){
        int t = sc.nextInt();
        int n = sc.nextInt();
        counter = 0;
        double[] input = new double[n];
        for (int i=0; i<n; i++){
            input[i] = Double.parseDouble(sc.next());
        }
        quickSort(input,0,n-1);
        aOutput.println(t+" "+n+" "+counter);
    }
    
    public void quickSort(double[] arr, int l, int r){
        counter++; //comparision of the next operation
        if (l>=r)
            return;
        else {
            //int m = partitionMid(arr,l,r);
            int m = partition(arr,l,r);
            quickSort(arr,l,m-1);
            quickSort(arr,m+1,r);
            return;
        }
    }
    
    public int partition(double[] arr, int l, int r){
        double token = arr[r];
        int result = l;
        for (int i=l; i<r; i++){
            counter++;
            if (arr[i]<token){
                double intermediate = arr[i];
                arr[i] = arr[result];
                arr[result] = intermediate;
                result++;
            }
        }
        token = arr[result];
        arr[result] = arr[r];
        arr[r] = token;

        return result;
    }
    
    public int partitionMid(double[] arr, int l, int r){
        int pivot = (r-l)/2 + l;
        double token = arr[pivot];
        arr[pivot] = arr[r];
        arr[r] = token;
        int result = l;
        for (int i=l; i<r; i++){
            counter++;
            if (arr[i]<token){
                double intermediate = arr[i];
                arr[i] = arr[result];
                arr[result] = intermediate;
                result++;
            }
        }
        token = arr[result];
        arr[result] = arr[r];
        arr[r] = token;

        return result;
    }

    
}