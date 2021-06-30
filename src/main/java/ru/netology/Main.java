package ru.netology;

import ru.netology.bill.Bill;
import ru.netology.bill.tax_type.TaxTypeRu;
import ru.netology.reader_writer.MyReader;
import ru.netology.reader_writer.ReaderCSV;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    private static final String NAME_FILE_CSV_LIKE_DB = "Products.csv";
    private static final Scanner scanner = new Scanner(System.in);
    private static Products productFromDB = null;
    private static Basket basket = new Basket();

    public static void main(String[] args) {
        MyReader reader = new ReaderCSV(NAME_FILE_CSV_LIKE_DB);
        productFromDB = reader.read();

        requestStartAction(productFromDB);
    }

    private static void requestStartAction(Products products) {
        while (true) {
            System.out.println("Product of our store:");
            System.out.println(products);
            System.out.println("1) Filter the list of products");
            System.out.println("2) Select products");
            System.out.println("3) Go to your basket");
            System.out.println("4) Exit");
            System.out.print("Enter 1-4: ");

            String answer = scanner.nextLine();

            switch (answer) {
                case "1":
                    products = requestFilter(products);
                    break;
                case "2":
                    requestSelectProduct(products);
                    break;
                case "3":
                    processingBasket();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("You need to enter 1-4");
            }
        }
    }

    private static void processingBasket() {
        while (true) {
            System.out.println("Product in your basket:");
            System.out.println(basket);
            System.out.println("1) Checkout");
            System.out.println("2) Remove products");
            System.out.println("3) Back");
            System.out.print("Enter 1-3: ");
            String answer = scanner.nextLine();
            switch (answer) {
                case "1":
                    Bill bill = new Bill(BigDecimal.valueOf(basket.getSumPrice()), new TaxTypeRu());
                    System.out.println(bill);
                    System.out.println("Send order");
                    scanner.nextLine();
                    return;
                case "2":
                    basket = new Basket();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("You need to enter 1-3");
            }
        }
    }

    private static void requestSelectProduct(Products products) {
        try {
            System.out.println("Select product and count to put in your basket(x y): ");
            String select = scanner.nextLine();

            String[] parts = select.split(" ");
            int numberOfProduct = Integer.parseInt(parts[0]) - 1;
            int countOfProduct = Integer.parseInt(parts[1]);

            basket.put(products.get(numberOfProduct), countOfProduct);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Products requestFilter(Products products) {
        while (true) {
            System.out.println(products);
            System.out.println("1) Filter by keyword in name");
            System.out.println("2) Filter by price");
            System.out.println("3) Filter by manufacturer");
            System.out.println("4) Clear all filters");
            System.out.println("5) Back");
            System.out.print("Select 1-5: ");
            String answer = scanner.nextLine();

            switch (answer) {
                case "1":
                    System.out.println("Enter keyword: ");
                    String keyword = scanner.nextLine();
                    products = products.filter(e -> e.getName().contains(keyword));
                    break;

                case "2":
                    System.out.print("Enter the lowest price: ");
                    double lowPrice = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter the highest price: ");
                    double highPrice = Double.parseDouble(scanner.nextLine());
                    products = products.filter(e -> (e.getPrice() >= lowPrice)
                            &&(e.getPrice() <= highPrice));
                    break;

                case "3":
                    System.out.print("Enter manufacturer: ");
                    String manufacturer = scanner.nextLine();
                    products = products.filter(e -> e.getManufacturer().equals(manufacturer));
                    break;

                case "4":
                    products = productFromDB;
                    break;

                case "5":
                    return products;

                default:
                    System.out.println("You need to enter 1-5");
            }
        }
    }
}
