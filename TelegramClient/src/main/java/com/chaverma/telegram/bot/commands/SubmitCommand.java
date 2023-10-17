package com.chaverma.telegram.bot.commands;

import com.chaverma.telegram.api.ApiResponse;
import com.chaverma.telegram.utils.MessageSender;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract public class SubmitCommand {
    private final String successMessage;

    private final String errorMessage;

    private final String description;

    public SubmitCommand(String description, String successMessage, String errorMessage) {
        this.description = description;
        this.successMessage = successMessage;
        this.errorMessage = errorMessage;
    }

    public <T> void printMessage(AbsSender absSender, Message message, ApiResponse<T> apiResponse){
        String sendText;
        if (apiResponse.getHttpStatus().is2xxSuccessful())
            sendText = successMessage;
        else {
            sendText = errorMessage;
        }try {
            MessageSender.sendMessage(absSender, message.getChatId(), sendText);
        }catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDescription() {
        return description;
    }
}
