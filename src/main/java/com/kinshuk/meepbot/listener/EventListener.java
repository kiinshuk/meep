package com.kinshuk.meepbot.listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class EventListener extends ListenerAdapter {

    String prefix = ">>";

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        if (message.contains(prefix+"info")){
            event.getChannel().sendMessage("I am Creepbot.\n\n 'I am created by kinshuk' ").queue();
            return;
        }
        if (message.contains(prefix+"help")) {
            event.getChannel().sendMessage("").queue();
            return;
        }
    }
}
