/*
 * (c) Midland Software Limited 2025
 * Name     : User.java
 * Author   : RoodbarakyK
 * Date     : 13 Jun 2025
 */
package Behavioural.Mediator;

//Abstract Colleague
public abstract class User {
    protected String name;
    protected ChatRoom chatRoom;

    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public abstract void sendMessage(String message);

    public abstract void receiveMessage(String message, User sender);
}
