package com.visma.helper;

import com.opencsv.bean.CsvToBeanBuilder;
import com.visma.model.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public final class CSVFileReader {

    private final static String CSV_FILE_LOCATION = "csv/transactions.csv";

    private CSVFileReader() {
    }

    public static List<Transaction> readCSVFile() throws IOException {
        String csvFileLocation = ClassLoader.getSystemResource(CSV_FILE_LOCATION).getFile();
        Reader reader = new BufferedReader(new FileReader(csvFileLocation));

        return new CsvToBeanBuilder(reader)
                .withType(Transaction.class)
                .build()
                .parse();
    }
}
