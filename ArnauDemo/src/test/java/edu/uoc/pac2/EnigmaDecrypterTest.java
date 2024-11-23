package edu.uoc.pac2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EnigmaDecrypterTest {

    private String[] rotorConfigurations = {
            "EKMFLGDQVZNTOWYHXUSPAIBRCJ",
            "AJDKSIRUXBLHWTMCQGZNPYFVOE",
            "BDFHJLCPRTXVZNYEIWGAKMUSQO"
    };

    @Test
    @Order(1)
    @DisplayName("isValidRotor")
    public void testIsValidRotor() {
        assertFalse(EnigmaDecrypter.isValidRotor("UO"));
        assertFalse(EnigmaDecrypter.isValidRotor("OC"));
        assertFalse(EnigmaDecrypter.isValidRotor("U"));
        assertFalse(EnigmaDecrypter.isValidRotor("O"));
        assertFalse(EnigmaDecrypter.isValidRotor("C"));
        assertFalse(EnigmaDecrypter.isValidRotor(""));
        assertFalse(EnigmaDecrypter.isValidRotor("U O C"));
        assertTrue(EnigmaDecrypter.isValidRotor("UOC"));
        assertTrue(EnigmaDecrypter.isValidRotor("UOCX"));
    }

    @Test
    @Order(2)
    @DisplayName("decryptChar")
    public void testDecryptChar() {
        assertEquals('K', EnigmaDecrypter.decryptChar('T', rotorConfigurations[0], 1));
        assertEquals('R', EnigmaDecrypter.decryptChar('T', rotorConfigurations[0], 20));

        assertEquals('!', EnigmaDecrypter.decryptChar('!', rotorConfigurations[0], 0));
        assertEquals('\'', EnigmaDecrypter.decryptChar('\'', rotorConfigurations[0], 0));

        assertEquals('U', EnigmaDecrypter.decryptChar('A', rotorConfigurations[0], 0));
        assertEquals('T', EnigmaDecrypter.decryptChar('A', rotorConfigurations[0], 1));
        assertEquals('P', EnigmaDecrypter.decryptChar('A', rotorConfigurations[0], 5));
        assertEquals('U', EnigmaDecrypter.decryptChar('A', rotorConfigurations[0], 26));

        assertEquals('A', EnigmaDecrypter.decryptChar('A', rotorConfigurations[1], 0));
        assertEquals('Z', EnigmaDecrypter.decryptChar('A', rotorConfigurations[1], 1));
        assertEquals('V', EnigmaDecrypter.decryptChar('A', rotorConfigurations[1], 5));
        assertEquals('A', EnigmaDecrypter.decryptChar('A', rotorConfigurations[1], 26));

        assertEquals('A', EnigmaDecrypter.decryptChar('B', rotorConfigurations[2], 0));
        assertEquals('Z', EnigmaDecrypter.decryptChar('B', rotorConfigurations[2], 1));
        assertEquals('V', EnigmaDecrypter.decryptChar('B', rotorConfigurations[2], 5));
        assertEquals('A', EnigmaDecrypter.decryptChar('B', rotorConfigurations[2], 26));
    }

    @Test
    @Order(3)
    @DisplayName("decryptMessage")
    public void testDecryptMessage() {
        assertEquals("0123456789!$%&/()=? -_.,;:", EnigmaDecrypter.decryptMessage("0123456789!$%&/()=? -_.,;:", rotorConfigurations[0]));
        assertEquals("UOC REMEMBER THAT THIS PAC IS DUE ON NOVEMBER FOURTH", EnigmaDecrypter.decryptMessage("AHL IZSTANYM DIHZ TEMW OCK ZA QJN BB CEVSKUIZ JZXYUD", rotorConfigurations[0]));
        assertEquals("UOC I LOVE THIS PAC", EnigmaDecrypter.decryptMessage("PCS W GYKT SNYR IGP", rotorConfigurations[1]));
        assertEquals("UOC I CANNOT WAIT TO SEE THE PR", EnigmaDecrypter.decryptMessage("KEJ Z RPMUQJ TYST VP NBD GPL GM", rotorConfigurations[2]));
        assertEquals("UOC I AM AT BONIFACE", EnigmaDecrypter.decryptMessage("PCS W RN BK TJJVYGPV", rotorConfigurations[1]));
        assertEquals("UOC YOU HAVE REACHED THE SOLUTION IF YOU CAN READ THIS", EnigmaDecrypter.decryptMessage("KEJ FAB ETLE JGEGQUU YHD WYZUUZAA IY TBP WIJ XQMO WCRA", rotorConfigurations[2]));
        assertEquals("THOSE WHO CAN IMAGINE ANYTHING, CAN CREATE THE IMPOSSIBLE - ALAN TURING - UOC", EnigmaDecrypter.decryptMessage("PVXIV MYB OTJ BKXREDC BNBSQZHZ, VQI OMXWQP NJR FVOOUSZFYV - VANC DVDCLC - XTE", rotorConfigurations[0]));
    }

    @Test
    @Order(4)
    @DisplayName("turingBruteForce")
    public void testTuringBruteForce() {
        assertEquals("", EnigmaDecrypter.turingBruteForce("IZSTANYM DIHZ TEMW OCK ZA QJN BB CEVSKUIZ JZXYUD"));
        assertEquals("", EnigmaDecrypter.turingBruteForce("UOC"));
        assertEquals("", EnigmaDecrypter.turingBruteForce("0123456789!$%&/()=? -_.,;:"));
        assertEquals("UOC REMEMBER THAT THIS PAC IS DUE ON NOVEMBER FOURTH", EnigmaDecrypter.turingBruteForce("AHL IZSTANYM DIHZ TEMW OCK ZA QJN BB CEVSKUIZ JZXYUD"));
        assertEquals("UOC I LOVE THIS PAC", EnigmaDecrypter.turingBruteForce("PCS W GYKT SNYR IGP"));
        assertEquals("UOC I CANNOT WAIT TO SEE THE PR", EnigmaDecrypter.turingBruteForce("KEJ Z RPMUQJ TYST VP NBD GPL GM"));
        assertEquals("UOC I AM AT BONIFACE", EnigmaDecrypter.turingBruteForce("PCS W RN BK TJJVYGPV"));
        assertEquals("UOC YOU HAVE REACHED THE SOLUTION IF YOU CAN READ THIS", EnigmaDecrypter.turingBruteForce("KEJ FAB ETLE JGEGQUU YHD WYZUUZAA IY TBP WIJ XQMO WCRA"));
        assertEquals("THOSE WHO CAN IMAGINE ANYTHING, CAN CREATE THE IMPOSSIBLE - ALAN TURING - UOC", EnigmaDecrypter.turingBruteForce("PVXIV MYB OTJ BKXREDC BNBSQZHZ, VQI OMXWQP NJR FVOOUSZFYV - VANC DVDCLC - XTE"));
    }

}
