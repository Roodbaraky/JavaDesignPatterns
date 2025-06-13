/*
 * (c) Midland Software Limited 2025
 * Name     : BasicUser.java
 * Author   : RoodbarakyK
 * Date     : 13 Jun 2025
 */
package Behavioural.Mediator;

//Concrete Colleague
public class BasicUser extends User {

    public BasicUser(final String name, final ChatRoom chatRoom) {
        super(name, chatRoom);
    }

    @Override
    public void sendMessage(final String message) {
        chatRoom.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(final String message, User sender) {
        System.out.println(sender + ": " + message);
    }
}
