package BirthdayCalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BirthdayCalculator {
    public static void main(String[] args) {
        System.out.println("Welcome to the 100% Scientifically Accurate Birthday Calculator!");

        // Getting the birthday from the user.
        System.out.println("What's your birthday? (MM-DD-YYYY)");
        Scanner sc = new Scanner(System.in);
        String userBirthday = sc.nextLine();

        // Using try and catch to make sure I get the correct format of date.
        try {
            System.out.println("That means you were born on a " + calculateDay(userBirthday));
            System.out.println("This year it falls on a " + calculateThisYearDay(userBirthday));
            System.out.println("And since today is " + getTodayDate());
            System.out.println("There's only " + calculateRemaining(userBirthday) + " more days until the next one " +
                    "when you turn " + calculateAge(userBirthday));
        }
        catch (ParseException e) {
            System.out.println("Enter the birthday in a correct format! MM-DD-YYYY");
        }
    }

    public static String calculateDay(String bday) throws ParseException {
        // Changing string to a date format.
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE");

        // Parse and formatting the string using the simple date format created.
        Date birthdate = sdf.parse(bday);
        String birthday = sdf1.format(birthdate);

        // Return the day.
        return birthday.toUpperCase();
    }
    public static String calculateThisYearDay(String bday) throws ParseException{
        // Changing string to a date format with only month and a date.
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        Date birthdate = sdf.parse(bday);

        // Change to the string.
        String dayMonth = sdf.format(birthdate);

        // Changing object to the only year.
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");

        // Getting today's date.
        Date today = new Date();


        // Format the date and change to string.
        String year = sdf1.format(today);

        // Creating a new date with Birthday + This year.
        String thisYear = dayMonth + "-" + year;

        // Changing string to a format I want.
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
        SimpleDateFormat sdf3 = new SimpleDateFormat("EEEE");

        // Parse and formatting the string using the simple date format created.
        Date finalDate = sdf2.parse(thisYear);
        String finalDay = sdf3.format(finalDate);

        // Return the day.
        return finalDay.toUpperCase();
    }

    public static String getTodayDate() {
        // Changing object to the format I want.
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        // Getting today's date.
        Date d = new Date();

        // Format the date.
        String today = sdf.format(d);

        // Return the date.
        return today;
    }

    public static long  calculateRemaining(String bday) throws ParseException{
        // Changing string to date format with only the month and a date.
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        Date firstDate = sdf.parse(bday);

        // Getting today's date with only the month and a date.
        Date secondDate = sdf.parse(getTodayDate());

        // Getting the difference between two dates in a milliseconds.
        long diffInMillies = firstDate.getTime() - secondDate.getTime();

        // If the birthday is in a future return the first calculated day.
        // Else, return the calculated day + 365.
        if (diffInMillies > 0) {
            long res = (diffInMillies / (1000 * 60 * 60 * 24)) % 365;
            return res;
        } else {
            long res = (diffInMillies / (1000 * 60 * 60 * 24)) % 365 + 365;
            return res;
        }
    }

    public static int calculateAge(String bday) throws ParseException{
        // Changing string to date format.
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        // Changing date format to Calendar.
        Calendar dob = Calendar.getInstance();
        dob.setTime(sdf.parse(bday));

        // Getting today's date.
        Calendar today = Calendar.getInstance();

        // Getting only the year from the two dates.
        int thisYear = today.get(Calendar.YEAR);
        int dobYear = dob.get(Calendar.YEAR);

        // Calculating the age.
        int age = thisYear - dobYear;

        // Return age.
        return age;
    }
}
