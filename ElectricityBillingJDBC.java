import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ElectricityBillingJDBC {

    // Change these according to your MySQL setup
    private static final String DB_URL = "jdbc:mysql://localhost:3306/electricity_db";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "password";

    // Bill calculation logic
    public static double calculateBill(int units) {
        double amount;
        if (units <= 100) {
            amount = units * 1.5;
        } else if (units <= 300) {
            amount = (100 * 1.5) + (units - 100) * 2.5;
        } else {
            amount = (100 * 1.5) + (200 * 2.5) + (units - 300) * 4.0;
        }
        return amount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Consumer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Consumer ID: ");
        int consumerId = sc.nextInt();

        System.out.print("Enter Units Consumed: ");
        int units = sc.nextInt();

        double billAmount = calculateBill(units);

        try {
            // Create connection
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            // SQL query
            String query = "INSERT INTO bills (consumer_id, consumer_name, units, amount) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, consumerId);
            ps.setString(2, name);
            ps.setInt(3, units);
            ps.setDouble(4, billAmount);

            ps.executeUpdate();

            System.out.println("\n--- Electricity Bill ---");
            System.out.println("Consumer Name : " + name);
            System.out.println("Consumer ID   : " + consumerId);
            System.out.println("Units Used    : " + units);
            System.out.println("Total Amount  : ₹" + billAmount);
            System.out.println("Bill stored successfully in database.");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
