package ru.netology.reader_writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ru.netology.Product;
import ru.netology.Products;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

public class ReaderWriterJSON implements MyReader, MyWriter {
    private final File file;

    public ReaderWriterJSON(String name) {
        this.file = new File(name);
    }

    @Override
    public Products read() {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        List<Product> productList = jsonToList(sb.toString());
        return new Products(productList);
    }

    private List<Product> jsonToList(String json) {
        Type listType = new TypeToken<List<Product>>(){}.getType();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.fromJson(json, listType);
    }

    @Override
    public void write(Products products) {
        String json = listToJson(products.getProducts());
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(json);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private String listToJson(List<Product> productList) {
        Type listType = new TypeToken<List<Product>>(){}.getType();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder
                .setPrettyPrinting()
                .create();
        return gson.toJson(productList, listType);
    }
}
