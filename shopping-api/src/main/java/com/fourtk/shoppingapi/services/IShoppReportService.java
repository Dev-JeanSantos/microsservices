package com.fourtk.shoppingapi.services;

import com.fourtk.shoppingapi.dtos.responses.ShoppReportResponse;
import com.fourtk.shoppingapi.dtos.responses.ShoppResponse;

import java.time.LocalDate;
import java.util.List;

public interface IShoppReportService {

    public List<ShoppResponse> getShoopByFilters(LocalDate startDate, LocalDate endDate, Double minimumValue);

    public ShoppReportResponse getReportByDate(LocalDate startDate, LocalDate endDate);

}
