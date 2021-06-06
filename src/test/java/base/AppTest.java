package base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void output_includes_price_quantity_sub_tax_and_total() {
        App myApp = new App();
        int p1 = 25;
        int q1 = 2;
        int p2 = 10;
        int q2 = 1;
        int p3 = 4;
        int q3 = 1;
        double sub = (p1 * q1) + (p2 * q2) + (p3 * q3);
        String subt = String.format("%.2f", sub);
        double tax = (sub * (5.5 / 100));
        double total = sub + tax;
        String expectedOutput = """
                Subtotal: $64.00
                Tax: $3.52
                Total: $67.52""";
        String actualOutput = myApp.generateOutputString(subt, tax, total);

        assertEquals(expectedOutput, actualOutput);
    }
}