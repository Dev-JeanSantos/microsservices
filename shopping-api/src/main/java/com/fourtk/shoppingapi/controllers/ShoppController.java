package com.fourtk.shoppingapi.controllers;

import com.fourtk.shoppingapi.dtos.requesties.ShoppRequest;
import com.fourtk.shoppingapi.dtos.responses.ShoppReportResponse;
import com.fourtk.shoppingapi.dtos.responses.ShoppResponse;
import com.fourtk.shoppingapi.services.impl.ShoppReportService;
import com.fourtk.shoppingapi.services.impl.ShoppService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/shopps")
public class ShoppController {

    @Autowired
    private ShoppService service;
    @Autowired
    private ShoppReportService reportService;

    @PostMapping
    public ResponseEntity<ShoppRequest> save(@Valid @RequestBody ShoppRequest request) {
        request = service.save(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ShoppResponse>> getAll() {
        List<ShoppResponse> shoppings = service.getAllShopping();
        return ResponseEntity.ok().body(shoppings);
    }

    @GetMapping("/shoppingbyuser/{userIdentifier}")
    public ResponseEntity<List<ShoppResponse>> findByProductIdentifier(@PathVariable String userIdentifier) {
        List<ShoppResponse> response = service.getShoppingsByUser(userIdentifier);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/shoppingbydate")
    public ResponseEntity<List<ShoppResponse>> getShopps(@RequestBody ShoppRequest request) {
        List<ShoppResponse> responses = service.getByDate(request);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppResponse> getByCategoryId(@PathVariable Long id) {
        ShoppResponse productsByCategoryId = service.findById(id);
        return ResponseEntity.ok().body(productsByCategoryId);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ShoppResponse>> getShoppsByFilter(
            @RequestParam(name = "startDate", required = true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate startDate,
            @RequestParam(name = "endDate", required = false)
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate endDate,
            @RequestParam(name = "minimumValue", required = false)
            Double minimumValue) {
        List<ShoppResponse> shoopByFilters = reportService.getShoopByFilters(startDate, endDate, minimumValue);
        return ResponseEntity.ok().body(shoopByFilters);
    }

    @GetMapping("/reports")
    public ResponseEntity<ShoppReportResponse> getReportByDate(
            @RequestParam(name = "startDate", required = true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate startDate,
            @RequestParam(name = "endDate", required = true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate endDate) {
        ShoppReportResponse reportByDate = reportService.getReportByDate(startDate, endDate);
        return ResponseEntity.ok().body(reportByDate);
    }


}
