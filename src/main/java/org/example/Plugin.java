package org.example;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.FriendAddEvent;
import net.mamoe.mirai.event.events.FriendEvent;
import net.mamoe.mirai.event.events.FriendMessageEvent;

public final class Plugin extends JavaPlugin {
    public static final Plugin INSTANCE = new Plugin();

    private Plugin() {
        super(new JvmPluginDescriptionBuilder("org.example.plugin", "1.0-SNAPSHOT").build());
    }

    @Override
    public void onEnable() {
        getLogger().info("Plugin loaded!");
        GlobalEventChannel.INSTANCE.subscribeAlways(FriendMessageEvent.class, (FriendMessageEvent event) ->{
            event.getSender().sendMessage("喵");
        });
    }
}