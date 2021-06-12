package com.kuber.learn.jdbc;

public class OrderLine {
    private int OrderQuantity;
    private String ProductCode;
    private String ProductName;
    private int ProductSize;
    private String ProductVariety;
    private double ProductPrice;

    public OrderLine(int orderQuantity, String productCode, String productName, int productSize, String productVariety, double productPrice) {
        OrderQuantity = orderQuantity;
        ProductCode = productCode;
        ProductName = productName;
        ProductSize = productSize;
        ProductVariety = productVariety;
        ProductPrice = productPrice;
    }

    public int getOrderQuantity() {
        return OrderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        OrderQuantity = orderQuantity;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getProductSize() {
        return ProductSize;
    }

    public void setProductSize(int productSize) {
        ProductSize = productSize;
    }

    public String getProductVariety() {
        return ProductVariety;
    }

    public void setProductVariety(String productVariety) {
        ProductVariety = productVariety;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "OrderQuantity=" + OrderQuantity +
                ", ProductCode='" + ProductCode + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", ProductSize=" + ProductSize +
                ", ProductVariety='" + ProductVariety + '\'' +
                ", ProductPrice=" + ProductPrice +
                '}';
    }
}
