package com.shaverma.rest.controller;

import com.chaverma.api.ApiResponse;
import com.chaverma.dto.OrderDTO;
import com.chaverma.response.ResponseHandler;
import com.shaverma.rest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("telegram/{telegramId}")
    public ResponseEntity<ApiResponse<Long>> addOrderFromTelegram(@RequestBody OrderDTO orderDTO, @PathVariable long telegramId){
        long orderId = orderService.addOrderFromTelegram(orderDTO, telegramId);
        return ResponseHandler.responseBuilder("Order was added", HttpStatus.CREATED, orderId);

    }
}
