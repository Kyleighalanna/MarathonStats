/* This was fun!
Name: Kyleigh McCarthy
Class: CSC 210- 06
Semester: Fall 2021
Assignment: Project3
Changes I made(ways I deviated from instructions):
-I named the file & main class "Marathon" instead of "SFMarathon" because I created
    the file & class and started the program before seeing the given program
    skeleton that stated the suggested class name.
-Appended an "s" to fastestRunner method, just made more sense to me since it
    prints out fastest 3, rather than fastest 1.
-Passed in both int arrays to fastestRunner, instead of just one int and one String,
    so that whenever we swap positions in one array, we can swap in all arrays in
    order to keep them all consistent.
-Added 5 additional swap functions, also for the purpose of keeping the order
    consistent between arrays:
        1. swapFirstMin to swap the minutes of the first runner (not just name)
        2. swapSecond to swap the name of second place runner
        3. swapSecondMin to swap the minutes of second place runner
        4. swapThird to swap the name of third place runner
        5. swapThirdMin to swap the minutes of third place runner
 */

public class Marathon {
    //************************ MAIN METHOD *************************
    public static void main(String[] args){
        // Declare arrays
        String[] runnerNames = {"Stephanie", "Caleb", "Gavin",
                "Simon", "Martha", "Cindy", "Lola",
                "Terrel", "Michael", "Sara", "Jared",
                "Juan", "Joseph"};
        int[] minutes2018 = {307, 299, 432, 326, 275, 450, 265,
                343, 264, 308, 242, 377, 256};
        int[] minutes2019 = {299, 307, 328, 283, 274, 359, 256,
                343, 269, 308, 249, 340, 240};

        // Program output
        // Calling fastestRunners
        System.out.println("The three fastest runners in 2018 and their time in minutes are:");
        fastestRunners(minutes2018, minutes2019, runnerNames);
        System.out.println();

        System.out.println("The three fastest runners in 2019 and their time in minutes are:");
        fastestRunners(minutes2019, minutes2018, runnerNames);
        System.out.println();

        // Calling compareTimes
        System.out.println("The list of students who improved their time from 2018 to 2019 are:");
        for (int i = 0; i < compareTimes(minutes2018, minutes2019).length; i++){
            if ((compareTimes(minutes2018, minutes2019))[i] > 0)
                System.out.println(runnerNames[i] + ": " + compareTimes(minutes2018, minutes2019)[i]);
        }
        System.out.println();

        int highest = 0;
        int highestIndex = 0;
        // Find tenacious runner
        for(int i = 0; i < compareTimes(minutes2018, minutes2019).length; i++){
            if (compareTimes(minutes2018, minutes2019)[i] > highest) {
                highest = compareTimes(minutes2018, minutes2019)[i];
                highestIndex = i;
            }
        }
        // Print tenacious runner
        System.out.println(runnerNames[highestIndex] + " is the tenacious runner.");
        System.out.println();

        // Call meanTime method
        System.out.println("The average running time in 2018: " + meanTime(minutes2018) + " minutes");
        System.out.println("The average running time in 2019: " + meanTime(minutes2019) + " minutes");
        // Call median method
        System.out.println("The median running time in 2018:" + median(minutes2018) + " minutes");
        System.out.println("The median running time in 2019:" + median(minutes2019) + " minutes");
    }

    // ************************ METHODS ****************************
    public static int fastestRunners(int[] array0, int[] array2, String[] array1){
        int firstMin = 0;
        int secondMin = 0;
        int thirdMin = 0;
        int highestMin = 0;

        int firstIndex = 0;
        int secondIndex = 0;
        int thirdIndex = 0;

        // Find highest time in minutes to prepare to find lowest/fastest
        for(int i = 0; i < array0.length; i++){
            if (array0[i] > highestMin)
                highestMin = array0[i];
        }
        // Swap first
        // Set firstMin to max minutes
        firstMin = highestMin;

        // Find first place
        for(int i = 0; i < array0.length; i++) {
            if (array0[i] < firstMin) {
                firstIndex = i;
                firstMin = array0[i];
            }
        }

        swapFirst(array1, firstIndex);
        swapFirstMin(array0, firstIndex);
        swapFirstMin(array2, firstIndex);
        // Now first place is first in array

        // keep original value of highestMin
        int tempHighestMin = highestMin;

        // Set secondMin to highestMin
        secondMin = highestMin;

        // Find second place
        for(int i = 1; i < array0.length; i++){
            if (array0[i] < secondMin){
                secondMin = array0[i];
                secondIndex = i;
            }
        }
        // Restore highestMin value
        highestMin = tempHighestMin;

        // Set thirdMin to highestMin
        thirdMin = highestMin;

        // Swap arrays
        swapSecond(array1, secondIndex);
        swapSecondMin(array0, secondIndex);
        swapSecondMin(array2, secondIndex);
        // Now second place is second in array

        // Find third place
        for(int i = 2; i < array0.length; i++){
            if (array0[i] < thirdMin) {
                thirdMin = array0[i];
                thirdIndex = i;
            }
        }

        swapThird(array1, thirdIndex);
        swapThirdMin(array0, thirdIndex);
        swapThirdMin(array2, thirdIndex);
        // Now third place is second in array

        // Print out the name and time of first, second, and third place runners
        System.out.println(array1[0] + ": " + array0[0]);
        System.out.println(array1[1] + ": " + array0[1]);
        System.out.println(array1[2] + ": " + array0[2]);
        return firstIndex;
    }
    public static String[] swapFirst(String[] array, int value){
       String swapTemp = array[0];
       array[0] = array[value];
       array[value] = swapTemp;

         return array;
    }
    public static int[] swapFirstMin(int[] array, int value){
        int swapTemp = array[0];
        array[0] = array[value];
        array[value] = swapTemp;

        return array;
    }
    public static String[] swapSecond(String[] array, int value) {
        String swapTemp = array[1];
        array[1] = array[value];
        array[value] = swapTemp;

        return array;
    }
    public static int[] swapSecondMin(int[] array, int value){
        int swapTemp = array[1];
        array[1] = array[value];
        array[value] = swapTemp;

        return array;
    }
    public static String[] swapThird(String[] array, int value) {
        String swapTemp = array[2];
        array[2] = array[value];
        array[value] = swapTemp;

        return array;
    }
    public static int[] swapThirdMin(int[] array, int value) {
        int swapTemp = array[2];
        array[2] = array[value];
        array[value] = swapTemp;

        return array;
    }

    public static int[] compareTimes(int[] minutes2018, int[] minutes2019){
        int[] timeImproved = new int [minutes2018.length];

        for(int i = 0; i < minutes2018.length; i++)
            timeImproved[i] = minutes2018[i] - minutes2019[i];

        return timeImproved;
    }

    public static double meanTime(int[] array){
        double average = 0.0;
        double total = 0.0;

        for(int i = 0; i < array.length; i++)
            total += array[i];

        average = total / (double)(array.length);

        return Math.round(average*1000.0)/1000.0;
    }

    public static double median(int[] array){
        // First, put the arrays in increasing order
        for(int outer = 0; outer < array.length; outer++){
            for (int i = 0; i < array.length - 1; i ++){
                if(array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }

        // Array is sorted, now find median
        double median;
        if (array.length%2 == 0){
            // Find avg of two positions
            median = ((double)array[array.length/2] + (double)array[(array.length/2 +1)]) / 2;
            return Math.round(median*1000.0)/1000.0;
        }
        else {
            median = array[array.length / 2];
            return Math.round(median*1000.0)/1000.0;
        }
    }

} // End Marathon class