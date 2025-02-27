package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <Product> product = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int numberProduct = sc.nextInt();
		
		for(int i=1; i<=numberProduct; i++) {
			sc.nextLine();
			System.out.println("Product #"+i+" data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			//se o produto for importado
			if (ch=='i') {
				System.out.print("Customs fee: ");
				Double fee = sc.nextDouble();
				product.add(new ImportedProduct (name, price, fee));
			}
			//se o produto for usado
			if (ch=='u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				product.add(new UsedProduct (name, price, date));
			}
			if (ch=='c') {
				//se o produto for comum
				product.add(new Product (name, price));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS");
		for (Product prod: product) {
			System.out.println(prod.priceTag());
		}
		
		
		sc.close();
	}

}
