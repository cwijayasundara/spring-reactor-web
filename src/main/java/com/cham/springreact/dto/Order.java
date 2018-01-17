package com.cham.springreact.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    private String orderId;
    private String customerName;
    private String customerAddress;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Order(@JsonProperty("orderId") String orderId, @JsonProperty("customerName") String customerName,
                 @JsonProperty("customerAddress") String customerAddress) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.customerAddress=customerAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }

}
