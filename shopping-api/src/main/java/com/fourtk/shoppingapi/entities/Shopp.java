package com.fourtk.shoppingapi.entities;

import com.fourtk.shoppingapi.dtos.requesties.ShoppRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Shopp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    @Column(nullable = false)
    private String userIdentifier;
    @Column(nullable = false)
    private double total;
    @Column(nullable = false)
    private LocalDate date;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item", joinColumns = @JoinColumn(name = "shop_id"))
    private List<Item> items;

    public static Shopp convertRequest(ShoppRequest request) {
        Shopp shopp = new Shopp();
        shopp.setId(request.getId());
        shopp.setUserIdentifier(request.getUserIdentifier());
        shopp.setTotal(request.getTotal());
        shopp.setDate(request.getDatePuchase());
        shopp.setItems(request.getItems().stream().map(Item::convert).collect(Collectors.toList()));
        return shopp;
    }
}
