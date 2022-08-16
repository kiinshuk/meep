package com.kinshuk.meepbot;

import com.kinshuk.meepbot.listener.EventListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class meepbot{

    private final Dotenv config;
    private final ShardManager shardManager;

    public meepbot() throws LoginException {
        config = Dotenv.configure().load();
        String Token = config.get("TOKEN");
        DefaultShardManagerBuilder builder= DefaultShardManagerBuilder.createDefault(Token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("with your mom"));
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        shardManager = builder.build();


        shardManager.addEventListener(new EventListener());
    }
    public ShardManager getShardManager(){
        return shardManager;
    }
    public static void main(String[] args){
        try {
            meepbot bot = new meepbot();
        } catch (LoginException e) {
            System.out.println("error in token");
        }

    }
}
