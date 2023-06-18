package com.fourtk.shoppingapi.dtos.requesties;

import com.fourtk.shoppingapi.entities.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
    @NotBlank
    private String productIdentifier;
    @NotNull
    private Double price;

    public static ItemRequest convert (Item item){
        ItemRequest request = new ItemRequest();
        request.setProductIdentifier(item.getProductIdentifier());
        request.setPrice(item.getPrice());
        return request;
    }
}