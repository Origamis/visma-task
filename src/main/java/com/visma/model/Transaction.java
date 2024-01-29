package com.visma.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Transaction {

    @CsvBindByName(column = "transaction_id")
    private String transactionId;

    @CsvBindByName(column = "customer_id")
    private String customerId;

    @CsvBindByName(column = "item_id")
    private String itemId;

    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByName(column = "transaction_date")
    private Date transactionDate;

    @CsvBindByName(column = "item_price")
    private Double price;

    @CsvBindByName(column = "item_quantity")
    private Integer quantity;
}
