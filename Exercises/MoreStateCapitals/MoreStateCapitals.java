package MoreStateCapitals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class MoreStateCapitals {
    public static void main(String[] args) throws  Exception {
        // Assigning the variable as text file path.
        final String FILENAME = "C:\\Users\\Alex D Jun\\IdeaProjects\\Main\\src\\MoreStateCapitals\\MoreStateCapitals.txt";

        // Assigning the variable as the delimiter in the text file.
        final String DELIMITER = "::";

        // Create a variable that will hold information about states.
        HashMap<String, ArrayList<String>> states = new HashMap<>();

        // Create a variable that will store the lines written on the text file.
        String line;

        // File reader.
        Scanner read = new Scanner(new BufferedReader(new FileReader(FILENAME)));

        while (read.hasNextLine()) {
            // Reading the line.
            line = read.nextLine();

            // Split string based on the delimiter into an array.
            String[] values = line.split(DELIMITER);

            // Divide array into its each value.
            String state = values[0];
            String capital = values[1];
            String population = values[2];
            String area = values[3];

            ArrayList<String> list = new ArrayList<>();
            list.add(capital);
            list.add(population);
            list.add(area);

            // Putting state as key and arraylist as value.
            states.put(state, list);
        }

        // Displaying.
        for (String i : states.keySet()) {
            // First Display key.
            System.out.print(i + " - ");

            // Display values for each key.
            System.out.println(states.get(i).get(0) + " | Pop: " + states.get(i).get(1) + " | Area: " +
                    states.get(i).get(2) + " sq mi");
        }

        System.out.print("\nPlease enter the lower limit for capital city population: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (String i : states.keySet()) {
            // Display the cities with higher population than user input.
            if (Integer.parseInt(states.get(i).get(1)) > num) {
                System.out.println("LISTING CAPITALS WITH POPULATIONS GREATER THAN " + num + " :");

                // First Display key.
                System.out.print(i + " - ");

                // Display values for each key.
                System.out.println(states.get(i).get(0) + " | Pop: " + states.get(i).get(1) + " | Area: " +
                        states.get(i).get(2) + " sq mi");
            }
        }

        System.out.print("\nPlease enter the upper limit for capital city sq mileage: ");
        float choice = sc.nextFloat();

        for (String i : states.keySet()) {
            // Display the cities with lower square foot than user input.
            if (Float.parseFloat(states.get(i).get(2)) < choice) {
                System.out.println("LISTING CAPITALS WITH AREAS LES THAN " + choice + " :");

                // First Display key.
                System.out.print(i + " - ");

                // Display values for each key.
                System.out.println(states.get(i).get(0) + " | Pop: " + states.get(i).get(1) + " | Area: " +
                        states.get(i).get(2) + " sq mi");
            }
        }
    }
}
