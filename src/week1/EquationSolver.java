import javax.swing.JOptionPane;

public class EquationSolver {
    public static void main(String[] args) {
        boolean continueSolving = true;

        while (continueSolving) {
            String menu = "Select equation type to solve:\n" +
                    "1. First-degree equation with one variable (ax + b = 0)\n" +
                    "2. System of first-degree equations with two variables\n" +
                    "3. Second-degree equation with one variable (ax^2 + bx + c = 0)";

            String choice = JOptionPane.showInputDialog(null, menu, "Equation Solver", JOptionPane.QUESTION_MESSAGE);

            switch (choice) {
                case "1":
                    solveLinearEquation();
                    break;
                case "2":
                    solveSystemEquations();
                    break;
                case "3":
                    solveQuadraticEquation();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please choose between 1 to 3!");
            }

            int confirm = JOptionPane.showConfirmDialog(null, "Do you want to solve another equation?", "Continue?", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) continueSolving = false;
        }
        System.exit(0);
    }

    // linear equation: ax + b = 0
    private static void solveLinearEquation() {
        String info = "Solving: ax + b = 0";
        String title = "Solving Linear System";
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, info + "\nEnter a:", title, JOptionPane.QUESTION_MESSAGE));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, info + "\nEnter b:", title, JOptionPane.QUESTION_MESSAGE));

        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "The system has infinitely many solutions.",
                        title,
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "The equation has no solution.",
                        title,
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(
                    null,
                    "Solution: x = " + x,
                    title,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /* linear system:
     * a11*x1 + a12*x2 = b1
     * a21*x1 + a22*x2 = b2
     */
    private static void solveSystemEquations() {
        String info = "Solving: a11*x1 + a12*x2 = b1 && a21*x1 + a22*x2 = b2";
        String title = "Solving Linear System";
        double a11 = Double.parseDouble(JOptionPane.showInputDialog(null, info + "\nEnter a11:", title, JOptionPane.QUESTION_MESSAGE));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog(null, info + "\nEnter a12:", title, JOptionPane.QUESTION_MESSAGE));
        double b1  = Double.parseDouble(JOptionPane.showInputDialog(null, info + "\nEnter b1:", title, JOptionPane.QUESTION_MESSAGE));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog(null, info + "\nEnter a21:", title, JOptionPane.QUESTION_MESSAGE));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog(null, info + "\nEnter a22:", title, JOptionPane.QUESTION_MESSAGE));
        double b2  = Double.parseDouble(JOptionPane.showInputDialog(null, info + "\nEnter b2:", title, JOptionPane.QUESTION_MESSAGE));

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            JOptionPane.showMessageDialog(
                    null,
                    "Solution: x1 = " + x1 + ", x2 = " + x2,
                    title,
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (D1 == 0 && D2 == 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "The system has infinitely many solutions.",
                        title,
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "The system has no solution.",
                        title,
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    // quadratic equation: a*x^2 + b*x + c = 0
    private static void solveQuadraticEquation() {
        String info = "Solving: a*x^2 + b*x + c = 0";
        String title = "Solving Quadratic Equation";
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, info + "\nEnter a:", title, JOptionPane.QUESTION_MESSAGE));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, info + "\nEnter b:", title, JOptionPane.QUESTION_MESSAGE));
        double c = Double.parseDouble(JOptionPane.showInputDialog(null, info + "\nEnter c:", title, JOptionPane.QUESTION_MESSAGE));

        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(
                        null,
                        (c == 0) ? "Infinitely many solutions." : "No solution.",
                        title,
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "The equation becomes linear: x = " + (-c / b),
                        title,
                        JOptionPane.INFORMATION_MESSAGE);
            }
            return;
        }

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            JOptionPane.showMessageDialog(
                    null,
                    "Two distinct roots:\nx1 = " + x1 + "\nx2 = " + x2,
                    title,
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            JOptionPane.showMessageDialog(
                    null,
                    "Double root: x1 = x2 = " + x,
                    title,
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "The equation has no real roots.",
                    title,
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}