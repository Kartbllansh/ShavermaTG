package com.chaverma.dto;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDTO(
        LocalDateTime timeOrder, List<MenuDTO> dish

        ) {
}
