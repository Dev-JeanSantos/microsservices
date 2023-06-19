package com.fourtk.shoppingapi.services.impl;

import com.fourtk.shoppingapi.dtos.responses.ShoppReportResponse;
import com.fourtk.shoppingapi.dtos.responses.ShoppResponse;
import com.fourtk.shoppingapi.entities.Shopp;
import com.fourtk.shoppingapi.repositories.impl.ReportRepositoryImpl;
import com.fourtk.shoppingapi.services.IShoppReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppReportService implements IShoppReportService {

    @Autowired
    private ReportRepositoryImpl repository;

    @Override
    public List<ShoppResponse> getShoopByFilters(LocalDate startDate, LocalDate endDate, Double minimumValue) {
        List<Shopp> shopps = repository.getShoppByFilters(startDate, endDate, minimumValue);
        return shopps.stream().map(ShoppResponse::convert).collect(Collectors.toList());
    }

    @Override
    public ShoppReportResponse getReportByDate(LocalDate startDate, LocalDate endDate) {
        return repository.getReportByDate(startDate, endDate);
    }
}

