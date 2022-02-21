package application;


import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String emailClient = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDateClient = sdf.parse(sc.nextLine());
		
		Client client = new Client(nameClient, emailClient, birthDateClient);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		
		Order order = new Order(new Date(), status, client);
		
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i=1 ; i<=n ; i++) {
			System.out.println("Enter #" + i + " item data:");
			
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			sc.nextLine();
			
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
			
			order.addItem(orderItem);
		}
		//printar momento em data e horario
		System.out.println("ORDER SUMMARY:");
		//printar status
		System.out.println(order);
		
		
		
		
		
		sc.close();
	}

}
