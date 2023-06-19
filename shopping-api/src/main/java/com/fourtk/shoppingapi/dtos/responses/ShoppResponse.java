package com.fourtk.shoppingapi.dtos.responses;

import com.fourtk.shoppingapi.dtos.requesties.ItemRequest;
import com.fourtk.shoppingapi.entities.Shopp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppResponse {

    private String userIdentifier;
    private double total;
    private LocalDate datePuchase;
    private List<ItemRequest> items;

    public static ShoppResponse convert(Shopp shopp) {
        ShoppResponse response = new ShoppResponse();
        response.setUserIdentifier(shopp.getUserIdentifier());
        response.setTotal(shopp.getTotal());
        response.setDatePuchase(shopp.getDate());
        response.setItems(shopp.getItems().stream().map(ItemRequest::convert).collect(Collectors.toList()));
        return response;
    }
}
