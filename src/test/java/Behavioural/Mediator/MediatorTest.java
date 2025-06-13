package Behavioural.Mediator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MediatorTest {
    private ChatRoom chatRoom;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        chatRoom = new ChatRoomImpl();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testAddChatRoom() {
        User user1 = new BasicUser("John", chatRoom);
        User user2 = new BasicUser("Jane", chatRoom);
        chatRoom.register(user1);
        chatRoom.register(user2);
        assertEquals(2, chatRoom.getUsers().size());
    }

    @Test
    void testMessage() {
        User user1 = new BasicUser("John", chatRoom);
        User user2 = new BasicUser("Jane", chatRoom);
        chatRoom.register(user1);
        chatRoom.register(user2);
        String message = "Hello World";
        user1.sendMessage(message);
        assertTrue(outputStream.toString().contains(message));
    }

    @Test
    void testMessage_NoReceiver() {
        User user1 = new BasicUser("John", chatRoom);
        chatRoom.register(user1);
        String message = "Hello World";
        user1.sendMessage(message);
        assertFalse(outputStream.toString().contains(message));
    }

    @Test
    void testMessage_MultipleReceivers() {
        User user1 = new BasicUser("John", chatRoom);
        User user2 = new BasicUser("Jane", chatRoom);
        User user3 = new BasicUser("Jane", chatRoom);
        chatRoom.register(user1);
        chatRoom.register(user2);
        chatRoom.register(user3);
        String message = "Hello World";
        user1.sendMessage(message);
        long newlineCount = outputStream
                .toString()
                .lines()
                .count();
        assertEquals(2, newlineCount);
    }

}