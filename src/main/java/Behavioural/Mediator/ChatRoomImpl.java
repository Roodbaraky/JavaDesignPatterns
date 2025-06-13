/*
 * (c) Midland Software Limited 2025
 * Name     : ChatRoomImpl.java
 * Author   : RoodbarakyK
 * Date     : 13 Jun 2025
 */
package Behavioural.Mediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Concrete Mediator
public class ChatRoomImpl implements ChatRoom {
    public List<User> getUsers() {
        return users;
    }

    List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(final String message, User sender) {
        for (User user : users) {
            if (!sender.equals(user)) {
                user.receiveMessage(message, sender);
            }
        }
    }

    @Override
    public void register(final User... users) {
        this.users.addAll(Arrays.asList(users));
    }
}
