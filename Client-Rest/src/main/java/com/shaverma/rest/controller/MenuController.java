package com.shaverma.rest.controller;

import com.chaverma.dto.MenuDTO;
import com.chaverma.response.ResponseHandler;
import com.shaverma.database.entity.Menu;
import com.shaverma.rest.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public ResponseEntity<Object> getMenu(){
        List<MenuDTO> menus = menuService.getMenu();
        return ResponseHandler.responseBuilder("All menu was sent", HttpStatus.OK, menus);
    }
}
