package com.fourtk.shoppingapi.repositories.impl;

import com.fourtk.shoppingapi.dtos.responses.ShoppReportResponse;
import com.fourtk.shoppingapi.entities.Shopp;
import com.fourtk.shoppingapi.repositories.ReportRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public class ReportRepositoryImpl implements ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Shopp> getShoppByFilters(LocalDate startDate, LocalDate endDate, Double minimumValue) {
        StringBuilder sb = new StringBuilder();
        sb.append("select s ");
        sb.append("from Shopp s ");
        sb.append("where s.date >= :startDate ");
        if (endDate != null) {
            sb.append("and s.date <= :endDate ");
        }
        if (minimumValue != null) {
            sb.append("and s.total <= :minimumValue ");
        }
        Query query = entityManager.createQuery((sb.toString()));
        query.setParameter("startDate", startDate);
        if (endDate != null) {
            query.setParameter("endDate", endDate);
        }
        if (minimumValue != null) {
            query.setParameter("minimumValue", minimumValue);
        }
        return query.getResultList();
    }

    @Override
    public ShoppReportResponse getReportByDate(LocalDate startDate, LocalDate endDate) {
        StringBuilder sb = new StringBuilder();
        sb.append("select count(s.id), sum(s.total), avg(s.total) ");
        sb.append("from Shopp s ");
        sb.append("where s.date >= :startDate ");
        sb.append("and s.date <= :endDate ");

        Query query = entityManager.createNativeQuery(sb.toString());
        query.setParameter("startDate", startDate.atTime(0,0));
        query.setParameter("endDate", endDate.atTime(23,59));

        Object[] result = (Object[]) query.getSingleResult();
        ShoppReportResponse shoppReportResponse = new ShoppReportResponse();
        shoppReportResponse.setCount(((BigInteger) result[0]).intValue());
        shoppReportResponse.setTotal((Double) result[1]);
        shoppReportResponse.setMean((Double) result[2]);

        return shoppReportResponse;
    }
}
