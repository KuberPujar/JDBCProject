package com.kuber.learn.jdbc;

import com.kuber.learn.jdbc.utils.OrderTransferObject;

import java.util.List;

public class Order implements OrderTransferObject {
    private String CustFirstName;
    private String CustLastName;
    private String CustEmail;
    private long orderId;
    private String OrderCreationDate;
    private double OrderTotalDue;
    private String OrderStatus;
    private String SalesFirstName;
    private String SalesLastName;
    private String SalesEmail;
    private List<OrderLine> orderLines;

    public Order(String custFirstName, String custLastName, String custEmail, long orderId, String orderCreationDate, double orderTotalDue, String orderStatus, String salesFirstName, String salesLastName, String salesEmail) {
        CustFirstName = custFirstName;
        CustLastName = custLastName;
        CustEmail = custEmail;
        this.orderId = orderId;
        OrderCreationDate = orderCreationDate;
        OrderTotalDue = orderTotalDue;
        OrderStatus = orderStatus;
        SalesFirstName = salesFirstName;
        SalesLastName = salesLastName;
        SalesEmail = salesEmail;
    }

    public String getCustFirstName() {
        return CustFirstName;
    }

    public String getCustLastName() {
        return CustLastName;
    }

    public String getCustEmail() {
        return CustEmail;
    }

    public long getOrderId() {
        return orderId;
    }

    public String getOrderCreationDate() {
        return OrderCreationDate;
    }

    public double getOrderTotalDue() {
        return OrderTotalDue;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public String getSalesFirstName() {
        return SalesFirstName;
    }

    public String getSalesLastName() {
        return SalesLastName;
    }

    public String getSalesEmail() {
        return SalesEmail;
    }

    @Override
    public long getId() {
        return this.orderId;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public String toString() {
        return "Order{" +
                "CustFirstName='" + CustFirstName + '\'' +
                ", CustLastName='" + CustLastName + '\'' +
                ", CustEmail='" + CustEmail + '\'' +
                ", orderId=" + orderId +
                ", OrderCreationDate='" + OrderCreationDate + '\'' +
                ", OrderTotalDue=" + OrderTotalDue +
                ", OrderStatus='" + OrderStatus + '\'' +
                ", SalesFirstName='" + SalesFirstName + '\'' +
                ", SalesLastName='" + SalesLastName + '\'' +
                ", SalesEmail='" + SalesEmail + '\'' +
                ", orderLines=" + orderLines +
                '}';
    }
}
