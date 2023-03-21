package Solution_7;

import java.io.*;
import java.util.ArrayList;

//Tests a file which contains many numbers to describe a matrix is a magic square or not
public class MagicSquares {
    /*
        Gets the matrix line by line
        Gets the sum of one line when disposing current line
        Gets the sum of every column by using an ArrayList to store sum when disposing each line
        Gets the sum of leading diagonal and counter diagonal when disposing each line
        Tests if the sums above are equal or not
     */
    public static boolean testMagic(String pathName) throws IOException {
        //concatenate the file path
        pathName = (new File("")).getAbsolutePath() + "\\" + pathName;
        // Open the file using the concatenated absolute path
        BufferedReader reader = new BufferedReader(new FileReader(pathName));

        boolean isMagic = true;
        int lastSum = -1;
        int leadingDiagonalSum = 0;
        int counterDiagonalSum = 0;
        ArrayList<Integer> col = new ArrayList<Integer>();
        
        // For each line in the file ...
        String line;
        int rowNumber = 0;//records current line is ?th line
        while ((line = reader.readLine()) != null) {
            // ... sum each row of numbers
            String[] parts = line.split("\t");
            int sum = 0;

            for (int i = 0; i < parts.length; i++){
                //Avoids non-string circumstance
                if (parts[i].equals("")){
                    continue;
                }
                int cur = Integer.parseInt(parts[i]);
                sum += cur;
                //Condition that number in leading diagnonal
                if ( i == rowNumber){
                    leadingDiagonalSum += cur;
                }
                //Condition that number in counter diagnoal
                if (i + rowNumber == parts.length-1){
                    counterDiagonalSum += cur;
                }
                //Stores the temporary sum of each column
                if (rowNumber == 0){
                    col.add(i, cur);
                }else {
                    col.set(i, ((int)col.get(i)+cur)) ;
                }
            }

            if (lastSum == -1) {
                // If this is the first row, remember the sum
                lastSum = sum;
            } else if (lastSum != sum) {
                // If the sums don't match, it isn't magic, so stop reading
                isMagic = false;
                break;
            }
            //
            rowNumber++;
        }
        //Tests if the sums are equal
        if (isMagic == true && (lastSum != leadingDiagonalSum || lastSum != counterDiagonalSum)){
            isMagic = false;
        }
        for (Integer colSum : col){
            if (lastSum != colSum)
                isMagic = false;
        }

        reader.close();
        return isMagic;
    }

    public static void main(String[] args) throws IOException {
        String[] fileNames = { "Mercury.txt", "Luna.txt" };
        for (String fileName : fileNames) {
            System.out.println(fileName + " is magic? " + testMagic(fileName));
        }
    }
}
