package com.goat.A.A04.item05;

/**
 * Created by 64274 on 2019/8/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/8/5---9:33
 */
public class ConcreteBuilder2 extends Builder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("部件X");
    }

    @Override
    public void buildPartB() {
        product.add("部件Y");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

