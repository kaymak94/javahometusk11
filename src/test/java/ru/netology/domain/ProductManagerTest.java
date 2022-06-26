package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;
import ru.netology.managers.ProductManager;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Crime and Punishment", 345, "Dostoevsky");
    Product product2 = new Smartphone(2, "Galaxy", 24567, "Samsung");
    Product product3 = new Book(3, "For whom the Bell Tolls", 567, "Hemingway");
    Product product4 = new Smartphone(4, "Iphone", 45897, "Apple");

    @Test
    public void saveAddAllProductTest() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3, product4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdTest() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.removeById(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3, product4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTest() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        Product[] actual= manager.searchBy("For whom the");
        Product[] expected = {product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesTrueTest() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        boolean actual = manager.matches(product4, "Iphone");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void matchesFalseTest() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        boolean actual = manager.matches(product2, "Iphone");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }
}
