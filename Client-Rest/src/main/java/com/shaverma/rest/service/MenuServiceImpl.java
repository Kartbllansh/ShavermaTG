package com.shaverma.rest.service;

import com.chaverma.dto.MenuDTO;
import com.shaverma.database.dao.MenuDAO;
import com.shaverma.database.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    private final MenuDAO menuDAO;

    public MenuServiceImpl(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    @Override
    public List<MenuDTO> getMenu() {
        List<Menu> menus = menuDAO.findAll();
        return menus.stream().map(Menu::toDTO).toList();
    }
}
