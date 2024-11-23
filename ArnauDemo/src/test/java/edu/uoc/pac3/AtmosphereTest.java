package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AtmosphereTest {

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsSanity() {
        assertEquals(10, Atmosphere.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(Atmosphere.class.getDeclaredField("INVALID_COMPOSITION").getModifiers()));
            assertTrue(Modifier.isStatic(Atmosphere.class.getDeclaredField("INVALID_COMPOSITION").getModifiers()));
            assertTrue(Modifier.isFinal(Atmosphere.class.getDeclaredField("INVALID_COMPOSITION").getModifiers()));
            assertEquals(String.class, Atmosphere.class.getDeclaredField("INVALID_COMPOSITION").getType());
            assertEquals("[ERROR] Composition cannot be null or empty", Atmosphere.INVALID_COMPOSITION);

            assertTrue(Modifier.isPublic(Atmosphere.class.getDeclaredField("INVALID_LAST_OBSERVATION").getModifiers()));
            assertTrue(Modifier.isStatic(Atmosphere.class.getDeclaredField("INVALID_LAST_OBSERVATION").getModifiers()));
            assertTrue(Modifier.isFinal(Atmosphere.class.getDeclaredField("INVALID_LAST_OBSERVATION").getModifiers()));
            assertEquals(String.class, Atmosphere.class.getDeclaredField("INVALID_LAST_OBSERVATION").getType());
            assertEquals("[ERROR] Last observation cannot be null or in the future", Atmosphere.INVALID_LAST_OBSERVATION);

            assertTrue(Modifier.isPublic(Atmosphere.class.getDeclaredField("INVALID_PRESSURE").getModifiers()));
            assertTrue(Modifier.isStatic(Atmosphere.class.getDeclaredField("INVALID_PRESSURE").getModifiers()));
            assertTrue(Modifier.isFinal(Atmosphere.class.getDeclaredField("INVALID_PRESSURE").getModifiers()));
            assertEquals(String.class, Atmosphere.class.getDeclaredField("INVALID_PRESSURE").getType());
            assertEquals("[ERROR] Pressure cannot be negative", Atmosphere.INVALID_PRESSURE);

            assertTrue(Modifier.isPublic(Atmosphere.class.getDeclaredField("INVALID_DENSITY").getModifiers()));
            assertTrue(Modifier.isStatic(Atmosphere.class.getDeclaredField("INVALID_DENSITY").getModifiers()));
            assertTrue(Modifier.isFinal(Atmosphere.class.getDeclaredField("INVALID_DENSITY").getModifiers()));
            assertEquals(String.class, Atmosphere.class.getDeclaredField("INVALID_DENSITY").getType());
            assertEquals("[ERROR] Density cannot be negative", Atmosphere.INVALID_DENSITY);

            assertTrue(Modifier.isPrivate(Atmosphere.class.getDeclaredField("composition").getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredField("composition").getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredField("composition").getModifiers()));
            assertEquals(String.class, Atmosphere.class.getDeclaredField("composition").getType());

            assertTrue(Modifier.isPrivate(Atmosphere.class.getDeclaredField("lastObservation").getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredField("lastObservation").getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredField("lastObservation").getModifiers()));
            assertEquals(LocalDate.class, Atmosphere.class.getDeclaredField("lastObservation").getType());

            assertTrue(Modifier.isPrivate(Atmosphere.class.getDeclaredField("airQuality").getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredField("airQuality").getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredField("airQuality").getModifiers()));
            assertEquals(int.class, Atmosphere.class.getDeclaredField("airQuality").getType());

            assertTrue(Modifier.isPrivate(Atmosphere.class.getDeclaredField("pressure").getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredField("pressure").getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredField("pressure").getModifiers()));
            assertEquals(double.class, Atmosphere.class.getDeclaredField("pressure").getType());

            assertTrue(Modifier.isPrivate(Atmosphere.class.getDeclaredField("density").getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredField("density").getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredField("density").getModifiers()));
            assertEquals(double.class, Atmosphere.class.getDeclaredField("density").getType());

            assertTrue(Modifier.isPrivate(Atmosphere.class.getDeclaredField("hasClouds").getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredField("hasClouds").getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredField("hasClouds").getModifiers()));
            assertEquals(boolean.class, Atmosphere.class.getDeclaredField("hasClouds").getType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Constructor definition")
    void checkConstructorSanity() {
        assertEquals(1, Atmosphere.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Atmosphere.class.getDeclaredConstructor(String.class, LocalDate.class, int.class, double.class, double.class, boolean.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(6, Arrays.stream(Atmosphere.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());
        assertEquals(6, Arrays.stream(Atmosphere.class.getDeclaredMethods()).filter(m -> Modifier.isPrivate(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(Atmosphere.class.getDeclaredMethod("getComposition").getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredMethod("getComposition").getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredMethod("getComposition").getModifiers()));
            assertEquals(String.class, Atmosphere.class.getDeclaredMethod("getComposition").getReturnType());

            assertTrue(Modifier.isPrivate(Atmosphere.class.getDeclaredMethod("setComposition", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredMethod("setComposition", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredMethod("setComposition", String.class).getModifiers()));
            assertEquals(void.class, Atmosphere.class.getDeclaredMethod("setComposition", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Atmosphere.class.getDeclaredMethod("getLastObservation").getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredMethod("getLastObservation").getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredMethod("getLastObservation").getModifiers()));
            assertEquals(LocalDate.class, Atmosphere.class.getDeclaredMethod("getLastObservation").getReturnType());

            assertTrue(Modifier.isPrivate(Atmosphere.class.getDeclaredMethod("setLastObservation", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredMethod("setLastObservation", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredMethod("setLastObservation", LocalDate.class).getModifiers()));
            assertEquals(void.class, Atmosphere.class.getDeclaredMethod("setLastObservation", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(Atmosphere.class.getDeclaredMethod("getAirQuality").getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredMethod("getAirQuality").getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredMethod("getAirQuality").getModifiers()));
            assertEquals(int.class, Atmosphere.class.getDeclaredMethod("getAirQuality").getReturnType());

            assertTrue(Modifier.isPrivate(Atmosphere.class.getDeclaredMethod("setAirQuality", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredMethod("setAirQuality", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredMethod("setAirQuality", int.class).getModifiers()));
            assertEquals(void.class, Atmosphere.class.getDeclaredMethod("setAirQuality", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Atmosphere.class.getDeclaredMethod("getPressure").getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredMethod("getPressure").getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredMethod("getPressure").getModifiers()));
            assertEquals(double.class, Atmosphere.class.getDeclaredMethod("getPressure").getReturnType());

            assertTrue(Modifier.isPrivate(Atmosphere.class.getDeclaredMethod("setPressure", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredMethod("setPressure", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredMethod("setPressure", double.class).getModifiers()));
            assertEquals(void.class, Atmosphere.class.getDeclaredMethod("setPressure", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Atmosphere.class.getDeclaredMethod("getDensity").getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredMethod("getDensity").getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredMethod("getDensity").getModifiers()));
            assertEquals(double.class, Atmosphere.class.getDeclaredMethod("getDensity").getReturnType());

            assertTrue(Modifier.isPrivate(Atmosphere.class.getDeclaredMethod("setDensity", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredMethod("setDensity", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredMethod("setDensity", double.class).getModifiers()));
            assertEquals(void.class, Atmosphere.class.getDeclaredMethod("setDensity", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Atmosphere.class.getDeclaredMethod("hasClouds").getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredMethod("hasClouds").getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredMethod("hasClouds").getModifiers()));
            assertEquals(boolean.class, Atmosphere.class.getDeclaredMethod("hasClouds").getReturnType());

            assertTrue(Modifier.isPrivate(Atmosphere.class.getDeclaredMethod("setHasClouds", boolean.class).getModifiers()));
            assertFalse(Modifier.isStatic(Atmosphere.class.getDeclaredMethod("setHasClouds", boolean.class).getModifiers()));
            assertFalse(Modifier.isFinal(Atmosphere.class.getDeclaredMethod("setHasClouds", boolean.class).getModifiers()));
            assertEquals(void.class, Atmosphere.class.getDeclaredMethod("setHasClouds", boolean.class).getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @DisplayName("Atmosphere creation - Valid parameters")
    void testCreateAtmosphere() {
        Atmosphere atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 100, 1.0, 1.225, true);

        assertNotNull(atmosphere);
        assertEquals("N, O, Ar, CO2", atmosphere.getComposition());
        assertEquals(LocalDate.now(), atmosphere.getLastObservation());
        assertEquals(100, atmosphere.getAirQuality());
        assertEquals(1.0, atmosphere.getPressure());
        assertEquals(1.225, atmosphere.getDensity());
        assertTrue(atmosphere.hasClouds());
    }

    @Test
    @Order(5)
    @DisplayName("Atmosphere creation - Composition")
    void testCreateAtmosphereComposition() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Atmosphere(null, LocalDate.now(), 100, 1.0, 1.225, true));

        assertEquals(Atmosphere.INVALID_COMPOSITION, exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new Atmosphere("", LocalDate.now(), 100, 1.0, 1.225, true));
        assertThrows(IllegalArgumentException.class, () -> new Atmosphere("  ", LocalDate.now(), 100, 1.0, 1.225, true));
        assertThrows(IllegalArgumentException.class, () -> new Atmosphere("N?, O, Ar, CO2", LocalDate.now(), 100, 1.0, 1.225, true));
        assertThrows(IllegalArgumentException.class, () -> new Atmosphere("N|O|Ar|CO2", LocalDate.now(), 100, 1.0, 1.225, true));
        assertThrows(IllegalArgumentException.class, () -> new Atmosphere("O2, CO2, H2O!", LocalDate.now(), 100, 1.0, 1.225, true));
        assertThrows(IllegalArgumentException.class, () -> new Atmosphere("N2*H2", LocalDate.now(), 100, 1.0, 1.225, true));
        assertThrows(IllegalArgumentException.class, () -> new Atmosphere("H@O", LocalDate.now(), 100, 1.0, 1.225, true));
        assertThrows(IllegalArgumentException.class, () -> new Atmosphere("N?, O, Ar, CO2.", LocalDate.now(), 100, 1.0, 1.225, true));
        assertThrows(IllegalArgumentException.class, () -> new Atmosphere("N?, O, Ar, CO2.", LocalDate.now(), 100, 1.0, 1.225, true));

        Atmosphere atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 100, 1.0, 1.225, true);
        assertNotNull(atmosphere);
        assertEquals("N, O, Ar, CO2", atmosphere.getComposition());

        atmosphere = new Atmosphere("N, O, Ar, CO2, H2O", LocalDate.now(), 100, 1.0, 1.225, true);
        assertNotNull(atmosphere);
        assertEquals("N, O, Ar, CO2, H2O", atmosphere.getComposition());

        atmosphere = new Atmosphere("N", LocalDate.now(), 100, 1.0, 1.225, true);
        assertNotNull(atmosphere);
        assertEquals("N", atmosphere.getComposition());
    }

    @Test
    @Order(6)
    @DisplayName("Atmosphere creation - Last observation")
    void testCreateAtmosphereLastObservation() {
        assertThrows(IllegalArgumentException.class, () -> new Atmosphere("N, O, Ar, CO2", null, 100, 1.0, 1.225, true));
        assertThrows(IllegalArgumentException.class, () -> new Atmosphere("N, O, Ar, CO2", LocalDate.now().plusDays(1), 100, 1.0, 1.225, true));

        Atmosphere atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 100, 1.0, 1.225, true);
        assertNotNull(atmosphere);
        assertEquals(LocalDate.now(), atmosphere.getLastObservation());

        atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now().minusDays(1), 100, 1.0, 1.225, true);
        assertNotNull(atmosphere);
        assertEquals(LocalDate.now().minusDays(1), atmosphere.getLastObservation());
    }

    @Test
    @Order(7)
    @DisplayName("Atmosphere creation - Air quality")
    void testCreateAtmosphereAirQuality() {
        Atmosphere atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 0, 1.0, 1.225, true);
        assertNotNull(atmosphere);
        assertEquals(0, atmosphere.getAirQuality());

        atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 100, 1.0, 1.225, true);
        assertNotNull(atmosphere);
        assertEquals(100, atmosphere.getAirQuality());

        atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 50, 1.0, 1.225, true);
        assertNotNull(atmosphere);
        assertEquals(50, atmosphere.getAirQuality());

        atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 101, 1.0, 1.225, true);
        assertNotNull(atmosphere);
        assertEquals(100, atmosphere.getAirQuality());

        atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now(), -1, 1.0, 1.225, true);
        assertNotNull(atmosphere);
        assertEquals(0, atmosphere.getAirQuality());
    }

    @Test
    @Order(8)
    @DisplayName("Atmosphere creation - Pressure")
    void testCreateAtmospherePressure() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 100, -0.1, 1.225, true));

        assertEquals(Atmosphere.INVALID_PRESSURE, exception.getMessage());

        Atmosphere atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 100, 0.0, 1.225, true);
        assertNotNull(atmosphere);
        assertEquals(0.0, atmosphere.getPressure());

        atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 100, 1.0, 1.225, true);
        assertNotNull(atmosphere);
        assertEquals(1.0, atmosphere.getPressure());

        atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 100, 9.9, 1.225, true);
        assertNotNull(atmosphere);
        assertEquals(9.9, atmosphere.getPressure());
    }

    @Test
    @Order(9)
    @DisplayName("Atmosphere creation - Density")
    void testCreateAtmosphereDensity() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 100, 1.0, -0.1, true));

        assertEquals(Atmosphere.INVALID_DENSITY, exception.getMessage());

        Atmosphere atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 100, 1.0, 0.0, true);
        assertNotNull(atmosphere);
        assertEquals(0.0, atmosphere.getDensity());

        atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 100, 1.0, 1.225, true);
        assertNotNull(atmosphere);
        assertEquals(1.225, atmosphere.getDensity());

        atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 100, 1.0, 9.9, true);
        assertNotNull(atmosphere);
        assertEquals(9.9, atmosphere.getDensity());
    }

    @Test
    @Order(10)
    @DisplayName("Atmosphere creation - Has clouds")
    void testCreateAtmosphereHasClouds() {
        Atmosphere atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 100, 1.0, 1.225, true);
        assertNotNull(atmosphere);
        assertTrue(atmosphere.hasClouds());

        atmosphere = new Atmosphere("N, O, Ar, CO2", LocalDate.now(), 100, 1.0, 1.225, false);
        assertNotNull(atmosphere);
        assertFalse(atmosphere.hasClouds());
    }

}
