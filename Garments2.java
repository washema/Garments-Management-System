
package com.mycompany.garments2;








import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Garment {
    private String name;
    private String size;
    private String color;
    private int quantity;
    private double price;

    public Garment(String name, String size, String color, int quantity, double price) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return name + " (" + size + ", " + color + ") - Quantity: " + quantity + ", Price: $" + price;
    }
}

class Order {
    private List<Garment> garments;
    private double totalPrice;

    public Order() {
        garments = new ArrayList<>();
        totalPrice = 0.0;
    }

    public void addGarment(Garment garment, int quantity) {
        if (quantity <= garment.getQuantity()) {
            garments.add(garment);
            totalPrice += garment.getPrice() * quantity;
            garment.setQuantity(garment.getQuantity() - quantity);
        } else {
            System.out.println("Not enough stock for " + garment.getName());
        }
    }

    public void viewOrder() {
        System.out.println("Order Details:");
        for (Garment g : garments) {
            System.out.println(g);
        }
        System.out.println("Total Price: $" + totalPrice);
    }
}

class Inventory {
    private List<Garment> garments;

    public Inventory() {
        garments = new ArrayList<>();
    }

    public void addGarment(Garment garment) {
        garments.add(garment);
    }

    public void removeGarment(String name) {
        garments.removeIf(g -> g.getName().equalsIgnoreCase(name));
    }

    public void viewGarments() {
        System.out.println("Available Garments:");
        for (Garment g : garments) {
            System.out.println(g);
        }
    }

    public Garment findGarment(String name) {
        for (Garment g : garments) {
            if (g.getName().equalsIgnoreCase(name)) {
                return g;
            }
        }
        return null;
    }
}

public class Garments2 {
    private static Inventory inventory = new Inventory();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Garment Management System");
            System.out.println("1. Add Garment");
            System.out.println("2. Remove Garment");
            System.out.println("3. View Garments");
            System.out.println("4. Create Order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter garment name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter size: ");
                    String size = scanner.nextLine();
                    System.out.print("Enter color: ");
                    String color = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    inventory.addGarment(new Garment(name, size, color, quantity, price));
                    break;
                case 2:
                    System.out.print("Enter garment name to remove: ");
                    String garmentName = scanner.nextLine();
                    inventory.removeGarment(garmentName);
                    break;
                case 3:
                    inventory.viewGarments();
                    break;
                case 4:
                    Order order = new Order();
                    System.out.print("Enter garment name to order: ");
                    String orderName = scanner.nextLine();
                    Garment garment = inventory.findGarment(orderName);
                    if (garment != null) {
                        System.out.print("Enter quantity: ");
                        int orderQuantity = scanner.nextInt();
                        order.addGarment(garment, orderQuantity);
                    } else {
                        System.out.println("Garment not found.");
                    }
                    order.viewOrder();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}