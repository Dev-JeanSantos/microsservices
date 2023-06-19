package com.fourtk.shoppingapi.services.impl;

import com.fourtk.shoppingapi.dtos.requesties.ShoppRequest;
import com.fourtk.shoppingapi.dtos.responses.ShoppResponse;
import com.fourtk.shoppingapi.entities.Shopp;
import com.fourtk.shoppingapi.repositories.ShoppRepository;
import com.fourtk.shoppingapi.services.IShoppService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppService implements IShoppService {

    @Autowired
    private ShoppRepository repository;

    @Override
    public ShoppRequest save(ShoppRequest request) {
        request.setTotal(request.getItems().stream().map(x -> x.getPrice()).reduce((Double) 0.0, Double::sum));
        Shopp shopp = Shopp.convertRequest(request);
        shopp.setDate(LocalDate.now());
        shopp = repository.save(shopp);
        return ShoppRequest.convert(shopp);
    }

    @Override
    public List<ShoppResponse> getAllShopping() {
        List<Shopp> lists = repository.findAll();
        return lists.stream().map(ShoppResponse::convert).collect(Collectors.toList());
    }

    @Override
    public List<ShoppResponse> getShoppingsByUser(String userIdentify) {
        List<Shopp> shops = repository.findAllByUserIdentifier(userIdentify);
        return shops.stream().map(ShoppResponse::convert).collect(Collectors.toList());
    }
    @Override
    public List<ShoppResponse> getByDate(ShoppRequest request) {
        return null;
//        List<Shopp> shopps = repository.findAllByDatePuchaseGreaterThanEquals(request.getDatePuchase());
//        return shopps.stream().map(ShoppResponse::convert).collect(Collectors.toList());
    }

    @Override
    public ShoppResponse findById(Long productId) {
        Optional<Shopp> shopp = repository.findById(productId);
        shopp.orElseThrow(() -> new EntityNotFoundException());
        return ShoppResponse.convert(shopp.get());
    }

}

