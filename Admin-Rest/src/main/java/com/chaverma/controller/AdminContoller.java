package com.chaverma.controller;


import com.chaverma.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminContoller {

    @PostMapping("/root")
    private ResponseEntity<Object> setRootInfo(@RequestBody UserDTO userDTO){

        return null;
    }
    @GetMapping("/order")
    private ResponseEntity<Object> getStatusOrder(@RequestBody UserDTO userDTO){
return null;
    }
}
