package com.visma.helper;

import com.visma.model.Transaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static com.visma.helper.TransactionUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class TransactionUtilsTest {

    private static final String CUSTOMER_1 = "Customer1";
    private static final String CUSTOMER_2 = "Customer2";
    private static final String ITEM_1 = "Item1";
    private static final String ITEM_2 = "Item2";
    private static final LocalDate DATE = LocalDate.of(2024, 1, 1);

    @Test
    void givenTransactionList_whenCalculateTotalRevenue_expectResultIsEqual() {
        List<Transaction> transactions = buildTransactionList();

        Double totalRevenue = calculateTotalRevenue(transactions);

        assertEquals(110, totalRevenue);
    }

    @Test
    void givenTransactionList_whenFindUniqueCustomerNumber_expectResultIsEqual() {
        List<Transaction> transactions = buildTransactionList();

        Integer result = findUniqueCustomerNumber(transactions);

        assertEquals(2, result);
    }

    @Test
    void givenTransactionList_whenFindMostPopularItem_expectResultIsEqual() {
        List<Transaction> transactions = buildTransactionList();

        String result = findMostPopularItem(transactions);

        assertEquals(ITEM_1, result);
    }

    @Test
    void givenTransactionList_whenFindDateWithHighestRevenue_expectResultIsEqual() {
        List<Transaction> transactions = buildTransactionList();

        LocalDate result = findDateWithHighestRevenue(transactions);

        assertEquals(DATE, result);
    }

    private static List<Transaction> buildTransactionList() {
        return Arrays.asList(
                Transaction.builder()
                        .itemId(ITEM_1)
                        .customerId(CUSTOMER_1)
                        .price(10d)
                        .quantity(10)
                        .transactionDate(DATE)
                        .build(),
                Transaction.builder()
                        .itemId(ITEM_1)
                        .customerId(CUSTOMER_2)
                        .price(1d)
                        .quantity(10)
                        .transactionDate(LocalDate.of(2024, 1, 2))
                        .build(),
                Transaction.builder()
                        .itemId(ITEM_2)
                        .customerId(CUSTOMER_1)
                        .price(0d)
                        .quantity(0)
                        .transactionDate(LocalDate.of(2024, 1, 3))
                        .build());
    }
}