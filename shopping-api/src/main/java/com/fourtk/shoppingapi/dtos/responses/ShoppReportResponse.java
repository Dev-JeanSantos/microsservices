package com.fourtk.shoppingapi.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppReportResponse {

    private Integer count;
    private Double total;
    private Double mean;

}
