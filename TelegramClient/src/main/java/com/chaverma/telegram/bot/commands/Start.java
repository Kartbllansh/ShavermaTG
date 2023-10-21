package com.chaverma.telegram.bot.commands;


import com.chaverma.telegram.api.ApiResponse;
import com.chaverma.telegram.api.commands.AdderUser;
import com.chaverma.telegram.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.Date;

@Component
public class Start extends SubmitCommand implements IBotCommand {

    private final AdderUser adderUser;

    public Start(@Value("${command.start.description.text}") String commandDescription,
                 @Value("${command.start.success.text}") String successMessage,
                 @Value("${command.start.error.text}") String errorMessage,
                 @Autowired AdderUser adderUser) {
        super(commandDescription, successMessage, errorMessage);
        this.adderUser = adderUser;
    }

    @Override
    public String getCommandIdentifier() {
        return "start";
    }


    @Override
    public void processMessage(AbsSender absSender, Message message, String[] arguments) {
        long id = message.getFrom().getId();
        String username = message.getFrom().getUserName();
        UserDTO userDTO = new UserDTO(id, username, new Date());
        ApiResponse<Long> apiResponse = adderUser.execute(userDTO, null);
        printMessage(absSender, message, apiResponse);
    }
}