/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggerdesign;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Message {
    
    MessageType messageType;
    String message;
    

    public Message(String message, MessageType messageType) {
        //System.out.println("loggerdesign.Message.<init>()");
        this.message = message;
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "Message{" + "messageType=" + messageType + ", message=" + message + '}';
    }
    
}
