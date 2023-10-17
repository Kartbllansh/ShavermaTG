package com.chaverma.telegram.bot;

import com.chaverma.telegram.bot.commands.Start;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Slf4j
@Component
public class Initializer {
    private final TelegramBot bot;
    private final Start start;
    @Autowired
    public Initializer(TelegramBot bot, Start start) {
        this.bot = bot;
        this.start = start;
    }

    @EventListener({ContextRefreshedEvent.class})
    public void init() {
        try {
            log.debug("register bot");
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(bot);
            log.debug("register commands");
            bot.register(start);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }
}
