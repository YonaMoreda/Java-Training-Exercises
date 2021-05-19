package com.company;

import com.company.model.CashRegister;
import com.company.model.ShoppingCart;
import com.company.model.products.Soap;

public class Main {

    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister();

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(new Soap());

        cashRegister.checkout(shoppingCart, 10);

    }
}
