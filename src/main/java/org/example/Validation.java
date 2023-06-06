package org.example;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Validation {
    private String log;
    private String passwrd;
    private boolean isRegistered(String login){
        String filePath = "C:\\Users\\viktusi5\\IdeaProjects\\RegistrationProccess\\src\\main\\java\\org\\example\\Registration.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lg = line.split(" ");
                if(lg[0].equals(login)){
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean hasContactC(String number){
        String filePath = "C:\\Users\\viktusi5\\IdeaProjects\\RegistrationProccess\\src\\main\\java\\org\\example\\Contacts.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lg = line.split(" ");
                System.out.println(lg[0]);
                if(lg[0].equals(number)){
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    public boolean login(String login,String password){
        String filePath = "C:\\Users\\viktusi5\\IdeaProjects\\RegistrationProccess\\src\\main\\java\\org\\example\\Registration.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(login+" "+password);
                if(line.equals(login+" "+password)){
                    this.log = login;
                    this.passwrd = password;
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public int signUp(String login,String password,String passwordConfirm){
        int count = 0;
        if(isRegistered(login)){
            count++;
            if(password.equals(passwordConfirm)){
                String filePath = "C:\\Users\\viktusi5\\IdeaProjects\\RegistrationProccess\\src\\main\\java\\org\\example\\Registration.txt";
                String content = login+" "+password;
                count++;
                try (FileWriter fileWriter = new FileWriter(filePath, true)) {
                    fileWriter.write(content);
                    fileWriter.write(System.lineSeparator());
                    fileWriter.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return count;
    }


    public String getLog() {
        return log;
    }

    public String getPasswrd() {
        return passwrd;
    }

}
