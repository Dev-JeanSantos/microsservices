package com.fourtk.shoppingapi.services;

import com.fourtk.shoppingapi.dtos.requesties.ShoppRequest;
import com.fourtk.shoppingapi.dtos.responses.ShoppResponse;

import java.util.List;

public interface IShoppService {

    public ShoppRequest save(ShoppRequest request);

    public List<ShoppResponse> getAllShopping();

    public List<ShoppResponse> getShoppingsByUser(String userIdentify);

    public ShoppResponse findById(Long productId);

    List<ShoppResponse> getByDate(ShoppRequest request);
}
