package com.shaverma.rest.service;

import com.chaverma.dto.MenuDTO;
import com.chaverma.dto.OrderDTO;
import com.shaverma.database.dao.ActiveOderDAO;
import com.shaverma.database.dao.ListOrderDAO;
import com.shaverma.database.entity.ActiveOrder;
import com.shaverma.database.entity.Menu;
import com.shaverma.database.entity.Order;
import com.shaverma.database.entity.user.AllUser;
import com.shaverma.database.entity.user.TelegramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private final ActiveOderDAO activeOderDAO;

    private final ListOrderDAO listOrderDAO;

    private final UserService userService;

    @Autowired
    public OrderServiceImpl(ActiveOderDAO activeOderDAO, ListOrderDAO listOrderDAO, UserService userService) {
        this.activeOderDAO = activeOderDAO;
        this.listOrderDAO = listOrderDAO;
        this.userService = userService;
    }

    @Override
    public long addOrderFromTelegram(OrderDTO orderDTO, long telegramId) {
        ActiveOrder activeOrder = (ActiveOrder) toEntityFromTelegram(orderDTO, telegramId);
        long idOrder = activeOderDAO.save(activeOrder).getId();
        long firstId = activeOderDAO.findFirstId();
        return idOrder - firstId + 1;
    }

    private Order toEntityFromTelegram(OrderDTO orderDTO, long id){
       return Order.builder()
                .dish(toMenus(orderDTO.dish()))
                .timeOrder(orderDTO.timeOrder())
                .user(findTelegramUser(id))
                .price(countPriceMenu(orderDTO.dish()))
                .build();
    }

    private Double countPriceMenu(List<MenuDTO> menus){
        return menus.stream().mapToDouble(MenuDTO::price).sum();
    }
    private List<Menu> toMenus(List<MenuDTO> menus){
        return menus.stream().map(MenuDTO::toEntity).toList();
    }

    private AllUser findTelegramUser(long id){
        return AllUser.builder().telegramUser(
                    userService.findById(id)
                )
                .build();
    }


}
