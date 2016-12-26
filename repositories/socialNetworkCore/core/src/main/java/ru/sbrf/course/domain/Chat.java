package ru.sbrf.course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Chat implements Serializable{
 /*   @Id
    @GeneratedValue
    private long chatId;

    private List<Long> members = new ArrayList<>();

    private List<Long> messages = new ArrayList<>();


    public void addMember(Long accountId) {
        members.add(accountId);
    }

    public void deleteMemeber(Long accountId) {
        members.remove(accountId);
    }

    public void addMessage(Long message) {
        messages.add(message);
    }

    public List<Long> getMessages() {
        return messages;
    }

    public List<Long> getMembers() {
        return members;
    }

    public long getChatId() {
        return chatId;
    }

    public void setMembers(List<Long> members) {
        this.members = members;
    }

    public void setMessages(List<Long> messages) {
        this.messages = messages;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }
*/
}