package dev.crnyy.vagtsystem.plugins.vagtshop.rareshop.listener;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.utils.Messages;
import org.bukkit.event.Listener;

public class RareShopListener implements Listener {
        private Config config;
        private Message message;
        private Messages messages;
        private Main main;

        public RareShopListener(Config config, Message message, Messages messages, Main main) {
            this.config = config;
            this.message = message;
            this.messages = messages;
            this.main = main;
        }
}
