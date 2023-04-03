package ru.neology.exeptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {

    @Test
    public void deleteProductWithExistID() {
        ShopRepository repository = new ShopRepository();

        Product product1 = new Product(1, "Еда", 1_000);
        Product product2 = new Product(2, "Бытовая химия", 2_000);
        Product product3 = new Product(3, "Бакалея", 500);
        Product product4 = new Product(4, "Фрукты", 3_000);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.remove(3);

        Product[] expected = {product1, product2, product4};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void deleteProductWithoutExistID() {
        ShopRepository repository = new ShopRepository();

        Product product1 = new Product(1, "Еда", 1_000);
        Product product2 = new Product(2, "Бытовая химия", 2_000);
        Product product3 = new Product(3, "Бакалея", 500);
        Product product4 = new Product(4, "Фрукты", 3_000);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);

        Assertions.assertThrows(NotFoundException.class, () -> repository.remove(5));

    }

}