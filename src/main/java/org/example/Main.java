package org.example;

import org.example.Assets.Token;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "https://t.me/Isystem_regBot";
    }

    @Override
    public String getBotToken() {
        Token token = new Token();
        String tok = token.getToken();
        return tok;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Main main = new Main();
        int COUNT_STEPS = 0;
        String TEXT = update.getMessage().getText();
        String chatId = String.valueOf(update.getMessage().getChatId());
        int messageId = update.getMessage().getMessageId();
        boolean hasTEXT = update.getMessage().hasText();


        if(hasTEXT && TEXT.equals("/start")){
            Send send = new Send();
            send.sendT(chatId,"Assalamu alaykum "+"<b>"+update.getMessage().getFrom().getFirstName()+"</b>"+"\nRegistratsitadan otishdan oldin tilni tanlagn!");
            send.setB(chatId,"O'zbek\uD83C\uDDFA\uD83C\uDDFF","Русский\uD83C\uDDF7\uD83C\uDDFA");
            send.executer(this);
        }
        if(hasTEXT && TEXT.equals("O'zbek\uD83C\uDDFA\uD83C\uDDFF")){
            DeleteMessage deleteMessage = new DeleteMessage();
            deleteMessage.setChatId(chatId);
            deleteMessage.setMessageId(messageId);
            try {
                execute(deleteMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.enableHtml(true);
            message.setChatId(chatId);
            message.setText("Kurslardan birini tanlang");
            ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
            kb.setResizeKeyboard(true);

            List<KeyboardRow> arrayButton = new ArrayList<>();
            KeyboardRow buttonRow1 = new KeyboardRow();
            KeyboardRow buttonRow2 = new KeyboardRow();
            KeyboardRow buttonRow3 = new KeyboardRow();
            KeyboardRow buttonsRow4 = new KeyboardRow();
            buttonRow1.add(new KeyboardButton("Python-Backend\uD83D\uDDFF"));
            buttonRow1.add(new KeyboardButton("Data-science\uD83D\uDDFF"));
            buttonRow2.add(new KeyboardButton("Java-Backend\uD83D\uDDFF"));
            buttonRow2.add(new KeyboardButton("Frontend\uD83D\uDDFF"));
            buttonRow3.add(new KeyboardButton("Android-development\uD83D\uDDFF"));
            buttonRow3.add(new KeyboardButton("IOS-development\uD83D\uDDFF"));
            buttonsRow4.add(new KeyboardButton("Bosh sahifaga qaytish\uD83D\uDD19"));


            arrayButton.add(buttonRow1);
            arrayButton.add(buttonRow2);
            arrayButton.add(buttonRow3);
            arrayButton.add(buttonsRow4);
            kb.setKeyboard(arrayButton);
            message.setReplyMarkup(kb);
            try {
                main.execute(message);
            }catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if(hasTEXT && TEXT.equals("Русский\uD83C\uDDF7\uD83C\uDDFA")){
            DeleteMessage deleteMessage = new DeleteMessage();
            deleteMessage.setChatId(chatId);
            deleteMessage.setMessageId(messageId);
            try {
                execute(deleteMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.enableHtml(true);
            message.setChatId(chatId);
            message.setText("выберите один из курсов, пожалуйста");
            ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
            kb.setResizeKeyboard(true);

            List<KeyboardRow> arrayButton = new ArrayList<>();
            KeyboardRow buttonRow1 = new KeyboardRow();
            KeyboardRow buttonRow2 = new KeyboardRow();
            KeyboardRow buttonRow3 = new KeyboardRow();
            KeyboardRow buttonsRow4 = new KeyboardRow();
            buttonRow1.add(new KeyboardButton("Python-Backend\uD83D\uDDFF"));
            buttonRow1.add(new KeyboardButton("Data-science\uD83D\uDDFF"));
            buttonRow2.add(new KeyboardButton("Java-Backend\uD83D\uDDFF"));
            buttonRow2.add(new KeyboardButton("Frontend\uD83D\uDDFF"));
            buttonRow3.add(new KeyboardButton("Android-development\uD83D\uDDFF"));
            buttonRow3.add(new KeyboardButton("IOS-development\uD83D\uDDFF"));
            buttonsRow4.add(new KeyboardButton("Вернуться на главную страницу\uD83D\uDD19"));

            arrayButton.add(buttonRow1);
            arrayButton.add(buttonRow2);
            arrayButton.add(buttonRow3);
            arrayButton.add(buttonsRow4);
            kb.setKeyboard(arrayButton);
            message.setReplyMarkup(kb);
            try {
                main.execute(message);
            }catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        if(hasTEXT && (TEXT.equals("Вернуться на главную страницу\uD83D\uDD19") || TEXT.equals("Bosh sahifaga qaytish\uD83D\uDD19"))){
            DeleteMessage deleteMessage = new DeleteMessage();
            deleteMessage.setChatId(chatId);
            deleteMessage.setMessageId(messageId);
            try {
                execute(deleteMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            Send send = new Send();
            send.sendT(chatId,"Registratsitadan otishdan oldin tilni tanlagn!");
            send.setB(chatId,"O'zbek\uD83C\uDDFA\uD83C\uDDFF","Русский\uD83C\uDDF7\uD83C\uDDFA");
            send.executer(this);
        }
        if(hasTEXT && (TEXT.equals("Python-Backend\uD83D\uDDFF")
                ||TEXT.equals("Data-science\uD83D\uDDFF")
                ||TEXT.equals("Java-Backend\uD83D\uDDFF")
                ||TEXT.equals("Frontend\uD83D\uDDFF")
                ||TEXT.equals("Android-development\uD83D\uDDFF")
                ||TEXT.equals("IOS-development\uD83D\uDDFF"))){
            DeleteMessage deleteMessage = new DeleteMessage();
            deleteMessage.setChatId(chatId);
            deleteMessage.setMessageId(messageId);
            COUNT_STEPS++;
            try {
                execute(deleteMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

            try {
                String mainPath = "C:\\Users\\viktusi5\\IdeaProjects\\RegistrationProccess\\src\\main\\java\\org\\example\\Assets\\";
                SendPhoto photo = new SendPhoto();
                photo.setChatId(chatId);
                SendMessage message = new SendMessage();
                Send inl = new Send();
                switch (TEXT){
                    case "Java-Backend\uD83D\uDDFF":
                        Path photoPath = Paths.get(mainPath+"photo.jpg");
                        InputFile photoFile = new InputFile(photoPath.toFile());
                        photo.setPhoto(photoFile);
                        String caption = "Ochilish sanasi 10.08.23\uD83D\uDE0A\n\n" +
                                "Guruh nomi: <b> Java19 </b>\n" +
                                "Kunlari: Toq kunlari\n"+
                                "Vaqti: 13:00 ➡️ 15:00\n\n"+
                                "Stay with us and carry on gaining knowledge\n"+
                                "@Abduroxman_IT_blog";
                        photo.setCaption(caption);
                        photo.setParseMode("Markdown");
                        photo.setParseMode("HTML");

                        photo.setReplyMarkup(inl.inlineButton(message,chatId,"https://t.me/isystemuz/803"));
                        main.execute(photo);
                        break;
                    case "Python-Backend\uD83D\uDDFF":
                        Path photoPath1 = Paths.get(mainPath+"How-to-Learn-Python.jpg");
                        InputFile photoFile1 = new InputFile(photoPath1.toFile());
                        photo.setPhoto(photoFile1);
                        String caption1 = "Ochilish sanasi 10.08.23\uD83D\uDE0A\n\n" +
                                "Guruh nomi: <b> Python14 </b>\n" +
                                "Kunlari: Juft kunlari\n"+
                                "Vaqti: 18:00 ➡️ 20:00\n\n"+
                                "Stay with us and carry on gaining knowledge\n"+
                                "@Abduroxman_IT_blog";
                        photo.setCaption(caption1);
                        photo.setParseMode("Markdown");
                        photo.setParseMode("HTML");
                        photo.setReplyMarkup(inl.inlineButton(message,chatId,"https://t.me/isystemuz/802"));
                        main.execute(photo);
                        break;
                    case "Data-science\uD83D\uDDFF":
                        Path photoPath2 = Paths.get(mainPath+"What-is-data-science-2.jpg");
                        InputFile photoFile2 = new InputFile(photoPath2.toFile());
                        photo.setPhoto(photoFile2);
                        String caption2 = "Ochilish sanasi 11.02.24\uD83D\uDE0A\n\n" +
                                "Guruh nomi: <b> Data-science1 </b>\n" +
                                "Kunlari: Juft kunlari\n"+
                                "Vaqti: 19:00 ➡️ 21:00\n\n"+
                                "Stay with us and carry on gaining knowledge\n"+
                                "@Abduroxman_IT_blog";
                        photo.setCaption(caption2);
                        photo.setParseMode("Markdown");
                        photo.setParseMode("HTML");
                        photo.setReplyMarkup(inl.inlineButton(message,chatId,"https://t.me/isystemuz/784"));
                        main.execute(photo);
                        break;
                    case "Android-development\uD83D\uDDFF":
                        Path photoPath3 = Paths.get(mainPath+"Android-app-development.jpg");
                        InputFile photoFile3 = new InputFile(photoPath3.toFile());
                        photo.setPhoto(photoFile3);
                        String caption3 = "Ochilish sanasi 31.05.24\uD83D\uDE0A\n\n" +
                                "Guruh nomi: <b> Android Development7 </b>\n" +
                                "Kunlari: Juft kunlari\n"+
                                "Vaqti: 12:00 ➡️ 14:00\n\n"+
                                "Stay with us and carry on gaining knowledge\n"+
                                "@Abduroxman_IT_blog";
                        photo.setCaption(caption3);
                        photo.setParseMode("Markdown");
                        photo.setParseMode("HTML");
                        photo.setReplyMarkup(inl.inlineButton(message,chatId,"https://t.me/isystemuz/761"));
                        main.execute(photo);
                        break;
                    case "IOS-development\uD83D\uDDFF":
                        Path photoPath4 = Paths.get(mainPath+"ISO.jpg");
                        InputFile photoFile4 = new InputFile(photoPath4.toFile());
                        photo.setPhoto(photoFile4);
                        String caption4 = "Ochilish sanasi 15.06.23\uD83D\uDE0A\n\n" +
                                "Guruh nomi: <b> IOS Development2 </b>\n" +
                                "Kunlari: Toq kunlari\n"+
                                "Vaqti: 12:00 ➡️ 14:00\n\n"+
                                "Stay with us and carry on gaining knowledge\n"+
                                "@Abduroxman_IT_blog";
                        photo.setCaption(caption4);
                        photo.setParseMode("Markdown");
                        photo.setParseMode("HTML");
                        photo.setReplyMarkup(inl.inlineButton(message,chatId,"https://t.me/isystemuz/729"));
                        main.execute(photo);
                        break;
                    case "Frontend\uD83D\uDDFF":
                        Path photoPath5 = Paths.get(mainPath+"fr.png");
                        InputFile photoFile5 = new InputFile(photoPath5.toFile());
                        photo.setPhoto(photoFile5);
                        String caption5 = "Ochilish sanasi 22.07.23\uD83D\uDE0A\n\n" +
                                "Guruh nomi: <b> Frontend Development23 </b>\n" +
                                "Kunlari: Toq kunlari\n"+
                                "Vaqti: 17:00 ➡️ 19:00\n\n"+
                                "Stay with us and carry on gaining knowledge\n"+
                                "@Abduroxman_IT_blog";
                        photo.setCaption(caption5);
                        photo.setParseMode("Markdown");
                        photo.setParseMode("HTML");
                        photo.setReplyMarkup(inl.inlineButton(message,chatId,"https://t.me/isystemuz/760"));
                        main.execute(photo);
                        break;

                }
            } catch (TelegramApiException e) {
                e.printStackTrace();

            }
        }
        if(COUNT_STEPS==1){
            Send sendGreeting = new Send();
            sendGreeting.sendT(String.valueOf(update.getMessage().getChatId()),"Ro'yxatdan otishingizni sorab qolamiz " + "<b>"+update.getMessage().getFrom().getFirstName()+"</b>");
            sendGreeting.setB(String.valueOf(update.getMessage().getChatId()),"Sign in","Sign up");
            sendGreeting.executer(this);
        }
        if(hasTEXT && TEXT.equals("Sign in")){
            DeleteMessage deleteMessage = new DeleteMessage();
            deleteMessage.setChatId(chatId);
            deleteMessage.setMessageId(messageId);
            try {
                execute(deleteMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            Send send = new Send();
            Send send1 = new Send();
            send.sendT(String.valueOf(update.getMessage().getChatId()),"Login va Parol:");
            send1.sendT(String.valueOf(update.getMessage().getChatId()),"Login @ dan boshlanishi shart va logindan keyin vergul qoyilishi kerak!\nMasalan: @Abduroxman_Qahramonov , 1234");
            send.setB(String.valueOf(update.getMessage().getChatId()),"Bosh sahifaga qaytish\uD83D\uDD19");
            send.executer(this);
            send1.executer(this);
        }
        if(hasTEXT && TEXT.equals("Sign up")){
            DeleteMessage deleteMessage = new DeleteMessage();
            deleteMessage.setChatId(chatId);
            deleteMessage.setMessageId(messageId);
            try {
                execute(deleteMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            Send send = new Send();
            Send send1 = new Send();
            send.sendT(String.valueOf(update.getMessage().getChatId()),"Login va Parol:");
            send.setB(String.valueOf(update.getMessage().getChatId()),"Bosh sahifaga qaytish\uD83D\uDD19");
            send.executer(this);

            send1.sendT(String.valueOf(update.getMessage().getChatId()),"Login @ dan boshlanishi shart va logindan keyin vergul qoyilishi kerak!, Keyin Parol qaytadan yozilishi kerak!\nMasalan: @Abduroxman_Qahramonov,1234,1234");
            send1.setB(chatId,"Tell raqamni yuborish\uD83D\uDCDE", 1);
            send1.executer(this);

        }
        else if(update.hasMessage() && update.getMessage().hasContact()){
            Validation validation = new Validation();
            Send send = new Send();
            send.sendT(String.valueOf(update.getMessage().getChatId()),"Raxmat\uD83D\uDE03");
            send.setB(chatId,"Bosh sahifaga qaytish\uD83D\uDD19");
            send.executer(this);

            Contact contact = update.getMessage().getContact();
            String phoneNumber = contact.getPhoneNumber();
            String firstName = contact.getFirstName();
            boolean wasThere = validation.hasContactC(phoneNumber);
            if(wasThere){
                String filePath = "C:\\Users\\viktusi5\\IdeaProjects\\RegistrationProccess\\src\\main\\java\\org\\example\\Contacts.txt";
                String content = phoneNumber+" "+firstName;
                try (FileWriter fileWriter = new FileWriter(filePath, true)) {
                    fileWriter.write(content);
                    fileWriter.write(System.lineSeparator());
                    fileWriter.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                Send send1 = new Send();
                send1.sendT(String.valueOf(update.getMessage().getChatId()),"Bu raqam allaqachon royxatdan otkan\uD83D\uDE03");
                send1.executer(this);
            }
        }
        else if(TEXT.startsWith("@")){
            Validation validation = new Validation();
            String answer = update.getMessage().getText().replaceAll("\\s","");
            String[] loginPassword = answer.split(",");
            Send send = new Send();

            switch (loginPassword.length){
                case 2:
                    if(validation.login(loginPassword[0],loginPassword[1])){
                        send.sendT(String.valueOf(update.getMessage().getChatId()), "Akkantga muvafaqiyatli kirildi!\uD83D\uDE0A");
                        send.executer(this);
                    }
                    else {
                        send.sendT(String.valueOf(update.getMessage().getChatId()),"Notog'ri login yoki parol\uD83E\uDD25");
                        send.executer(this);
                    }
                    break;
                case 3:
                    int checker = validation.signUp(loginPassword[0],loginPassword[1],loginPassword[2]);
                    switch (checker) {
                        case 0 -> {
                            send.sendT(String.valueOf(update.getMessage().getChatId()), "Bu akkaunt allaqachon royxatdan o'tkan\uD83E\uDD25");
                            send.executer(this);
                        }
                        case 1 -> {
                            send.sendT(String.valueOf(update.getMessage().getChatId()), "Ikkala parollarham birhil bolishi shart!");
                            send.executer(this);
                        }
                        case 2 -> {
                            send.sendT(String.valueOf(update.getMessage().getChatId()),"Muvafaqiyatli royxatdan otildi\uD83D\uDE03");

                            send.executer(this);
                        }
                    }
                    break;
                default:
                    send.sendT(String.valueOf(update.getMessage().getChatId()),"Login yoki Parol notogri terilgan! Qayta urining!");
                    send.executer(this);
            }
        }


    }
}
