
package ArrayOperations;

import java.util.Arrays;


public class Operations {
    
    public int[] array1;
    
    public Operations(int[] array){
        array1 = array;
        }
    
    public void printPositiveAndNegative(){
        int posLength = 0, negLength = 0;

        for (int i : array1) {
            if (i > 0) {
                posLength++;
            }
            if (i < 0) {
                negLength++;
            }
        }
        
        int[] posArray = new int[posLength];
        int[] negArray = new int[negLength];

        posLength = 0;
        negLength = 0;

        for (int i : array1) {
            if (i > 0) {
                posArray[posLength] = i;
                posLength++;
            }
            if (i < 0) {
                negArray[negLength] = i;
                negLength++;
            }
        }

        System.out.print("Positive array: ");
        for (int i : posArray) {
            System.out.print(" " + i);
        }

        System.out.print("\nNegative array: ");
        for (int i : negArray) {
            System.out.print(" " + i);
        }
    }
    public void printDuplicates(){
        Arrays.sort(array1);
        
        System.out.print("\nDuplicates are:\n ");
        for (int i = 0; i < array1.length - 1; i++) {
            if (array1[i] == array1[i + 1]) {
                int count =1;
          
                while(i < array1.length - 1 && array1[i] == array1[i + 1]){
                    count++;
                    i++;
                    }
                System.out.println(" " + array1[i] + " and appears " + count + " times.");
            }
        }
    }    
}
