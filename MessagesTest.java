/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passwordcapture;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import passwordcaputure.Messages;
/**
 *
 * @author Cognitive daniel
 */
public class MessagesTest {
    
    @Test
    public void testGenerateMessageID() {

        long id = Messages.generateMessageID();

        String messageID = String.valueOf(id);

        assertEquals(10, messageID.length());
    }

    @Test
    public void testCheckRecipientValid() {

        Messages obj = new Messages();

        boolean result =
                obj.checkRecipient("+27831234567");

        assertTrue(result);
    }

    @Test
    public void testCheckRecipientInvalid() {

        Messages obj = new Messages();

        boolean result =
                obj.checkRecipient("0831234567");

        assertFalse(result);
    }

    @Test
    public void testCreateMessageHash() {

        String result =
                Messages.createMessageHash(
                        1234567890L,
                        1,
                        "playing"
                );

        assertEquals("12:1:playing", result);
    }
}

