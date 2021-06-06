/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Jamar Jackson
 */

package base;

import java.util.Scanner;

/*
Exercise 10 - Self-Checkout

        Working with multiple inputs and currency can introduce some tricky precision issues.

        Create a simple self-checkout system. Prompt for the prices and quantities of three items. Calculate the subtotal of the items. Then calculate the tax using a tax rate of 5.5%. Print out the line items with the quantity and total, and then print out the subtotal, tax amount, and total.
        Example Output

        Enter the price of item 1: 25
        Enter the quantity of item 1: 2
        Enter the price of item 2: 10
        Enter the quantity of item 2: 1
        Enter the price of item 3: 4
        Enter the quantity of item 3: 1
        Subtotal: $64.00
        Tax: $3.52
        Total: $67.52

        Constraints

        Keep the input, processing, and output parts of your program separate. Collect the input, then do the math operations and string building, and then print out the output.
        Be sure you explicitly convert input to numerical data before doing any calculations.

        Challenges

        Revise the program to ensure that prices and quantities are entered as numeric values. Don’t allow the user to proceed if the value entered is not numeric.
        Alter the program so that an indeterminate number of items can be entered. The tax and total are computed when there are no more items to be entered.
*/
public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        int p1 = myApp.price1();
        int q1 = myApp.quantity1();
        int p2 = myApp.price2();
        int q2 = myApp.quantity2();
        int p3 = myApp.price3();
        int q3 = myApp.quantity3();
        double sub = myApp.subtotal(p1, q1, p2, q2, p3, q3);
        String subt = myApp.stringSub(sub);
        double tax = myApp.totalTax(sub);
        double total = myApp.totalPrice(sub, tax);
        String outputString = myApp.generateOutputString(subt, tax, total);
        myApp.printOutput(outputString);
    }

    public void printOutput(String outputString) {
        System.out.println(outputString);
    }

    public int price1() {
        System.out.println("Enter the price of item 1: ");
        return in.nextInt();
    }

    public int quantity1() {
        System.out.println("Enter the quantity of item 1: ");
        return in.nextInt();
    }

    public int price2() {
        System.out.println("Enter the price of item 2: ");
        return in.nextInt();
    }

    public int quantity2() {
        System.out.println("Enter the quantity of item 2: ");
        return in.nextInt();
    }

    public int price3() {
        System.out.println("Enter the price of item 3: ");
        return in.nextInt();
    }

    public int quantity3() {
        System.out.println("Enter the quantity of item 3: ");
        return in.nextInt();
    }

    public double subtotal(int p1, int q1, int p2, int q2, int p3, int q3) {
        return (p1 * q1) + (p2 * q2) + (p3 * q3);
    }

    public String stringSub(double sub) {
        return String.format("%.2f", sub);
    }

    public double totalTax(double sub) {
        return (sub * (5.5 / 100));
    }

    public double totalPrice(double sub, double tax) {
        return sub + tax;
    }

    public String generateOutputString(String subt, double tax, double total) {
        return "Subtotal: $" + subt + "\n" +
                "Tax: $" + tax + "\n" +
                "Total: $" + total;
    }
}
