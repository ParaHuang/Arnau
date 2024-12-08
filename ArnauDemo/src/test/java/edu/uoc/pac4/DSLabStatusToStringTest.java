package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DSLabStatusToStringTest {

    @Test
    @Order(1)
    @DisplayName("DSLabStatus - toString")
    void testDSLabStatusToString() {
        assertEquals("[ACTIVE]", DSLabStatus.ACTIVE.toString());
        assertEquals("[INACTIVE]", DSLabStatus.INACTIVE.toString());
        assertEquals("[MAINTENANCE]", DSLabStatus.MAINTENANCE.toString());
    }

}
