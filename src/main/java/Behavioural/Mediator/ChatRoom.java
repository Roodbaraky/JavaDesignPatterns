/*
 * (c) Midland Software Limited 2025
 * Name     : ChatRoom.java
 * Author   : RoodbarakyK
 * Date     : 13 Jun 2025
 */
package Behavioural.Mediator;

import java.util.List;

//Mediator Interface
public interface ChatRoom {
    void sendMessage(String message, User sender);

    void register(User... users);

    List<User> getUsers();
}
