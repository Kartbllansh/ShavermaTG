package com.chaverma.telegram.bot;

import com.chaverma.telegram.bot.commands.Start;
import com.chaverma.telegram.utils.MessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
@PropertySource(value = {"classpath:application.properties", "classpath:commands.properties"}, encoding = "UTF-8")
public class TelegramBot extends TelegramLongPollingCommandBot {

    @Value("${bot.name}")
    private String botUsername;

    @Value("${command.non_exist.description.text}")
    private String nonExist;

    public TelegramBot(@Value("${bot.token}") String botToken) {
        super(botToken);
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        if(update.hasMessage()){
            try {
                MessageSender.sendMessage(this, update.getMessage().getChatId(), nonExist);
                log.debug("Send message that command doesnt exist");
            } catch (TelegramApiException e) {
                log.debug("Cannot send message to {} that command doesnt exist", update.getMessage().getChatId());
                throw new RuntimeException(e);
            }
        }
    }

    @Autowired
    @Override
    public String getBotUsername() {
        return botUsername;
    }

}
