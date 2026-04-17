package hust.soict.hedspi.lab01;

import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String[] args) {
        boolean continueCalc = true;

        while (continueCalc) {
            // take input
            String strNum1 = JOptionPane.showInputDialog(
                    null,
                    "Please input the first number:\na = ",
                    "Input",
                    JOptionPane.INFORMATION_MESSAGE);

            String strNum2 = JOptionPane.showInputDialog(
                    null,
                    "Please input the second number:\nb = ",
                    "Input",
                    JOptionPane.INFORMATION_MESSAGE);

            double num1 = Double.parseDouble(strNum1);
            double num2 = Double.parseDouble(strNum2);

            // show menu and take mode input
            String instructions = "Choose an operation:\n" + "0. Show all operations\n" + "1. Sum (+): a + b\n" + "2. Difference (-): a - b\n" + "3. Product (*): a * b\n" + "4. Quotient (/): a / b";

            String mode = JOptionPane.showInputDialog(
                    null,
                    instructions,
                    "Select Mode",
                    JOptionPane.QUESTION_MESSAGE);

            // mode handling
            String resultText = "";

            switch (mode) {
                case "0": // show all
                    resultText += "a + b = " + (num1 + num2) + "\n";
                    resultText += "a - b = " + (num1 - num2) + "\n";
                    resultText += "a * b = " + (num1 * num2) + "\n";
                    if (num2 != 0) {
                        resultText += "a / b = " + (num1 / num2);
                    } else {
                        resultText += "Error! Cannot divide by zero.";
                    }
                    break;
                case "1": // sum
                    resultText = "a + b = " + (num1 + num2);
                    break;
                case "2": // diff
                    resultText = "a - b = " + (num1 - num2);
                    break;
                case "3": // product
                    resultText = "a * b = " + (num1 * num2);
                    break;
                case "4": // divide
                    if (num2 != 0) {
                        resultText = "a / b = " + (num1 / num2);
                    } else {
                        resultText = "Error! Cannot divide by zero.";
                    }
                    break;
                default: // error
                    resultText = "Please choose mode between 1 to 4!";
            }

            JOptionPane.showMessageDialog(
                    null,
                    resultText,
                    "Result",
                    JOptionPane.INFORMATION_MESSAGE);

            // continue?
            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Do you want to continue?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION);

            if (confirm != JOptionPane.YES_OPTION) {
                continueCalc = false;
            }
        }
        System.exit(0);
    }
}