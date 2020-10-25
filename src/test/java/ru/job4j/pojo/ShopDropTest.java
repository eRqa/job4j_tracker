package ru.job4j.pojo;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ShopDropTest {

    @Test
    public void whenDropFirst() {
        Product[] products = new Product[2];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        Product[] rsl = ShopDrop.leftShift(products, 0);
        assertThat(rsl[0].getName(), is("Bread"));
        assertThat(rsl[1], is(nullValue()));
    }

    @Test
    public void whenDropLast() {
        Product[] products = new Product[2];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        Product[] rsl = ShopDrop.leftShift(products, 1);
        assertThat(rsl[0].getName(), is("Milk"));
        assertThat(rsl[1], is(nullValue()));
    }

    @Test
    public void whenDrop3() {
        Product[] products = new Product[7];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 4);
        products[3] = new Product("Tomato", 4);
        products[4] = new Product("Potato", 4);
        products[5] = new Product("Meat", 4);
        products[6] = new Product("Tea", 4);

        Product[] rsl = ShopDrop.leftShift(products, 3);

        assertThat(rsl[0].getName(), is("Milk"));
        assertThat(rsl[1].getName(), is("Bread"));
        assertThat(rsl[2].getName(), is("Egg"));
        assertThat(rsl[3].getName(), is("Potato"));
        assertThat(rsl[4].getName(), is("Meat"));
        assertThat(rsl[5].getName(), is("Tea"));
        assertThat(rsl[6], is(nullValue()));
    }
}