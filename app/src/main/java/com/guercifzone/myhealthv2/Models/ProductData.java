package com.guercifzone.myhealthv2.Models;

public class ProductData {
    private String product_name;
    private String barcode;
    private String ingredients_text;
    private String image_url;

    public ProductData(String product_name, String barcode, String ingredients_text, String image_url) {
        this.product_name = product_name;
        this.barcode = barcode;
        this.ingredients_text = ingredients_text;
        this.image_url = image_url;
    }

    public ProductData() {
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getIngredients_text() {
        return ingredients_text;
    }

    public void setIngredients_text(String ingredients_text) {
        this.ingredients_text = ingredients_text;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
