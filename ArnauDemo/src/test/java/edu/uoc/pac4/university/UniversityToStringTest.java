package edu.uoc.pac4.university;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UniversityToStringTest {

    @Test
    @Order(1)
    @DisplayName("University - toString")
    void testUniversityToString() throws UniversityException {
        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu");
        assertEquals("Universitat Oberta de Catalunya, UOC, 1994-10-06, Av. Tibidabo, 39-43, https://www.uoc.edu", university.toString());

        university = new University("Virtual University", "VU", LocalDate.of(2020, 1, 1), "Wirtland", "https://www.virtualuniversity.wirtland");
        assertEquals("Virtual University, VU, 2020-01-01, Wirtland, https://www.virtualuniversity.wirtland", university.toString());
    }

}
