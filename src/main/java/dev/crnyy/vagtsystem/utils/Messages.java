package dev.crnyy.vagtsystem.utils;

import dev.crnyy.vagtsystem.files.Message;

public class Messages {

    private final Message message;

    public Messages(Message message) {
        this.message = message;
    }
    public String vagtshopBuyedItem(String type, int price) {
        String oldMessage = message.getMessages().getString("Vagtshop.buyed-item");
        String newMessageOne = oldMessage.replace("{0}", type);
        return newMessageOne.replace("{1}", String.valueOf(price));
    }

    public String vagtshopNoMoney(String type, int price) {
        String oldMessage = message.getMessages().getString("Vagtshop.no-money");
        String newMessageOne = oldMessage.replace("{0}", type);
        return newMessageOne.replace("{1}", String.valueOf(price));
    }
    public String vagtshopNoMoneyEnchant() {
        return message.getMessages().getString("Vagtshop.no-money");
    }

    public String vagtshopEnchant(String enchant, int amount) {
        String oldMessage = message.getMessages().getString("Vagtshop.enchant-item");
        String newMessageOne = oldMessage.replace("{0}", enchant);
        return newMessageOne.replace("{1}", String.valueOf(amount));
    }

    public String vagtshopAlreadyOwned(String enchantType) {
        String oldMessage = message.getMessages().getString("Vagtshop.no-money");
        return oldMessage.replace("{0}", String.valueOf(enchantType));
    }

    public String vagtpayPayout() {
        return message.getMessages().getString("Vagtpay.payout");
    }

    public String repairSignrepaired(String type, int price) {
        String oldMessage = message.getMessages().getString("repair.repair-text");
        String newMessageOne = oldMessage.replace("{0}", type);
        return newMessageOne.replace("{1}", String.valueOf(price));
    }


    public String repairSignnotmoney(String type, int price) {
        String oldMessage = message.getMessages().getString("repair.no-money");
        String newMessageOne = oldMessage.replace("{0}", type);
        return newMessageOne.replace("{1}", String.valueOf(price));
    }
    public String vagtChat(String type, String chat) {
        String oldMessage = message.getMessages().getString("vagtchat.chat");
        String newMessageOne = oldMessage.replace("{0}", type);
        return newMessageOne.replace("{1}", chat);
    }
    public String vagtWarpGoto(String warp) {
        String oldMessage = message.getMessages().getString("vagtwarp.goto");
        return oldMessage.replace("{0}", String.valueOf(warp));
    }
    public String vagtWarpnotbuyed(String warp) {
        String oldMessage = message.getMessages().getString("vagtwarp.notbuyed");
        return oldMessage.replace("{0}", String.valueOf(warp));
    }
    public String VagtWarpBuyed(String type, int price) {
        String oldMessage = message.getMessages().getString("vagtwarp.buyedwarp");
        String newMessageOne = oldMessage.replace("{0}", type);
        return newMessageOne.replace("{1}", String.valueOf(price));
    }
    public String VagtWarpNoMoney(String type, int price) {
        String oldMessage = message.getMessages().getString("vagtwarp.nomoney");
        String newMessageOne = oldMessage.replace("{0}", type);
        return newMessageOne.replace("{1}", String.valueOf(price));
    }
    public String VagtPvAlreadyown(String type, int price) {
        String oldMessage = message.getMessages().getString("vagtshopitems.alreadyown");
        String newMessageOne = oldMessage.replace("{0}", type);
        return newMessageOne.replace("{1}", String.valueOf(price));
    }
    public String VagtPvNoMoney(String type, int price) {
        String oldMessage = message.getMessages().getString("vagtshopitems.nomoneypv");
        String newMessageOne = oldMessage.replace("{0}", type);
        return newMessageOne.replace("{1}", String.valueOf(price));
    }
    public String VagtPvBuyed(String type, int price) {
        String oldMessage = message.getMessages().getString("vagtshopitems.buyed-pv");
        String newMessageOne = oldMessage.replace("{0}", type);
        return newMessageOne.replace("{1}", String.valueOf(price));
    }
    public String VagtPvNotInOrder(String type, int price) {
        String oldMessage = message.getMessages().getString("vagtshopitems.no-order");
        String newMessageOne = oldMessage.replace("{0}", type);
        return newMessageOne.replace("{1}", String.valueOf(price));
    }


}
