package com.fourtk.shoppingapi.repositories;

import com.fourtk.shoppingapi.dtos.responses.ShoppReportResponse;
import com.fourtk.shoppingapi.entities.Shopp;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReportRepository {
    public List<Shopp> getShoppByFilters(LocalDate startDate, LocalDate endDate, Double minimumValue);
    public ShoppReportResponse getReportByDate(LocalDate startDate, LocalDate endDate);
}
