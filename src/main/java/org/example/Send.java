package org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Send {
    SendMessage message = new SendMessage();
    public void sendT(String chatId, String text) {
        message.enableHtml(true);
        message.setChatId(chatId);
        message.setText(text);
    }
    public void setB(String chatId,String... buttons){
        message.setChatId(chatId);
        ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
        kb.setResizeKeyboard(true);

        List<KeyboardRow> arrayButton = new ArrayList<>();
        KeyboardRow buttonRow = new KeyboardRow();
        for(String btn : buttons){
            buttonRow.add(new KeyboardButton(btn));
        }
        arrayButton.add(buttonRow);
        kb.setKeyboard(arrayButton);
        message.setReplyMarkup(kb);
    }
    public void setB(String chatId,String name,int a){
        message.setChatId(chatId);
        ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
        kb.setResizeKeyboard(true);

        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setText(name);
        keyboardButton.setRequestContact(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow buttonRow = new KeyboardRow();
        buttonRow.add(keyboardButton);
        keyboardRows.add(buttonRow);

        kb.setKeyboard(keyboardRows);
        message.setReplyMarkup(kb);
    }

    public InlineKeyboardMarkup inlineButton(SendMessage message, String chatId, String link){
        message.setChatId(chatId);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Batafsil malumot");
        button1.setUrl(link);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(button1);
        keyboardRows.add(row1);
        inlineKeyboardMarkup.setKeyboard(keyboardRows);

        return inlineKeyboardMarkup;
    }

    public void executer(AbsSender sender){
        try {
            sender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
