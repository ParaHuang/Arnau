package edu.uoc.pac4;

import edu.uoc.pac4.university.University;
import edu.uoc.pac4.university.UniversityException;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DSLabEqualsToStringTest {

    @Test
    @Order(1)
    @DisplayName("DSLab - toString")
    void testDSLabCreationToString() throws DSLabException, UniversityException {
        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39", "www.uoc.edu");
        DSLab dsLab = new DSLab("DSLab", "DSLab description", 1, 2, 3, 2_147_483_648L, university);

        assertEquals("DSLab" + System.lineSeparator() +
                "\tDescription: DSLab description" + System.lineSeparator() +
                "\tVersion: 1.2.3" + System.lineSeparator() +
                "\tStatus: [ACTIVE]" + System.lineSeparator() +
                "\tCPU: 2147483648" + System.lineSeparator() +
                "\tUniversity: Universitat Oberta de Catalunya, UOC, 1994-10-06, Av. Tibidabo, 39, www.uoc.edu", dsLab.toString());

        University university2 = new University("Virtual University", "VU", LocalDate.of(1450, 3, 3), "Wirtland", "https://www.virtualuniversity.wirtland");
        DSLab dsLab2 = new DSLab("DSLab 2", "DSLab description 2", 2, 1, 1, 4_294_967_296L, university2);
        dsLab2.setStatus(DSLabStatus.INACTIVE);

        assertEquals("DSLab 2" + System.lineSeparator() +
                "\tDescription: DSLab description 2" + System.lineSeparator() +
                "\tVersion: 2.1.1" + System.lineSeparator() +
                "\tStatus: [INACTIVE]" + System.lineSeparator() +
                "\tCPU: 4294967296" + System.lineSeparator() +
                "\tUniversity: Virtual University, VU, 1450-03-03, Wirtland, https://www.virtualuniversity.wirtland", dsLab2.toString());
    }

    @Test
    @Order(2)
    @DisplayName("DSLab - equals")
    void testDSLabCreationEquals() throws DSLabException, UniversityException {
        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39", "www.uoc.edu");
        DSLab dsLab = new DSLab("DSLab", "DSLab description", 1, 2, 3, 2_147_483_648L, university);

        University university2 = new University("Virtual University", "VU", LocalDate.of(1450, 3, 3), "Wirtland", "https://www.virtualuniversity.wirtland");
        DSLab dsLab2 = new DSLab("DSLab 2", "DSLab description 2", 2, 1, 1, 4_294_967_296L, university2);

        DSLab dsLab3 = new DSLab("DSLab", "DSLab description different", 1, 2, 3, 2_147_403_648L, university);

        assertEquals(dsLab, dsLab);
        assertEquals(dsLab, dsLab3);
        assertNotEquals(dsLab, dsLab2);

        dsLab3.setUniversity(university2);
        assertEquals(dsLab, dsLab3);

        dsLab3.setVersionMajor(5);
        assertNotEquals(dsLab, dsLab3);
    }

}
