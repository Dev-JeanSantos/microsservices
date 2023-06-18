package com.fourtk.shoppingapi.dtos.requesties;

import com.fourtk.shoppingapi.entities.Shopp;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppRequest {

    private Long id;
    @NotBlank
    private String userIdentifier;
    @NotNull
    private double total;

    private LocalDate datePuchase;

    private List<ItemRequest> items;

    public static ShoppRequest convert(Shopp shopp){
        System.out.println(shopp);
        ShoppRequest request = new ShoppRequest();
        request.setId(shopp.getId());
        request.setUserIdentifier(shopp.getUserIdentifier());
        request.setTotal(shopp.getTotal());
        request.setDatePuchase(shopp.getDatePuchase());
        request.setItems(shopp.getItems().stream().map(ItemRequest::convert).collect(Collectors.toList()));
        System.out.println(request);
        return request;
    }
}