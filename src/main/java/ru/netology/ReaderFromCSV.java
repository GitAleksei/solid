package ru.netology;

import com.opencsv.bean.*;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class ReaderFromCSV {
    private final File file;

    public ReaderFromCSV(String name) {
        this.file = new File(name);
    }

    public Products read() {
        List<Product> productList = null;
        try (FileReader fileReader = new FileReader(file)) {
            productList = new CsvToBeanBuilder<Product>(fileReader)
                    .withType(Product.class)
                    .build().parse();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return new Products(productList);
    }
}
