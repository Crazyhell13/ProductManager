package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private Book first = new Book(56, "Harry Potter", 500, "J.K.Rowling");
    private Book second = new Book(57, "Inside Apple", 600, "Adam Lashinsky");
    private Smartphone third = new Smartphone(105, "Huawei P30 light", 14000, "Huawei");
    private Smartphone fourth = new Smartphone(78,"Apple iPhone 13, 512 ГБ",110000, "Apple");
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    @Test
    public void searchEmptyResult() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchBySmartphoneManufacturer (){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        Product[] actual = manager.searchBy("Huawei");
        Product[] expected = new Product []{third};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchBySmartphoneName (){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        Product[] actual = manager.searchBy("iPhone");
        Product[] expected = new Product []{fourth};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchByBookName (){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        Product[] actual = manager.searchBy("Harry Potter");
        Product[] expected = new Product []{first};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchByBookAuthor (){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        Product[] actual = manager.searchBy("Adam");
        Product[] expected = new Product []{second};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void searchByMultipleResults (){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product []{second, fourth};
        assertArrayEquals(expected, actual);
    }

}