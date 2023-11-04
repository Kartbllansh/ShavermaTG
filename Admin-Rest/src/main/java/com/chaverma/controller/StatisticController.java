package com.chaverma.controller;

import com.chaverma.dto.UserDTO;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/statistic")
public class StatisticController {

    @GetMapping("/order")
    private ResponseEntity<Object> getStatisticOrder(@RequestBody UserDTO userDTO){
        return null;
    }
    @GetMapping("/consumer")
    private ResponseEntity<Object> getStatisticConsumer(@RequestBody UserDTO userDTO){
        return null;
    }
    //Метод для возвращения статистика за день, неделю или месяц
    @GetMapping("/every")
    private ResponseEntity<Object> getStatisticEvery(@RequestBody UserDTO userDTO){
        return null;
    }

}
