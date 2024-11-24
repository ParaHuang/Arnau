package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SolarSystemTest {

    @BeforeAll
    public static void init() throws NoSuchFieldException, IllegalAccessException {
        Field nextIdField = SolarSystem.class.getDeclaredField("nextId");
        nextIdField.setAccessible(true);
        nextIdField.set(null, 1);
    }

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsSanity() {
        assertEquals(21, SolarSystem.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(SolarSystem.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(SolarSystem.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertEquals(String.class, SolarSystem.class.getDeclaredField("INVALID_NAME").getType());
            assertEquals("[ERROR] Name cannot be null, contain only spaces or have less than 3 characters", SolarSystem.INVALID_NAME);

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredField("INVALID_NUMBER_OF_STARS").getModifiers()));
            assertTrue(Modifier.isStatic(SolarSystem.class.getDeclaredField("INVALID_NUMBER_OF_STARS").getModifiers()));
            assertTrue(Modifier.isFinal(SolarSystem.class.getDeclaredField("INVALID_NUMBER_OF_STARS").getModifiers()));
            assertEquals(String.class, SolarSystem.class.getDeclaredField("INVALID_NUMBER_OF_STARS").getType());
            assertEquals("[ERROR] Number of stars cannot be less than 1", SolarSystem.INVALID_NUMBER_OF_STARS);

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredField("INVALID_RADIUS").getModifiers()));
            assertTrue(Modifier.isStatic(SolarSystem.class.getDeclaredField("INVALID_RADIUS").getModifiers()));
            assertTrue(Modifier.isFinal(SolarSystem.class.getDeclaredField("INVALID_RADIUS").getModifiers()));
            assertEquals(String.class, SolarSystem.class.getDeclaredField("INVALID_RADIUS").getType());
            assertEquals("[ERROR] Radius cannot be less or equal to 0", SolarSystem.INVALID_RADIUS);

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredField("INVALID_REGISTRATION_DATE").getModifiers()));
            assertTrue(Modifier.isStatic(SolarSystem.class.getDeclaredField("INVALID_REGISTRATION_DATE").getModifiers()));
            assertTrue(Modifier.isFinal(SolarSystem.class.getDeclaredField("INVALID_REGISTRATION_DATE").getModifiers()));
            assertEquals(String.class, SolarSystem.class.getDeclaredField("INVALID_REGISTRATION_DATE").getType());
            assertEquals("[ERROR] Registration date cannot be null or in the future", SolarSystem.INVALID_REGISTRATION_DATE);

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredField("INVALID_LAST_PLANET_ADDED").getModifiers()));
            assertTrue(Modifier.isStatic(SolarSystem.class.getDeclaredField("INVALID_LAST_PLANET_ADDED").getModifiers()));
            assertTrue(Modifier.isFinal(SolarSystem.class.getDeclaredField("INVALID_LAST_PLANET_ADDED").getModifiers()));
            assertEquals(String.class, SolarSystem.class.getDeclaredField("INVALID_LAST_PLANET_ADDED").getType());
            assertEquals("[ERROR] Last planet date added cannot be in the future", SolarSystem.INVALID_LAST_PLANET_ADDED);

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredField("INVALID_MAX_PLANETS").getModifiers()));
            assertTrue(Modifier.isStatic(SolarSystem.class.getDeclaredField("INVALID_MAX_PLANETS").getModifiers()));
            assertTrue(Modifier.isFinal(SolarSystem.class.getDeclaredField("INVALID_MAX_PLANETS").getModifiers()));
            assertEquals(String.class, SolarSystem.class.getDeclaredField("INVALID_MAX_PLANETS").getType());
            assertEquals("[ERROR] Maximum number of planets reached", SolarSystem.INVALID_MAX_PLANETS);

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredField("PLANET_NULL").getModifiers()));
            assertTrue(Modifier.isStatic(SolarSystem.class.getDeclaredField("PLANET_NULL").getModifiers()));
            assertTrue(Modifier.isFinal(SolarSystem.class.getDeclaredField("PLANET_NULL").getModifiers()));
            assertEquals(String.class, SolarSystem.class.getDeclaredField("PLANET_NULL").getType());
            assertEquals("[ERROR] Planet cannot be null", SolarSystem.PLANET_NULL);

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredField("PLANET_ALREADY_EXISTS").getModifiers()));
            assertTrue(Modifier.isStatic(SolarSystem.class.getDeclaredField("PLANET_ALREADY_EXISTS").getModifiers()));
            assertTrue(Modifier.isFinal(SolarSystem.class.getDeclaredField("PLANET_ALREADY_EXISTS").getModifiers()));
            assertEquals(String.class, SolarSystem.class.getDeclaredField("PLANET_ALREADY_EXISTS").getType());
            assertEquals("[ERROR] This planet already exists", SolarSystem.PLANET_ALREADY_EXISTS);

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredField("PLANET_NOT_FOUND").getModifiers()));
            assertTrue(Modifier.isStatic(SolarSystem.class.getDeclaredField("PLANET_NOT_FOUND").getModifiers()));
            assertTrue(Modifier.isFinal(SolarSystem.class.getDeclaredField("PLANET_NOT_FOUND").getModifiers()));
            assertEquals(String.class, SolarSystem.class.getDeclaredField("PLANET_NOT_FOUND").getType());
            assertEquals("[ERROR] This planet does not exist", SolarSystem.PLANET_NOT_FOUND);

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(SolarSystem.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(SolarSystem.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertEquals(int.class, SolarSystem.class.getDeclaredField("MIN_NAME_LENGTH").getType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredField("MAX_PLANETS").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredField("MAX_PLANETS").getModifiers()));
            assertTrue(Modifier.isFinal(SolarSystem.class.getDeclaredField("MAX_PLANETS").getModifiers()));
            assertEquals(int.class, SolarSystem.class.getDeclaredField("MAX_PLANETS").getType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredField("id").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredField("id").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredField("id").getModifiers()));
            assertEquals(int.class, SolarSystem.class.getDeclaredField("id").getType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredField("nextId").getModifiers()));
            assertTrue(Modifier.isStatic(SolarSystem.class.getDeclaredField("nextId").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredField("nextId").getModifiers()));
            assertEquals(int.class, SolarSystem.class.getDeclaredField("nextId").getType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, SolarSystem.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredField("numberOfStars").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredField("numberOfStars").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredField("numberOfStars").getModifiers()));
            assertEquals(int.class, SolarSystem.class.getDeclaredField("numberOfStars").getType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredField("radius").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredField("radius").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredField("radius").getModifiers()));
            assertEquals(double.class, SolarSystem.class.getDeclaredField("radius").getType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredField("registrationDate").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredField("registrationDate").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredField("registrationDate").getModifiers()));
            assertEquals(LocalDate.class, SolarSystem.class.getDeclaredField("registrationDate").getType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredField("lastPlanetAdded").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredField("lastPlanetAdded").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredField("lastPlanetAdded").getModifiers()));
            assertEquals(LocalDate.class, SolarSystem.class.getDeclaredField("lastPlanetAdded").getType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredField("planets").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredField("planets").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredField("planets").getModifiers()));
            assertEquals(Planet[].class, SolarSystem.class.getDeclaredField("planets").getType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredField("numPlanets").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredField("numPlanets").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredField("numPlanets").getModifiers()));
            assertEquals(int.class, SolarSystem.class.getDeclaredField("numPlanets").getType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredField("sumMoons").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredField("sumMoons").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredField("sumMoons").getModifiers()));
            assertEquals(int.class, SolarSystem.class.getDeclaredField("sumMoons").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Constructors definition")
    void checkConstructorsSanity() {
        assertEquals(1, SolarSystem.class.getConstructors().length);

        try {
            assertTrue(Modifier.isPublic(SolarSystem.class.getConstructor(String.class, int.class, double.class, LocalDate.class, int.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(15, Arrays.stream(SolarSystem.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());
        assertEquals(9, Arrays.stream(SolarSystem.class.getDeclaredMethods()).filter(m -> Modifier.isPrivate(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredMethod("getId").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("getId").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("getId").getModifiers()));
            assertEquals(int.class, SolarSystem.class.getDeclaredMethod("getId").getReturnType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredMethod("setId").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("setId").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("setId").getModifiers()));
            assertEquals(void.class, SolarSystem.class.getDeclaredMethod("setId").getReturnType());

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredMethod("getNextId").getModifiers()));
            assertTrue(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("getNextId").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("getNextId").getModifiers()));
            assertEquals(int.class, SolarSystem.class.getDeclaredMethod("getNextId").getReturnType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredMethod("incNextId").getModifiers()));
            assertTrue(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("incNextId").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("incNextId").getModifiers()));
            assertEquals(void.class, SolarSystem.class.getDeclaredMethod("incNextId").getReturnType());

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, SolarSystem.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, SolarSystem.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredMethod("getNumberOfStars").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("getNumberOfStars").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("getNumberOfStars").getModifiers()));
            assertEquals(int.class, SolarSystem.class.getDeclaredMethod("getNumberOfStars").getReturnType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredMethod("setNumberOfStars", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("setNumberOfStars", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("setNumberOfStars", int.class).getModifiers()));
            assertEquals(void.class, SolarSystem.class.getDeclaredMethod("setNumberOfStars", int.class).getReturnType());

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredMethod("getRadius").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("getRadius").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("getRadius").getModifiers()));
            assertEquals(double.class, SolarSystem.class.getDeclaredMethod("getRadius").getReturnType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredMethod("setRadius", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("setRadius", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("setRadius", double.class).getModifiers()));
            assertEquals(void.class, SolarSystem.class.getDeclaredMethod("setRadius", double.class).getReturnType());

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredMethod("getRegistrationDate").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("getRegistrationDate").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("getRegistrationDate").getModifiers()));
            assertEquals(LocalDate.class, SolarSystem.class.getDeclaredMethod("getRegistrationDate").getReturnType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredMethod("setRegistrationDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("setRegistrationDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("setRegistrationDate", LocalDate.class).getModifiers()));
            assertEquals(void.class, SolarSystem.class.getDeclaredMethod("setRegistrationDate", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredMethod("getLastPlanetAdded").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("getLastPlanetAdded").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("getLastPlanetAdded").getModifiers()));
            assertEquals(LocalDate.class, SolarSystem.class.getDeclaredMethod("getLastPlanetAdded").getReturnType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredMethod("setLastPlanetAdded", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("setLastPlanetAdded", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("setLastPlanetAdded", LocalDate.class).getModifiers()));
            assertEquals(void.class, SolarSystem.class.getDeclaredMethod("setLastPlanetAdded", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredMethod("getDaysFromLastPlanetAdded").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("getDaysFromLastPlanetAdded").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("getDaysFromLastPlanetAdded").getModifiers()));
            assertEquals(int.class, SolarSystem.class.getDeclaredMethod("getDaysFromLastPlanetAdded").getReturnType());

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredMethod("getMaxPlanets").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("getMaxPlanets").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("getMaxPlanets").getModifiers()));
            assertEquals(int.class, SolarSystem.class.getDeclaredMethod("getMaxPlanets").getReturnType());

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredMethod("getPlanets").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("getPlanets").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("getPlanets").getModifiers()));
            assertEquals(Planet[].class, SolarSystem.class.getDeclaredMethod("getPlanets").getReturnType());

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredMethod("getNumPlanets").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("getNumPlanets").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("getNumPlanets").getModifiers()));
            assertEquals(int.class, SolarSystem.class.getDeclaredMethod("getNumPlanets").getReturnType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredMethod("findPlanet", Planet.class).getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("findPlanet", Planet.class).getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("findPlanet", Planet.class).getModifiers()));
            assertEquals(int.class, SolarSystem.class.getDeclaredMethod("findPlanet", Planet.class).getReturnType());

            assertTrue(Modifier.isPrivate(SolarSystem.class.getDeclaredMethod("findFirstEmptySlot").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("findFirstEmptySlot").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("findFirstEmptySlot").getModifiers()));
            assertEquals(int.class, SolarSystem.class.getDeclaredMethod("findFirstEmptySlot").getReturnType());

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredMethod("containsPlanet", Planet.class).getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("containsPlanet", Planet.class).getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("containsPlanet", Planet.class).getModifiers()));
            assertEquals(boolean.class, SolarSystem.class.getDeclaredMethod("containsPlanet", Planet.class).getReturnType());

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredMethod("addPlanet", Planet.class, LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("addPlanet", Planet.class, LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("addPlanet", Planet.class, LocalDate.class).getModifiers()));
            assertEquals(void.class, SolarSystem.class.getDeclaredMethod("addPlanet", Planet.class, LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredMethod("removePlanet", Planet.class).getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("removePlanet", Planet.class).getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("removePlanet", Planet.class).getModifiers()));
            assertEquals(void.class, SolarSystem.class.getDeclaredMethod("removePlanet", Planet.class).getReturnType());

            assertTrue(Modifier.isPublic(SolarSystem.class.getDeclaredMethod("getAverageMoonsByPlanet").getModifiers()));
            assertFalse(Modifier.isStatic(SolarSystem.class.getDeclaredMethod("getAverageMoonsByPlanet").getModifiers()));
            assertFalse(Modifier.isFinal(SolarSystem.class.getDeclaredMethod("getAverageMoonsByPlanet").getModifiers()));
            assertEquals(double.class, SolarSystem.class.getDeclaredMethod("getAverageMoonsByPlanet").getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @DisplayName("SolarSystem creation - Valid parameters")
    void solarSystemCreationValidParameters() {
        SolarSystem solarSystem = new SolarSystem("Solar System", 1, 1.5e13, LocalDate.now(), 10);
        assertNotNull(solarSystem);
        assertEquals(1, solarSystem.getId());
        assertEquals("Solar System", solarSystem.getName());
        assertEquals(1, solarSystem.getNumberOfStars());
        assertEquals(1.5e13, solarSystem.getRadius());
        assertEquals(LocalDate.now(), solarSystem.getRegistrationDate());
        assertEquals(10, solarSystem.getMaxPlanets());
        assertEquals(-1, solarSystem.getDaysFromLastPlanetAdded());
        assertEquals(0, solarSystem.getNumPlanets());
        assertEquals(10, solarSystem.getPlanets().length);
    }

    @Test
    @Order(5)
    @DisplayName("SolarSystem creation - Id")
    void testSolarSystemCreationId() {
        SolarSystem solarSystem1 = new SolarSystem("Solar System 1", 1, 1.5e13, LocalDate.now(), 10);
        SolarSystem solarSystem2 = new SolarSystem("Solar System 2", 1, 1.5e13, LocalDate.now(), 10);

        assertEquals(2, solarSystem1.getId());
        assertEquals(3, solarSystem2.getId());
    }

    @Test
    @Order(6)
    @DisplayName("SolarSystem creation - Name")
    void testSolarSystemCreationName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new SolarSystem(null, 1, 1.5e13, LocalDate.now(), 10));

        assertEquals(SolarSystem.INVALID_NAME, exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new SolarSystem("", 1, 1.5e13, LocalDate.now(), 10));
        assertThrows(IllegalArgumentException.class, () -> new SolarSystem(" ", 1, 1.5e13, LocalDate.now(), 10));
        assertThrows(IllegalArgumentException.class, () -> new SolarSystem("So", 1, 1.5e13, LocalDate.now(), 10));
        assertThrows(IllegalArgumentException.class, () -> new SolarSystem("So ", 1, 1.5e13, LocalDate.now(), 10));
        assertThrows(IllegalArgumentException.class, () -> new SolarSystem(" So ", 1, 1.5e13, LocalDate.now(), 10));

        SolarSystem solarSystem = new SolarSystem("Sol", 1, 1.5e13, LocalDate.now(), 10);
        assertEquals("Sol", solarSystem.getName());

        solarSystem = new SolarSystem(" Solar System ", 1, 1.5e13, LocalDate.now(), 10);
        assertEquals("Solar System", solarSystem.getName());

        solarSystem = new SolarSystem("Solar System", 1, 1.5e13, LocalDate.now(), 10);
        assertEquals("Solar System", solarSystem.getName());

        solarSystem = new SolarSystem(" Solar System", 1, 1.5e13, LocalDate.now(), 10);
        assertEquals("Solar System", solarSystem.getName());

        solarSystem = new SolarSystem("Solar System ", 1, 1.5e13, LocalDate.now(), 10);
        assertEquals("Solar System", solarSystem.getName());

        solarSystem = new SolarSystem("   Sol   ", 1, 1.5e13, LocalDate.now(), 10);
        assertEquals("Sol", solarSystem.getName());
    }

    @Test
    @Order(7)
    @DisplayName("SolarSystem creation - Number of stars")
    void testSolarSystemCreationNumberOfStars() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new SolarSystem("Solar System", 0, 1.5e13, LocalDate.now(), 10));

        assertEquals(SolarSystem.INVALID_NUMBER_OF_STARS, exception.getMessage());

        SolarSystem solarSystem = new SolarSystem("Solar System", 1, 1.5e13, LocalDate.now(), 10);
        assertEquals(1, solarSystem.getNumberOfStars());

        solarSystem = new SolarSystem("Solar System", 2, 1.5e13, LocalDate.now(), 10);
        assertEquals(2, solarSystem.getNumberOfStars());
    }

    @Test
    @Order(8)
    @DisplayName("SolarSystem creation - Radius")
    void testSolarSystemCreationRadius() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new SolarSystem("Solar System", 1, -0.1, LocalDate.now(), 10));

        assertEquals(SolarSystem.INVALID_RADIUS, exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new SolarSystem("Solar System", 1, 0.0, LocalDate.now(), 10));

        SolarSystem solarSystem = new SolarSystem("Solar System", 1, 0.01, LocalDate.now(), 10);
        assertEquals(0.01, solarSystem.getRadius());

        solarSystem = new SolarSystem("Solar System", 1, 1.5e12, LocalDate.now(), 10);
        assertEquals(1.5e12, solarSystem.getRadius());
    }

    @Test
    @Order(9)
    @DisplayName("SolarSystem creation - Registration date")
    void testSolarSystemCreationRegistrationDate() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new SolarSystem("Solar System", 1, 1.5e13, null, 10));

        assertEquals(SolarSystem.INVALID_REGISTRATION_DATE, exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new SolarSystem("Solar System", 1, 1.5e13, LocalDate.now().plusDays(1), 10));

        SolarSystem solarSystem = new SolarSystem("Solar System", 1, 1.5e13, LocalDate.now(), 10);
        assertEquals(LocalDate.now(), solarSystem.getRegistrationDate());

        solarSystem = new SolarSystem("Solar System", 1, 1.5e13, LocalDate.now().minusDays(1), 10);
        assertEquals(LocalDate.now().minusDays(1), solarSystem.getRegistrationDate());
    }

    @Test
    @Order(10)
    @DisplayName("SolarSystem creation - Last planet added")
    void testSolarSystemCreationMaxPlanets() {
        SolarSystem solarSystem = new SolarSystem("Solar System", 1, 1.5e13, LocalDate.now(), 1);
        assertNull(solarSystem.getLastPlanetAdded());
    }

}
