import java.util.Scanner;
import java.io.*;

class ISort {
    // This program implements Insertion Sort for a random array
    // and counts how many comparisons it performs.  
    // parameters.  Written by ccm 2/2009
    static PrintWriter aOutput = null;
    public static Scanner keyboard = new Scanner (System.in);
    static double counter = 0.0;
    static double sum = 0.0;

    //----------runOneTrial---------------------------------------
    static void runOneTrial (Scanner sc) {

	 counter = 0.0;
        double tmp; 
        int j; 

    int t = sc.nextInt();
    int n = sc.nextInt();

    double[] nums = new double[n];
    for (int i=0; i<n; i++){
        //System.out.println(Double.parseDouble(sc.next()));
        nums[i] = Double.parseDouble(sc.next());
        //System.out.println(input[i]+" "+i);
    }


	for (int i = 1; i < n; i++ ) {
	    // assert:  A[0..i-1] is sorted, A[i] is next
            tmp = nums[i];
            j = i-1; 
            while (j >= 0) {
		// assert: the hole is at A[j+1] ; check A[j] next

		counter++ ;                // comparison on next line 

                if (nums[j] < tmp) break;  // hole should be at j+1
                nums[j+1] = nums[j];       // hole is at j 
                j--;                       // hole is at j+1 

            }
            // assert: hole is at j+1
            nums[j+1] = tmp;
	}// for i
	// sanity check: print first ten numbers to see if it looks ok 
	/* ------------commented out 
        int nx = 10; 
        if (n <= 10) nx = n; 
        for (int i = 0; i < nx ; i++) System.out.print(nums[i] +"\t" ); 
        System.out.println();
        ----------------*/ 
	aOutput.println( n + " " + t  + "  " + counter);
     
    }//runOneTrial 

    //-----------------main--------------------------------------------
    public static void main (String[] args) {


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
    
    

	while (sc.hasNextInt()){
	    runOneTrial (sc) ;
        sum = sum + counter;
	}
    aOutput.println(sum);
    aOutput.close();
    }// main 
}// class 
