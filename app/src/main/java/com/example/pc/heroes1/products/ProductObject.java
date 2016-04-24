package com.example.pc.heroes1.products;

/**
 * Created by pc on 4/24/2016.
 */
public class ProductObject {

    private String product_name;
    private String product_price;
    private String product_details;

    public ProductObject() {
    }

    public ProductObject(String product_name, String product_price,String product_details ) {
        this.product_name = product_name;
        this.product_price= product_price;
        this.product_details = product_details;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public String getProduct_details() {
        return product_details;
    }
}
