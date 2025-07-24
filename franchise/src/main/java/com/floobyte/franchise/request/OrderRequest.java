package com.floobyte.franchise.request;

import com.floobyte.franchise.model.Address;
import lombok.Data;

@Data
public class OrderRequest {

    private Long resturantId;

    private Address deliveryAddress;

    public Long getResturantId() {
        return resturantId;
    }

    public void setResturantId(Long resturantId) {
        this.resturantId = resturantId;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
