/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package passwordcapture;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import passwordcaputure.Passwordcaputure;

/**
 *
 * @author Cognitive daniel
 */
public class PasswordcaptureTest {
    
    public PasswordcaptureTest() {
    }
    @Test
    void testUsernameValid() {
        assertTrue(Passwordcaputure.checkUserName("ab_cd"));
    }
        @Test
void testPasswordValid() {
    assertTrue(Passwordcaputure.checkPasswordComplexity("Abc@1234"));
}

@Test
void testPasswordInvalid() {
    assertFalse(Passwordcaputure.checkPasswordComplexity("abc123"));
}
    @Test
void testPhoneValid() {
    assertTrue(Passwordcaputure.checkCellPhoneNumber("+27831234567"));
}

@Test
void testPhoneInvalid() {
    assertFalse(Passwordcaputure.checkCellPhoneNumber("0831234567"));
}
}
    


