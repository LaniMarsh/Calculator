import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */


    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                // TODO: Process each line of the input file here.
                String line = scan.nextLine();
                if (line.isEmpty()) {
                    continue; // Skip completely blank lines
                }
                String test  = line.strip(); // remove surrounding spaces
                String[] lines = test.split(" "); // split line at spaces
                String[] numbers = removeEmptyStrings(lines); // remove extra spaces in between numbers
                NodeList num1 = new NodeList();
                NodeList num2 = new NodeList();
                num1 = convert(numbers[0]);
                num2 = convert(numbers[2]);

                for (String l : numbers) {
                    System.out.print(removeZeros(l) + " ");
                }
                System.out.print("= " + operate(numbers[1], num1, num2) + "\n");

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }

    public static NodeList convert(String number){
        NodeList node = new NodeList();
        for(int i = 0; i < number.length(); i++){
            char c = number.charAt((number.length()-(i+1)));
            int num = (int) c - (int) '0'; // Convert char to numeric value
            node.append(num);
        }
        return node;
    }

    public static String[] removeEmptyStrings(String[] array) {
        int count = 0; // Count of non-empty strings
        for (String str : array) {
            if (!str.isEmpty()) {
                count++;
            }
        }
        String[] nonEmptyArray = new String[count];
        int index = 0;
        for (String str : array) {
            if (!str.isEmpty()) {
                nonEmptyArray[index] = str;
                index++;
            }
        }
        return nonEmptyArray;
    }

    public static String operate(String op, NodeList num1, NodeList num2){
        NodeList list = new NodeList();
        if (op.equals("+")){
            Maff compute = new Maff(num1.reverse(), num2.reverse());
            list = compute.add();
        }
        else if (op.equals("*")){
            Maff compute = new Maff(num1.reverse(), num2.reverse());
            list = compute.multiply();
        }
        return list.toString();
    }

    public static String removeZeros(String s){
        int firstNonZeroIndex = 0;
        while (firstNonZeroIndex < s.length() && s.charAt(firstNonZeroIndex) == '0') {
            firstNonZeroIndex++;
        }

        String result = s.substring(firstNonZeroIndex);
        if (result == ""){
            return "0";
        }
        return result;
    }
}
