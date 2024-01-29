package com.visma.helper;

import com.visma.model.Transaction;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class TransactionUtils {

    private TransactionUtils() {
    }

    public static Double calculateTotalRevenue(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getPrice() * transaction.getQuantity())
                .reduce(0d, Double::sum);
    }

    public static Integer findUniqueCustomerNumber(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCustomerId))
                .keySet().size();
    }

    public static String findMostPopularItem(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getItemId))
                .entrySet().stream()
                .max(Comparator.comparing(entry -> entry.getValue().size()))
                .get().getKey();
    }

    public static LocalDate findDateWithHighestRevenue(List<Transaction> transactions) {
        return transactions.stream()
                .max(Comparator.comparing(transaction -> transaction.getPrice() * transaction.getQuantity()))
                .get().getTransactionDate();
    }
}
