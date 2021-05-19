package com.company.model;

import com.company.model.products.Product;

public class CashRegister {

    private static final String EUROS = " euros";

    public void checkout(ShoppingCart shoppingCart, double moneyPaid) {
        System.out.println("Now checking out.");

        double sumTotal = 0;
        for (Product product : shoppingCart.getProducts()) {
            sumTotal += product.getPrice();
        }

        double discountAmount = 0;
        if (sumTotal > 10) {
            discountAmount = 0.5;
        }
        if (sumTotal > 20) {
            discountAmount = 1;
        }

        double finalAmount = (sumTotal - discountAmount);
        System.out.println("Amount to be paid: " + sumTotal + EUROS);
        System.out.println("Discount amount: " + discountAmount + EUROS);
        System.out.println("Total amount: " + finalAmount + EUROS);
        System.out.println("Change amount: " + (moneyPaid - finalAmount) + EUROS);
    }
}
