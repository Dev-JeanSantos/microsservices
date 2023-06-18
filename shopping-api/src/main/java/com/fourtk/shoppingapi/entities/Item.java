package com.fourtk.shoppingapi.entities;

import com.fourtk.shoppingapi.dtos.requesties.ItemRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Item {

    @Column(nullable = false)
    private String productIdentifier;
    @Column(nullable = false)
    private Double price;

    public static Item convert(ItemRequest request){
        Item item = new Item();
        item.setProductIdentifier(request.getProductIdentifier());
        item.setPrice(request.getPrice());
        return item;
    }
}
