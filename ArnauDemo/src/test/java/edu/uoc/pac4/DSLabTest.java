package edu.uoc.pac4;

import edu.uoc.pac4.university.University;
import edu.uoc.pac4.university.UniversityException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DSLabTest {

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(9, DSLab.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredField("MIN_CPU_REQUIRED").getModifiers()));
            assertTrue(Modifier.isStatic(DSLab.class.getDeclaredField("MIN_CPU_REQUIRED").getModifiers()));
            assertTrue(Modifier.isFinal(DSLab.class.getDeclaredField("MIN_CPU_REQUIRED").getModifiers()));
            assertEquals(long.class, DSLab.class.getDeclaredField("MIN_CPU_REQUIRED").getType());
            assertEquals(1_073_741_824L, DSLab.MIN_CPU_REQUIRED);

            assertTrue(Modifier.isPrivate(DSLab.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, DSLab.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(DSLab.class.getDeclaredField("description").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredField("description").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredField("description").getModifiers()));
            assertEquals(String.class, DSLab.class.getDeclaredField("description").getType());

            assertTrue(Modifier.isPrivate(DSLab.class.getDeclaredField("versionMajor").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredField("versionMajor").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredField("versionMajor").getModifiers()));
            assertEquals(int.class, DSLab.class.getDeclaredField("versionMajor").getType());

            assertTrue(Modifier.isPrivate(DSLab.class.getDeclaredField("versionMinor").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredField("versionMinor").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredField("versionMinor").getModifiers()));
            assertEquals(int.class, DSLab.class.getDeclaredField("versionMinor").getType());

            assertTrue(Modifier.isPrivate(DSLab.class.getDeclaredField("versionPatch").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredField("versionPatch").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredField("versionPatch").getModifiers()));
            assertEquals(int.class, DSLab.class.getDeclaredField("versionPatch").getType());

            assertTrue(Modifier.isPrivate(DSLab.class.getDeclaredField("cpu").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredField("cpu").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredField("cpu").getModifiers()));
            assertEquals(long.class, DSLab.class.getDeclaredField("cpu").getType());

            assertTrue(Modifier.isPrivate(DSLab.class.getDeclaredField("university").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredField("university").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredField("university").getModifiers()));
            assertEquals(University.class, DSLab.class.getDeclaredField("university").getType());

            assertTrue(Modifier.isPrivate(DSLab.class.getDeclaredField("status").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredField("status").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredField("status").getModifiers()));
            assertEquals(DSLabStatus.class, DSLab.class.getDeclaredField("status").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(1, DSLab.class.getDeclaredConstructors().length);
        assertEquals(19, Arrays.stream(DSLab.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, DSLab.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, DSLab.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("getDescription").getModifiers()));
            assertEquals(String.class, DSLab.class.getDeclaredMethod("getDescription").getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("setDescription", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("setDescription", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("setDescription", String.class).getModifiers()));
            assertEquals(void.class, DSLab.class.getDeclaredMethod("setDescription", String.class).getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("getVersionMajor").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("getVersionMajor").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("getVersionMajor").getModifiers()));
            assertEquals(int.class, DSLab.class.getDeclaredMethod("getVersionMajor").getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("setVersionMajor", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("setVersionMajor", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("setVersionMajor", int.class).getModifiers()));
            assertEquals(void.class, DSLab.class.getDeclaredMethod("setVersionMajor", int.class).getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("getVersionMinor").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("getVersionMinor").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("getVersionMinor").getModifiers()));
            assertEquals(int.class, DSLab.class.getDeclaredMethod("getVersionMinor").getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("setVersionMinor", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("setVersionMinor", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("setVersionMinor", int.class).getModifiers()));
            assertEquals(void.class, DSLab.class.getDeclaredMethod("setVersionMinor", int.class).getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("getVersionPatch").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("getVersionPatch").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("getVersionPatch").getModifiers()));
            assertEquals(int.class, DSLab.class.getDeclaredMethod("getVersionPatch").getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("setVersionPatch", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("setVersionPatch", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("setVersionPatch", int.class).getModifiers()));
            assertEquals(void.class, DSLab.class.getDeclaredMethod("setVersionPatch", int.class).getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("getVersion").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("getVersion").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("getVersion").getModifiers()));
            assertEquals(String.class, DSLab.class.getDeclaredMethod("getVersion").getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("getCpu").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("getCpu").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("getCpu").getModifiers()));
            assertEquals(long.class, DSLab.class.getDeclaredMethod("getCpu").getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("setCpu", long.class).getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("setCpu", long.class).getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("setCpu", long.class).getModifiers()));
            assertEquals(void.class, DSLab.class.getDeclaredMethod("setCpu", long.class).getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("getUniversity").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("getUniversity").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("getUniversity").getModifiers()));
            assertEquals(University.class, DSLab.class.getDeclaredMethod("getUniversity").getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("setUniversity", University.class).getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("setUniversity", University.class).getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("setUniversity", University.class).getModifiers()));
            assertEquals(void.class, DSLab.class.getDeclaredMethod("setUniversity", University.class).getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("getStatus").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("getStatus").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("getStatus").getModifiers()));
            assertEquals(DSLabStatus.class, DSLab.class.getDeclaredMethod("getStatus").getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("setStatus", DSLabStatus.class).getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("setStatus", DSLabStatus.class).getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("setStatus", DSLabStatus.class).getModifiers()));
            assertEquals(void.class, DSLab.class.getDeclaredMethod("setStatus", DSLabStatus.class).getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, DSLab.class.getDeclaredMethod("toString").getReturnType());

            assertTrue(Modifier.isPublic(DSLab.class.getDeclaredMethod("equals", Object.class).getModifiers()));
            assertFalse(Modifier.isStatic(DSLab.class.getDeclaredMethod("equals", Object.class).getModifiers()));
            assertFalse(Modifier.isFinal(DSLab.class.getDeclaredMethod("equals", Object.class).getModifiers()));
            assertEquals(boolean.class, DSLab.class.getDeclaredMethod("equals", Object.class).getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("DSLab creation - Valid parameters")
    void testDSLabCreationValidParameters() throws DSLabException, UniversityException {
        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39", "www.uoc.edu");
        DSLab dsLab = new DSLab("DSLab", "DSLab description", 1, 0, 0, 2_147_483_648L, university);

        assertEquals("DSLab", dsLab.getName());
        assertEquals("DSLab description", dsLab.getDescription());
        assertEquals(1, dsLab.getVersionMajor());
        assertEquals(0, dsLab.getVersionMinor());
        assertEquals(0, dsLab.getVersionPatch());
        assertEquals("1.0.0", dsLab.getVersion());
        assertEquals(2_147_483_648L, dsLab.getCpu());
        assertEquals(university, dsLab.getUniversity());
        assertEquals(DSLabStatus.ACTIVE, dsLab.getStatus());
    }

    @Test
    @Order(4)
    @DisplayName("DSLab creation - Name")
    void testDSLabCreationName() throws DSLabException, UniversityException {
        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39", "www.uoc.edu");

        DSLabException exception = assertThrows(DSLabException.class, () -> new DSLab(null, "DSLab description", 1, 0, 0, 2_147_483_648L, university));
        assertEquals("[ERROR] Name cannot be null, empty or blank", exception.getMessage());

        assertThrows(DSLabException.class, () -> new DSLab("", "DSLab description", 1, 0, 0, 2_147_483_648L, university));
        assertThrows(DSLabException.class, () -> new DSLab("  ", "DSLab description", 1, 0, 0, 2_147_483_648L, university));

        DSLab dsLab = new DSLab("DSLab", "DSLab description", 1, 0, 0, 2_147_483_648L, university);
        assertEquals("DSLab", dsLab.getName());

        dsLab.setName("DSLab 2");
        assertEquals("DSLab 2", dsLab.getName());

        dsLab.setName("   DSLab  ");
        assertEquals("DSLab", dsLab.getName());

        assertThrows(DSLabException.class, () -> dsLab.setName(null));
        assertThrows(DSLabException.class, () -> dsLab.setName(""));
        assertThrows(DSLabException.class, () -> dsLab.setName("  "));

        assertEquals("DSLab", dsLab.getName());
    }

    @Test
    @Order(5)
    @DisplayName("DSLab creation - Description")
    void testDSLabCreationDescription() throws DSLabException, UniversityException {
        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39", "www.uoc.edu");

        DSLabException exception = assertThrows(DSLabException.class, () -> new DSLab("DSLab", null, 1, 0, 0, 2_147_483_648L, university));
        assertEquals("[ERROR] Description cannot be null", exception.getMessage());

        DSLab dsLab = new DSLab("DSLab", "DSLab description", 1, 0, 0, 2_147_483_648L, university);
        assertEquals("DSLab description", dsLab.getDescription());

        dsLab.setDescription("DSLab description 2");
        assertEquals("DSLab description 2", dsLab.getDescription());

        dsLab.setDescription("   DSLab description  ");
        assertEquals("   DSLab description  ", dsLab.getDescription());

        assertThrows(DSLabException.class, () -> dsLab.setDescription(null));

        assertEquals("   DSLab description  ", dsLab.getDescription());
    }

    @Test
    @Order(6)
    @DisplayName("DSLab creation - Version major")
    void testDSLabCreationVersionMajor() throws DSLabException, UniversityException {
        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39", "www.uoc.edu");

        DSLabException exception = assertThrows(DSLabException.class, () -> new DSLab("DSLab", "DSLab description", -1, 0, 0, 2_147_483_648L, university));
        assertEquals("[ERROR] Major version cannot be negative", exception.getMessage());

        assertThrows(DSLabException.class, () -> new DSLab("DSLab", "DSLab description", -10, 0, 0, 2_147_483_648L, university));

        DSLab dsLab = new DSLab("DSLab", "DSLab description", 1, 0, 0, 2_147_483_648L, university);
        assertEquals(1, dsLab.getVersionMajor());

        dsLab.setVersionMajor(2);
        assertEquals(2, dsLab.getVersionMajor());

        assertThrows(DSLabException.class, () -> dsLab.setVersionMajor(-1));
        assertThrows(DSLabException.class, () -> dsLab.setVersionMajor(-10));

        assertEquals(2, dsLab.getVersionMajor());
    }

    @Test
    @Order(7)
    @DisplayName("DSLab creation - Version minor")
    void testDSLabCreationVersionMinor() throws DSLabException, UniversityException {
        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39", "www.uoc.edu");

        DSLabException exception = assertThrows(DSLabException.class, () -> new DSLab("DSLab", "DSLab description", 1, -1, 0, 2_147_483_648L, university));
        assertEquals("[ERROR] Minor version cannot be negative", exception.getMessage());

        assertThrows(DSLabException.class, () -> new DSLab("DSLab", "DSLab description", 1, -10, 0, 2_147_483_648L, university));

        DSLab dsLab = new DSLab("DSLab", "DSLab description", 1, 0, 0, 2_147_483_648L, university);
        assertEquals(0, dsLab.getVersionMinor());

        dsLab.setVersionMinor(2);
        assertEquals(2, dsLab.getVersionMinor());

        assertThrows(DSLabException.class, () -> dsLab.setVersionMinor(-1));
        assertThrows(DSLabException.class, () -> dsLab.setVersionMinor(-10));

        assertEquals(2, dsLab.getVersionMinor());
    }

    @Test
    @Order(8)
    @DisplayName("DSLab creation - Version patch")
    void testDSLabCreationVersionPatch() throws DSLabException, UniversityException {
        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39", "www.uoc.edu");

        DSLabException exception = assertThrows(DSLabException.class, () -> new DSLab("DSLab", "DSLab description", 1, 0, -1, 2_147_483_648L, university));
        assertEquals("[ERROR] Patch version cannot be negative", exception.getMessage());

        assertThrows(DSLabException.class, () -> new DSLab("DSLab", "DSLab description", 1, 0, -10, 2_147_483_648L, university));

        DSLab dsLab = new DSLab("DSLab", "DSLab description", 1, 0, 0, 2_147_483_648L, university);
        assertEquals(0, dsLab.getVersionPatch());

        dsLab.setVersionPatch(2);
        assertEquals(2, dsLab.getVersionPatch());

        assertThrows(DSLabException.class, () -> dsLab.setVersionPatch(-1));
        assertThrows(DSLabException.class, () -> dsLab.setVersionPatch(-10));

        assertEquals(2, dsLab.getVersionPatch());
    }

    @Test
    @Order(9)
    @DisplayName("DSLab creation - CPU")
    void testDSLabCreationCPU() throws DSLabException, UniversityException {
        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39", "www.uoc.edu");

        DSLabException exception = assertThrows(DSLabException.class, () -> new DSLab("DSLab", "DSLab description", 1, 0, 0, 0, university));
        assertEquals("[ERROR] This server does not have enough CPU", exception.getMessage());

        assertThrows(DSLabException.class, () -> new DSLab("DSLab", "DSLab description", 1, 0, 0, 1_073_741_823L, university));

        DSLab dsLab = new DSLab("DSLab", "DSLab description", 1, 0, 0, 1_073_741_824L, university);
        assertEquals(1_073_741_824L, dsLab.getCpu());

        dsLab.setCpu(4_294_967_296L);
        assertEquals(4_294_967_296L, dsLab.getCpu());

        assertThrows(DSLabException.class, () -> dsLab.setCpu(-1));
        assertThrows(DSLabException.class, () -> dsLab.setCpu(1_073_741_823L));

        assertEquals(4_294_967_296L, dsLab.getCpu());
    }

    @Test
    @Order(10)
    @DisplayName("DSLab creation - University")
    void testDSLabCreationUniversity() throws DSLabException, UniversityException {
        DSLabException exception = assertThrows(DSLabException.class, () -> new DSLab("DSLab", "DSLab description", 1, 0, 0, 2_147_483_648L, null));
        assertEquals("[ERROR] University cannot be null", exception.getMessage());

        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39", "www.uoc.edu");
        DSLab dsLab = new DSLab("DSLab", "DSLab description", 1, 0, 0, 2_147_483_648L, university);
        assertEquals(university, dsLab.getUniversity());

        University university2 = new University("Virtual University", "VU", LocalDate.of(1450, 3, 3), "Wirtland", "https://www.virtualuniversity.wirtland");
        dsLab.setUniversity(university2);
        assertEquals(university2, dsLab.getUniversity());

        assertThrows(DSLabException.class, () -> dsLab.setUniversity(null));

        assertEquals(university2, dsLab.getUniversity());
    }

    @Test
    @Order(11)
    @DisplayName("DSLab creation - Status")
    void testDSLabCreationStatus() throws DSLabException, UniversityException {
        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39", "www.uoc.edu");
        DSLab dsLab = new DSLab("DSLab", "DSLab description", 1, 0, 0, 2_147_483_648L, university);

        assertEquals(DSLabStatus.ACTIVE, dsLab.getStatus());

        dsLab.setStatus(DSLabStatus.INACTIVE);
        assertEquals(DSLabStatus.INACTIVE, dsLab.getStatus());

        dsLab.setStatus(DSLabStatus.ACTIVE);
        assertEquals(DSLabStatus.ACTIVE, dsLab.getStatus());

        dsLab.setStatus(DSLabStatus.MAINTENANCE);
        assertEquals(DSLabStatus.MAINTENANCE, dsLab.getStatus());
    }

    @Test
    @Order(12)
    @DisplayName("DSLab creation - Version")
    void testDSLabCreationVersion() throws DSLabException, UniversityException {
        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39", "www.uoc.edu");
        DSLab dsLab = new DSLab("DSLab", "DSLab description", 1, 2, 3, 2_147_483_648L, university);

        assertEquals("1.2.3", dsLab.getVersion());

        dsLab.setVersionMajor(2);
        assertEquals("2.2.3", dsLab.getVersion());

        dsLab.setVersionMinor(1);
        assertEquals("2.1.3", dsLab.getVersion());

        dsLab.setVersionPatch(1);
        assertEquals("2.1.1", dsLab.getVersion());
    }

}
