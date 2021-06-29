package ru.netology.reader;

import com.opencsv.bean.*;
import ru.netology.Product;
import ru.netology.Products;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class ReaderFromCSV implements MyReader {
    private final File file;

    public ReaderFromCSV(String name) {
        this.file = new File(name);
    }

    @Override
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
