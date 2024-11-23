package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlanetTest {

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsSanity() {
        assertEquals(16, Planet.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(Planet.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(Planet.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(Planet.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertEquals(String.class, Planet.class.getDeclaredField("INVALID_NAME").getType());
            assertEquals("[ERROR] Name cannot be null or empty", Planet.INVALID_NAME);

            assertTrue(Modifier.isPublic(Planet.class.getDeclaredField("INVALID_NUMBER_OF_MOONS").getModifiers()));
            assertTrue(Modifier.isStatic(Planet.class.getDeclaredField("INVALID_NUMBER_OF_MOONS").getModifiers()));
            assertTrue(Modifier.isFinal(Planet.class.getDeclaredField("INVALID_NUMBER_OF_MOONS").getModifiers()));
            assertEquals(String.class, Planet.class.getDeclaredField("INVALID_NUMBER_OF_MOONS").getType());
            assertEquals("[ERROR] Number of moons cannot be negative", Planet.INVALID_NUMBER_OF_MOONS);

            assertTrue(Modifier.isPublic(Planet.class.getDeclaredField("INVALID_MASS").getModifiers()));
            assertTrue(Modifier.isStatic(Planet.class.getDeclaredField("INVALID_MASS").getModifiers()));
            assertTrue(Modifier.isFinal(Planet.class.getDeclaredField("INVALID_MASS").getModifiers()));
            assertEquals(String.class, Planet.class.getDeclaredField("INVALID_MASS").getType());
            assertEquals("[ERROR] Mass cannot be less than 10e23 kg", Planet.INVALID_MASS);

            assertTrue(Modifier.isPublic(Planet.class.getDeclaredField("INVALID_RADIUS").getModifiers()));
            assertTrue(Modifier.isStatic(Planet.class.getDeclaredField("INVALID_RADIUS").getModifiers()));
            assertTrue(Modifier.isFinal(Planet.class.getDeclaredField("INVALID_RADIUS").getModifiers()));
            assertEquals(String.class, Planet.class.getDeclaredField("INVALID_RADIUS").getType());
            assertEquals("[ERROR] Radius cannot be less than 500 km", Planet.INVALID_RADIUS);

            assertTrue(Modifier.isPublic(Planet.class.getDeclaredField("INVALID_GRAVITY").getModifiers()));
            assertTrue(Modifier.isStatic(Planet.class.getDeclaredField("INVALID_GRAVITY").getModifiers()));
            assertTrue(Modifier.isFinal(Planet.class.getDeclaredField("INVALID_GRAVITY").getModifiers()));
            assertEquals(String.class, Planet.class.getDeclaredField("INVALID_GRAVITY").getType());
            assertEquals("[ERROR] Gravity cannot be negative or zero", Planet.INVALID_GRAVITY);

            assertTrue(Modifier.isPublic(Planet.class.getDeclaredField("INVALID_LAST_ALBEDO_MEASUREMENT").getModifiers()));
            assertTrue(Modifier.isStatic(Planet.class.getDeclaredField("INVALID_LAST_ALBEDO_MEASUREMENT").getModifiers()));
            assertTrue(Modifier.isFinal(Planet.class.getDeclaredField("INVALID_LAST_ALBEDO_MEASUREMENT").getModifiers()));
            assertEquals(String.class, Planet.class.getDeclaredField("INVALID_LAST_ALBEDO_MEASUREMENT").getType());
            assertEquals("[ERROR] Last albedo measurement cannot be null or in the future", Planet.INVALID_LAST_ALBEDO_MEASUREMENT);

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredField("MIN_MASS").getModifiers()));
            assertTrue(Modifier.isStatic(Planet.class.getDeclaredField("MIN_MASS").getModifiers()));
            assertTrue(Modifier.isFinal(Planet.class.getDeclaredField("MIN_MASS").getModifiers()));
            assertEquals(double.class, Planet.class.getDeclaredField("MIN_MASS").getType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredField("MIN_RADIUS").getModifiers()));
            assertTrue(Modifier.isStatic(Planet.class.getDeclaredField("MIN_RADIUS").getModifiers()));
            assertTrue(Modifier.isFinal(Planet.class.getDeclaredField("MIN_RADIUS").getModifiers()));
            assertEquals(double.class, Planet.class.getDeclaredField("MIN_RADIUS").getType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, Planet.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredField("numberOfMoons").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredField("numberOfMoons").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredField("numberOfMoons").getModifiers()));
            assertEquals(int.class, Planet.class.getDeclaredField("numberOfMoons").getType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredField("mass").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredField("mass").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredField("mass").getModifiers()));
            assertEquals(double.class, Planet.class.getDeclaredField("mass").getType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredField("radius").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredField("radius").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredField("radius").getModifiers()));
            assertEquals(double.class, Planet.class.getDeclaredField("radius").getType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredField("gravity").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredField("gravity").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredField("gravity").getModifiers()));
            assertEquals(double.class, Planet.class.getDeclaredField("gravity").getType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredField("lastAlbedoMeasurement").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredField("lastAlbedoMeasurement").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredField("lastAlbedoMeasurement").getModifiers()));
            assertEquals(LocalDate.class, Planet.class.getDeclaredField("lastAlbedoMeasurement").getType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredField("hasRings").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredField("hasRings").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredField("hasRings").getModifiers()));
            assertEquals(boolean.class, Planet.class.getDeclaredField("hasRings").getType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredField("atmosphere").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredField("atmosphere").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredField("atmosphere").getModifiers()));
            assertEquals(Atmosphere.class, Planet.class.getDeclaredField("atmosphere").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Constructors")
    void checkConstructorsSanity() {
        assertEquals(2, Planet.class.getConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Planet.class.getDeclaredConstructor(String.class, int.class, double.class, double.class, double.class, LocalDate.class, boolean.class).getModifiers()));
            assertTrue(Modifier.isPublic(Planet.class.getDeclaredConstructor(String.class, int.class, double.class, double.class, double.class, LocalDate.class, boolean.class, String.class, LocalDate.class, int.class, double.class, double.class, boolean.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(8, Arrays.stream(Planet.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());
        assertEquals(8, Arrays.stream(Planet.class.getDeclaredMethods()).filter(m -> Modifier.isPrivate(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(Planet.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, Planet.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, Planet.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Planet.class.getDeclaredMethod("getNumberOfMoons").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("getNumberOfMoons").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("getNumberOfMoons").getModifiers()));
            assertEquals(int.class, Planet.class.getDeclaredMethod("getNumberOfMoons").getReturnType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredMethod("setNumberOfMoons", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("setNumberOfMoons", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("setNumberOfMoons", int.class).getModifiers()));
            assertEquals(void.class, Planet.class.getDeclaredMethod("setNumberOfMoons", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Planet.class.getDeclaredMethod("getMass").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("getMass").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("getMass").getModifiers()));
            assertEquals(double.class, Planet.class.getDeclaredMethod("getMass").getReturnType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredMethod("setMass", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("setMass", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("setMass", double.class).getModifiers()));
            assertEquals(void.class, Planet.class.getDeclaredMethod("setMass", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Planet.class.getDeclaredMethod("getRadius").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("getRadius").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("getRadius").getModifiers()));
            assertEquals(double.class, Planet.class.getDeclaredMethod("getRadius").getReturnType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredMethod("setRadius", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("setRadius", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("setRadius", double.class).getModifiers()));
            assertEquals(void.class, Planet.class.getDeclaredMethod("setRadius", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Planet.class.getDeclaredMethod("getGravity").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("getGravity").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("getGravity").getModifiers()));
            assertEquals(double.class, Planet.class.getDeclaredMethod("getGravity").getReturnType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredMethod("setGravity", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("setGravity", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("setGravity", double.class).getModifiers()));
            assertEquals(void.class, Planet.class.getDeclaredMethod("setGravity", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Planet.class.getDeclaredMethod("getLastAlbedoMeasurement").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("getLastAlbedoMeasurement").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("getLastAlbedoMeasurement").getModifiers()));
            assertEquals(LocalDate.class, Planet.class.getDeclaredMethod("getLastAlbedoMeasurement").getReturnType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredMethod("setLastAlbedoMeasurement", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("setLastAlbedoMeasurement", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("setLastAlbedoMeasurement", LocalDate.class).getModifiers()));
            assertEquals(void.class, Planet.class.getDeclaredMethod("setLastAlbedoMeasurement", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(Planet.class.getDeclaredMethod("hasRings").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("hasRings").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("hasRings").getModifiers()));
            assertEquals(boolean.class, Planet.class.getDeclaredMethod("hasRings").getReturnType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredMethod("setHasRings", boolean.class).getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("setHasRings", boolean.class).getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("setHasRings", boolean.class).getModifiers()));
            assertEquals(void.class, Planet.class.getDeclaredMethod("setHasRings", boolean.class).getReturnType());

            assertTrue(Modifier.isPublic(Planet.class.getDeclaredMethod("getAtmosphere").getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("getAtmosphere").getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("getAtmosphere").getModifiers()));
            assertEquals(Atmosphere.class, Planet.class.getDeclaredMethod("getAtmosphere").getReturnType());

            assertTrue(Modifier.isPrivate(Planet.class.getDeclaredMethod("setAtmosphere", String.class, LocalDate.class, int.class, double.class, double.class, boolean.class).getModifiers()));
            assertFalse(Modifier.isStatic(Planet.class.getDeclaredMethod("setAtmosphere", String.class, LocalDate.class, int.class, double.class, double.class, boolean.class).getModifiers()));
            assertFalse(Modifier.isFinal(Planet.class.getDeclaredMethod("setAtmosphere", String.class, LocalDate.class, int.class, double.class, double.class, boolean.class).getModifiers()));
            assertEquals(void.class, Planet.class.getDeclaredMethod("setAtmosphere", String.class, LocalDate.class, int.class, double.class, double.class, boolean.class).getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @DisplayName("Planet creation - Valid parameters")
    void testCreatePlanet() {
        Planet planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false);

        assertNotNull(planet);
        assertEquals("Mars", planet.getName());
        assertEquals(2, planet.getNumberOfMoons());
        assertEquals(6.39e23, planet.getMass());
        assertEquals(3.3895e6, planet.getRadius());
        assertEquals(3.71, planet.getGravity());
        assertEquals(LocalDate.of(2021, 1, 1), planet.getLastAlbedoMeasurement());
        assertFalse(planet.hasRings());
        assertNull(planet.getAtmosphere());

        planet = new Planet("Earth", 1, 5.972e24, 6.371e6, 9.81, LocalDate.of(2024, 1, 1), false, "N, O, Ar, CO2", LocalDate.now(), 100, 1.0, 1.225, true);

        assertNotNull(planet);
        assertEquals("Earth", planet.getName());
        assertEquals(1, planet.getNumberOfMoons());
        assertEquals(5.972e24, planet.getMass());
        assertEquals(6.371e6, planet.getRadius());
        assertEquals(9.81, planet.getGravity());
        assertEquals(LocalDate.of(2024, 1, 1), planet.getLastAlbedoMeasurement());
        assertFalse(planet.hasRings());

        assertNotNull(planet.getAtmosphere());
        assertEquals("N, O, Ar, CO2", planet.getAtmosphere().getComposition());
        assertEquals(LocalDate.now(), planet.getAtmosphere().getLastObservation());
        assertEquals(100, planet.getAtmosphere().getAirQuality());
        assertEquals(1.0, planet.getAtmosphere().getPressure());
        assertEquals(1.225, planet.getAtmosphere().getDensity());
        assertTrue(planet.getAtmosphere().hasClouds());
    }

    @Test
    @Order(5)
    @DisplayName("Planet creation - Name")
    void testCreatePlanetName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Planet(null, 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false));

        assertEquals(Planet.INVALID_NAME, exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new Planet("", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false));
        assertThrows(IllegalArgumentException.class, () -> new Planet(" ", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false));

        Planet planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false);

        assertNotNull(planet);
        assertEquals("Mars", planet.getName());
    }

    @Test
    @Order(6)
    @DisplayName("Planet creation - Number of moons")
    void testCreatePlanetNumberOfMoons() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Planet("Mars", -1, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false));

        assertEquals(Planet.INVALID_NUMBER_OF_MOONS, exception.getMessage());

        Planet planet = new Planet("Mars", 0, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false);

        assertNotNull(planet);
        assertEquals(0, planet.getNumberOfMoons());

        planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false);

        assertNotNull(planet);
        assertEquals(2, planet.getNumberOfMoons());
    }

    @Test
    @Order(7)
    @DisplayName("Planet creation - Mass")
    void testCreatePlanetMass() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Planet("Mars", 2, -0.1, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false));

        assertEquals(Planet.INVALID_MASS, exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new Planet("Mars", 2, 0.0, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false));
        assertThrows(IllegalArgumentException.class, () -> new Planet("Mars", 2, 5.96e22, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false));

        Planet planet = new Planet("Mars", 2, 5.97e22, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false);

        assertNotNull(planet);
        assertEquals(5.97e22, planet.getMass());

        planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false);

        assertNotNull(planet);
        assertEquals(6.39e23, planet.getMass());
    }

    @Test
    @Order(8)
    @DisplayName("Planet creation - Radius")
    void testCreatePlanetRadius() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Planet("Mars", 2, 6.39e23, -0.1, 3.71, LocalDate.of(2021, 1, 1), false));

        assertEquals(Planet.INVALID_RADIUS, exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new Planet("Mars", 2, 6.39e23, 0.0, 3.71, LocalDate.of(2021, 1, 1), false));
        assertThrows(IllegalArgumentException.class, () -> new Planet("Mars", 2, 6.39e23, 499.9, 3.71, LocalDate.of(2021, 1, 1), false));

        Planet planet = new Planet("Mars", 2, 6.39e23, 500.0, 3.71, LocalDate.of(2021, 1, 1), false);

        assertNotNull(planet);
        assertEquals(500.0, planet.getRadius());

        planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false);

        assertNotNull(planet);
        assertEquals(3.3895e6, planet.getRadius());
    }

    @Test
    @Order(9)
    @DisplayName("Planet creation - Gravity")
    void testCreatePlanetGravity() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Planet("Mars", 2, 6.39e23, 3.3895e6, -0.1, LocalDate.of(2021, 1, 1), false));

        assertEquals(Planet.INVALID_GRAVITY, exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new Planet("Mars", 2, 6.39e23, 3.3895e6, 0.0, LocalDate.of(2021, 1, 1), false));

        Planet planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 0.01, LocalDate.of(2021, 1, 1), false);

        assertNotNull(planet);
        assertEquals(0.01, planet.getGravity());

        planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false);

        assertNotNull(planet);
        assertEquals(3.71, planet.getGravity());
    }

    @Test
    @Order(10)
    @DisplayName("Planet creation - Last albedo measurement")
    void testCreatePlanetLastAlbedoMeasurement() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, null, false));

        assertEquals(Planet.INVALID_LAST_ALBEDO_MEASUREMENT, exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.now().plusDays(1), false));

        Planet planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.now(), false);

        assertNotNull(planet);
        assertEquals(LocalDate.now(), planet.getLastAlbedoMeasurement());

        planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.now().minusDays(1), false);

        assertNotNull(planet);
        assertEquals(LocalDate.now().minusDays(1), planet.getLastAlbedoMeasurement());

        planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false);

        assertNotNull(planet);
        assertEquals(LocalDate.of(2021, 1, 1), planet.getLastAlbedoMeasurement());
    }

    @Test
    @Order(11)
    @DisplayName("Planet creation - Has rings")
    void testCreatePlanetHasRings() {
        Planet planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false);

        assertNotNull(planet);
        assertFalse(planet.hasRings());

        planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), true);

        assertNotNull(planet);
        assertTrue(planet.hasRings());
    }

    @Test
    @Order(12)
    @DisplayName("Planet creation - Atmosphere")
    void testCreatePlanetAtmosphere() {
        Planet planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false, null, LocalDate.now(), 100, 1.0, 1.225, true);

        assertNotNull(planet);
        assertNull(planet.getAtmosphere());

        planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false, "", LocalDate.now(), 100, 1.0, 1.225, true);

        assertNotNull(planet);
        assertNull(planet.getAtmosphere());

        planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false, " ", LocalDate.now(), 100, 1.0, 1.225, true);

        assertNotNull(planet);
        assertNull(planet.getAtmosphere());

        planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false, "CO2, N2, Ar!", LocalDate.now(), 100, 1.0, 1.225, true);

        assertNotNull(planet);
        assertNull(planet.getAtmosphere());

        planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false, "CO2, N2, Ar", null, 100, 1.0, 1.225, true);

        assertNotNull(planet);
        assertNull(planet.getAtmosphere());

        planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false, "CO2, N2, Ar", LocalDate.now().plusDays(1), 100, 1.0, 1.225, true);

        assertNotNull(planet);
        assertNull(planet.getAtmosphere());

        planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false, "CO2, N2, Ar", LocalDate.now(), 100, -0.1, 1.225, true);

        assertNotNull(planet);
        assertNull(planet.getAtmosphere());

        planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false, "CO2, N2, Ar", LocalDate.now(), 100, 1.0, -0.1, true);

        assertNotNull(planet);
        assertNull(planet.getAtmosphere());

        planet = new Planet("Mars", 2, 6.39e23, 3.3895e6, 3.71, LocalDate.of(2021, 1, 1), false, "CO2, N2, Ar", LocalDate.now(), 100, 1.0, 1.225, true);

        assertNotNull(planet);
        assertNotNull(planet.getAtmosphere());
        assertEquals("CO2, N2, Ar", planet.getAtmosphere().getComposition());
        assertEquals(LocalDate.now(), planet.getAtmosphere().getLastObservation());
        assertEquals(100, planet.getAtmosphere().getAirQuality());
        assertEquals(1.0, planet.getAtmosphere().getPressure());
        assertEquals(1.225, planet.getAtmosphere().getDensity());
        assertTrue(planet.getAtmosphere().hasClouds());
    }

}
