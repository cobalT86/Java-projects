package ArrayOperations;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array1 = {12, 0, -22, 0, 43, 545, -4, -55, 545, 12, 43, 0, -999, -87};

        Operations calcul = new Operations(array1);

        calcul.printPositiveAndNegative();
        calcul.printDuplicates();

    }

}
