package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Телефон",15000);
        Product product2 = new Product(2, "Ноутбук",45000);
        Product product3 = new Product(3, "Книга",5000);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.remove(2);
        Product[] actual = shopRepository.findAll();
        Product[] expected = {product1, product3};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Телефон",15000);
        Product product2 = new Product(2, "Ноутбук",45000);
        Product product3 = new Product(3, "Книга",5000);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        Assertions.assertThrows(NotFoundException.class,
                ()-> shopRepository.remove(4)
        );
    }
    @Test
    public void testWhenProductsExist() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Телефон",15000);
        Product product2 = new Product(2, "Ноутбук",45000);
        Product product3 = new Product(3, "Книга",5000);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        Product[] actual = shopRepository.findAll();
        Product[] expected = {product1, product2, product3};

        assertArrayEquals(expected, actual);
    }


}