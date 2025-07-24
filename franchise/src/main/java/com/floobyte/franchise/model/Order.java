package com.floobyte.franchise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //many orders by one customer.
    @ManyToOne
    private User customer;

//    one resturant have multiple orders.
//    whenever we fetch order details avoid resturant data.
    @JsonIgnore
    @ManyToOne
    private Resturant resturant;

    private Long totalAmmount;

    private String orderStatus;

    private Date createdAt;

    //many orders have one order.
    @ManyToOne
    private Address deliveryAddress;

//    private Payment payment;

    //Many items have one order.
    @OneToMany
    private List<OrderItem> items;

    private int totleItem;

    private Long totlePrice;

    // G S

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Resturant getResturant() {
        return resturant;
    }

    public void setResturant(Resturant resturant) {
        this.resturant = resturant;
    }

    public Long getTotalAmmount() {
        return totalAmmount;
    }

    public void setTotalAmmount(Long totalAmmount) {
        this.totalAmmount = totalAmmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public int getTotleItem() {
        return totleItem;
    }

    public void setTotleItem(int totleItem) {
        this.totleItem = totleItem;
    }

    public Long getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(Long totlePrice) {
        this.totlePrice = totlePrice;
    }
}
