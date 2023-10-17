package com.chaverma.telegram.utils;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
public class MessageSender {
    public static void sendMessage(AbsSender absSender, long chatId, String sendText) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(sendText);
        absSender.execute(sendMessage);
        log.debug("Successfully send message to {}", chatId);
    }
}
