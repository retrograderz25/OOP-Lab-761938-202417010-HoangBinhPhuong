import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            int month = -1;
            int year = -1;

            while (true) {
                System.out.print("\nEnter month: ");
                String strMonth = keyboard.nextLine();

                System.out.print("Enter year: ");
                String strYear = keyboard.nextLine();

                month = parseMonth(strMonth);
                year = parseYear(strYear);

                if (month != -1 && year != -1) {
                    break;
                } else {
                    System.out.println("Invalid month/year. Please try again!");
                }
            }

            int days = getDaysInMonth(month, year);
            System.out.println("Number of days: " + days);

            System.out.print("Do you want to check another month? (yes/no): ");
            String answer = keyboard.nextLine().trim().toLowerCase();
            if (!answer.equals("yes") && !answer.equals("y")) {
                continueProgram = false;
            }
        }
        System.out.println("Bye bye.");
        keyboard.close();
    }

    private static int parseMonth(String input) {
        if (input == null) return -1;
        input = input.trim().toLowerCase();

        switch (input) {
            case "january": case "jan.": case "jan": case "1": return 1;
            case "february": case "feb.": case "feb": case "2": return 2;
            case "march": case "mar.": case "mar": case "3": return 3;
            case "april": case "apr.": case "apr": case "4": return 4;
            case "may": case "5": return 5;
            case "june": case "jun.": case "jun": case "6": return 6;
            case "july": case "jul.": case "jul": case "7": return 7;
            case "august": case "aug.": case "aug": case "8": return 8;
            case "september": case "sept.": case "sep": case "9": return 9;
            case "october": case "oct.": case "oct": case "10": return 10;
            case "november": case "nov.": case "nov": case "11": return 11;
            case "december": case "dec.": case "dec": case "12": return 12;
            default: return -1;
        }
    }

    private static int parseYear(String input) {
        try {
            int y = Integer.parseInt(input);
            return (y >= 0) ? y : -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 31;
        }
    }
}