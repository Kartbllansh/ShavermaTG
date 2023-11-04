package com.shaverma.rest.service;

import com.chaverma.dto.OrderDTO;

public interface OrderService {
    long addOrderFromTelegram(OrderDTO orderDTO, long telegramId);
}
