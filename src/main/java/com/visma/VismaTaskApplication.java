package com.visma;

import com.visma.helper.CSVFileReader;
import com.visma.model.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

import static com.visma.helper.TransactionUtils.*;

@SpringBootApplication
public class VismaTaskApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(VismaTaskApplication.class, args);

		List<Transaction> transactions = CSVFileReader.readCSVFile();

		System.out.println("========================================");
		System.out.println("Total Revenue is: " + calculateTotalRevenue(transactions));
		System.out.println("Unique customer number is: " + findUniqueCustomerNumber(transactions));
		System.out.println("Most popular item is: " + findMostPopularItem(transactions));
		System.out.println("Date with highest revenue: " + findDateWithHighestRevenue(transactions));
		System.out.println("========================================");
	}
}
