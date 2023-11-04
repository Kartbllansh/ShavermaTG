package com.shaverma.rest.service;

import com.chaverma.dto.MenuDTO;
import com.shaverma.database.entity.Menu;

import java.util.List;

public interface MenuService {
    List<MenuDTO> getMenu();
}
