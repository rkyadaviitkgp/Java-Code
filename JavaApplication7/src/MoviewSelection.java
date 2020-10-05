
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rajeshkumar.yadav
 */
public class MoviewSelection {

    // problem :  given a list of moview with time duration and given fligt durartion 
    int[] moviesDurations;
    int flightDuration;

    public MoviewSelection(int md[], int fd) {
        moviesDurations = md;
        flightDuration = fd;
    }

    // return two best moview according to criteria 
    public int[] getMoviewPair() {

        int[] bestMoview = new int[2];
        int dynTable[][] = new int[flightDuration + 1][moviesDurations.length + 1];

        for (int i = 0; i <= flightDuration; i++) {
            dynTable[i][0] = 0;
        }
        for (int i = 0; i <= moviesDurations.length; i++) {
            dynTable[0][i] = 0;
        }

        for (int i = 1; i <= flightDuration; i++) {
            for (int j = 1; j <= moviesDurations.length; j++) {

                if (i >= moviesDurations[j - 1]) {
                    //if this item and other > current itenms
                    if (moviesDurations[j - 1] + dynTable[i - moviesDurations[j - 1]][j - 1] > bestMoview[0] + bestMoview[1]) {

                        if (moviesDurations[j - 1] > dynTable[i - moviesDurations[j - 1]][j - 1]) {
                            bestMoview[0] = moviesDurations[j - 1];
                            bestMoview[1] = dynTable[i - moviesDurations[j - 1]][j - 1];
                        } else {
                            bestMoview[1] = moviesDurations[j - 1];
                            bestMoview[0] = dynTable[i - moviesDurations[j - 1]][j - 1];
                        }

                    } else if (moviesDurations[j - 1] + dynTable[i - moviesDurations[j - 1]][j - 1] == bestMoview[0] + bestMoview[1]) {
                        if (moviesDurations[j - 1] > dynTable[i - moviesDurations[j - 1]][j - 1]) {
                            if (moviesDurations[j - 1] > bestMoview[0]) {
                                bestMoview[0] = moviesDurations[j - 1];
                                bestMoview[1] = dynTable[i - moviesDurations[j - 1]][j - 1];
                            }

                        } else {
                            if (dynTable[i - moviesDurations[j - 1]][j - 1] > bestMoview[0]) {
                                bestMoview[1] = moviesDurations[j - 1];
                                bestMoview[0] = dynTable[i - moviesDurations[j - 1]][j - 1];
                            }

                        }
                    }
                    if (dynTable[i][j - 1] < moviesDurations[j - 1]) {
                        dynTable[i][j] = moviesDurations[j - 1];
                    }

                } else {
                    dynTable[i][j] = dynTable[i][j - 1];
                }
            }
        }
        //
        return bestMoview;
    }

    public static void main(String[] args) {
        //int arr[] = {27, 1, 10, 39, 12, 52, 32, 67, 76};
        int arr[] = {35,40,45,50,55};
        int duration = 35;
        MoviewSelection ms = new MoviewSelection(arr, duration);
        int[] res = ms.getMoviewPair();
        System.out.println(res[0] + " " + res[1]);
    }

}
