import java.util.Scanner;

public class TaxCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double salaryIncome = 0;
        double businessIncome = 0;
        double propertyIncome = 0;
        double otherIncome = 0;

        int choice;

        System.out.println("==================================");
        System.out.println("      THAI TAX CALCULATOR");
        System.out.println("==================================");

        do {

            System.out.println("\nSelect income type");
            System.out.println("1. Salary Income");
            System.out.println("2. Business Income");
            System.out.println("3. Property Income");
            System.out.println("4. Other Income");
            System.out.println("5. Calculate Tax and Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter yearly salary income: ");
                    salaryIncome += sc.nextDouble();
                    break;

                case 2:
                    System.out.print("Enter yearly business income: ");
                    businessIncome += sc.nextDouble();
                    break;

                case 3:
                    System.out.print("Enter yearly property income: ");
                    propertyIncome += sc.nextDouble();
                    break;

                case 4:
                    System.out.print("Enter yearly other income: ");
                    otherIncome += sc.nextDouble();
                    break;

                case 5:
                    System.out.println("\nCalculating tax...");
                    break;

                default:
                    System.out.println("Please select between 1 - 5");
            }

        } while (choice != 5);

        // Total income
        double totalIncome =
                salaryIncome +
                businessIncome +
                propertyIncome +
                otherIncome;

        // Deduction
        double deduction = 60000;

        // Net income
        double netIncome = totalIncome - deduction;

        if (netIncome < 0) {
            netIncome = 0;
        }

        // Show formula
        System.out.println("\n==================================");
        System.out.println("         TAX FORMULA");
        System.out.println("==================================");

        System.out.println("Net Income = Total Income - Deduction");
        System.out.println(
                "Net Income = "
                        + totalIncome
                        + " - "
                        + deduction
                        + " = "
                        + netIncome
        );

        System.out.println("\nTax Brackets:");
        System.out.println("0 - 150,000          = 0%");
        System.out.println("150,001 - 300,000    = 5%");
        System.out.println("300,001 - 500,000    = 10%");
        System.out.println("500,001 - 750,000    = 15%");
        System.out.println("750,001 - 1,000,000  = 20%");
        System.out.println("Over 1,000,000       = 25%");

        // Calculate tax
        double tax = calculateTax(netIncome);

        // Summary
        System.out.println("\n==================================");
        System.out.println("            SUMMARY");
        System.out.println("==================================");

        System.out.println("Salary Income      : " + salaryIncome + " THB");
        System.out.println("Business Income    : " + businessIncome + " THB");
        System.out.println("Property Income    : " + propertyIncome + " THB");
        System.out.println("Other Income       : " + otherIncome + " THB");

        System.out.println("----------------------------------");
        System.out.println("Total Income       : " + totalIncome + " THB");
        System.out.println("Deduction          : " + deduction + " THB");
        System.out.println("Net Income         : " + netIncome + " THB");
        System.out.println("----------------------------------");
        System.out.println("Tax to Pay         : " + tax + " THB");
        System.out.println("==================================");

        sc.close();
    }

    // Progressive tax calculation with formula display
    public static double calculateTax(double income) {

        double tax = 0;

        System.out.println("\n==================================");
        System.out.println("       TAX CALCULATION");
        System.out.println("==================================");

        if (income <= 150000) {

            tax = 0;

            System.out.println("Income within tax-free bracket");
            System.out.println("Tax = 0");

        }

        else if (income <= 300000) {

            tax = (income - 150000) * 0.05;

            System.out.println(
                    "Tax = (" + income + " - 150000) x 5%"
            );

        }

        else if (income <= 500000) {

            double firstPart = 150000 * 0.05;
            double secondPart = (income - 300000) * 0.10;

            tax = firstPart + secondPart;

            System.out.println(
                    "Tax = (150000 x 5%) + ("
                            + income
                            + " - 300000) x 10%"
            );

        }

        else if (income <= 750000) {

            double firstPart = 150000 * 0.05;
            double secondPart = 200000 * 0.10;
            double thirdPart = (income - 500000) * 0.15;

            tax = firstPart + secondPart + thirdPart;

            System.out.println(
                    "Tax = (150000 x 5%) + (200000 x 10%) + ("
                            + income
                            + " - 500000) x 15%"
            );

        }

        else if (income <= 1000000) {

            double firstPart = 150000 * 0.05;
            double secondPart = 200000 * 0.10;
            double thirdPart = 250000 * 0.15;
            double fourthPart = (income - 750000) * 0.20;

            tax = firstPart + secondPart + thirdPart + fourthPart;

            System.out.println(
                    "Tax = (150000 x 5%) + (200000 x 10%) + "
                            + "(250000 x 15%) + ("
                            + income
                            + " - 750000) x 20%"
            );

        }

        else {

            double firstPart = 150000 * 0.05;
            double secondPart = 200000 * 0.10;
            double thirdPart = 250000 * 0.15;
            double fourthPart = 250000 * 0.20;
            double fifthPart = (income - 1000000) * 0.25;

            tax = firstPart
                    + secondPart
                    + thirdPart
                    + fourthPart
                    + fifthPart;

            System.out.println(
                    "Tax = (150000 x 5%) + (200000 x 10%) + "
                            + "(250000 x 15%) + (250000 x 20%) + ("
                            + income
                            + " - 1000000) x 25%"
            );
        }

        return tax;
    }
}