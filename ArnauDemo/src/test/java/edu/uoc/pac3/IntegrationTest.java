package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntegrationTest {

    @Test
    @Order(11)
    @DisplayName("SolarSystem - Add planet")
    public void testAddPlanet() {
        SolarSystem solarSystem = new SolarSystem("Solar System", 1, 1000, LocalDate.now(), 7);

        Planet planet1 = new Planet("Mercury", 0, 3.30e23, 2439, 3.70, LocalDate.now(), false);
        Planet planet2 = new Planet("Venus", 0, 4.87e24, 6052, 8.87, LocalDate.now(), false);
        Planet planet3 = new Planet("Earth", 1, 5.97e24, 6371, 9.81, LocalDate.now(), false);
        Planet planet4 = new Planet("Mars", 2, 6.42e23, 3389, 3.71, LocalDate.now(), false);
        Planet planet5 = new Planet("Jupiter", 79, 1.90e27, 69911, 24.79, LocalDate.now(), false);
        Planet planet6 = new Planet("Saturn", 82, 5.68e26, 58232, 10.44, LocalDate.now(), true);
        Planet planet7 = new Planet("Uranus", 27, 8.68e25, 25362, 8.69, LocalDate.now(), false);
        Planet planet8 = new Planet("Neptune", 14, 1.02e26, 24622, 11.15, LocalDate.now(), false);

        solarSystem.addPlanet(planet1, LocalDate.now());

        assertEquals(1, solarSystem.getNumPlanets());
        assertTrue(solarSystem.containsPlanet(planet1));
        assertFalse(solarSystem.containsPlanet(planet2));
        assertEquals(planet1, solarSystem.getPlanets()[0]);

        solarSystem.addPlanet(planet2, LocalDate.now());

        assertEquals(2, solarSystem.getNumPlanets());
        assertTrue(solarSystem.containsPlanet(planet1));
        assertTrue(solarSystem.containsPlanet(planet2));
        assertFalse(solarSystem.containsPlanet(planet3));
        assertEquals(planet1, solarSystem.getPlanets()[0]);
        assertEquals(planet2, solarSystem.getPlanets()[1]);

        solarSystem.addPlanet(planet3, LocalDate.now());
        solarSystem.addPlanet(planet4, LocalDate.now());

        assertEquals(4, solarSystem.getNumPlanets());
        assertTrue(solarSystem.containsPlanet(planet1));
        assertTrue(solarSystem.containsPlanet(planet2));
        assertTrue(solarSystem.containsPlanet(planet3));
        assertTrue(solarSystem.containsPlanet(planet4));
        assertFalse(solarSystem.containsPlanet(planet5));
        assertEquals(planet1, solarSystem.getPlanets()[0]);
        assertEquals(planet2, solarSystem.getPlanets()[1]);
        assertEquals(planet3, solarSystem.getPlanets()[2]);
        assertEquals(planet4, solarSystem.getPlanets()[3]);

        for (int i = 4; i < solarSystem.getNumPlanets(); i++) {
            assertNull(solarSystem.getPlanets()[i]);
        }

        Exception exception = assertThrows(NullPointerException.class, () -> solarSystem.addPlanet(null, LocalDate.now()));
        assertEquals(SolarSystem.PLANET_NULL, exception.getMessage());

        assertEquals(4, solarSystem.getNumPlanets());

        exception = assertThrows(IllegalArgumentException.class, () -> solarSystem.addPlanet(planet1, LocalDate.now()));
        assertEquals(SolarSystem.PLANET_ALREADY_EXISTS, exception.getMessage());

        assertEquals(4, solarSystem.getNumPlanets());

        solarSystem.addPlanet(planet5, LocalDate.now());
        solarSystem.addPlanet(planet6, LocalDate.now());
        solarSystem.addPlanet(planet7, LocalDate.now());

        assertEquals(7, solarSystem.getNumPlanets());
        assertTrue(solarSystem.containsPlanet(planet1));
        assertTrue(solarSystem.containsPlanet(planet2));
        assertTrue(solarSystem.containsPlanet(planet3));
        assertTrue(solarSystem.containsPlanet(planet4));
        assertTrue(solarSystem.containsPlanet(planet5));
        assertTrue(solarSystem.containsPlanet(planet6));
        assertTrue(solarSystem.containsPlanet(planet7));
        assertFalse(solarSystem.containsPlanet(planet8));
        assertEquals(planet1, solarSystem.getPlanets()[0]);
        assertEquals(planet2, solarSystem.getPlanets()[1]);
        assertEquals(planet3, solarSystem.getPlanets()[2]);
        assertEquals(planet4, solarSystem.getPlanets()[3]);
        assertEquals(planet5, solarSystem.getPlanets()[4]);
        assertEquals(planet6, solarSystem.getPlanets()[5]);
        assertEquals(planet7, solarSystem.getPlanets()[6]);

        exception = assertThrows(IllegalStateException.class, () -> solarSystem.addPlanet(planet8, LocalDate.now()));
        assertEquals(SolarSystem.INVALID_MAX_PLANETS, exception.getMessage());

        assertEquals(7, solarSystem.getNumPlanets());
    }

    @Test
    @Order(12)
    @DisplayName("SolarSystem - Remove planet")
    public void testRemovePlanet() {
        SolarSystem solarSystem = new SolarSystem("Solar System", 1, 1000, LocalDate.now(), 7);

        Planet planet1 = new Planet("Mercury", 0, 3.30e23, 2439, 3.70, LocalDate.now(), false);
        Planet planet2 = new Planet("Venus", 0, 4.87e24, 6052, 8.87, LocalDate.now(), false);
        Planet planet3 = new Planet("Earth", 1, 5.97e24, 6371, 9.81, LocalDate.now(), false);
        Planet planet4 = new Planet("Mars", 2, 6.42e23, 3389, 3.71, LocalDate.now(), false);

        solarSystem.addPlanet(planet1, LocalDate.now());
        solarSystem.addPlanet(planet2, LocalDate.now());

        assertEquals(2, solarSystem.getNumPlanets());

        solarSystem.removePlanet(planet1);

        assertEquals(1, solarSystem.getNumPlanets());
        assertFalse(solarSystem.containsPlanet(planet1));
        assertTrue(solarSystem.containsPlanet(planet2));
        assertNull(solarSystem.getPlanets()[0]);
        assertEquals(planet2, solarSystem.getPlanets()[1]);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> solarSystem.removePlanet(planet1));
        assertEquals(SolarSystem.PLANET_NOT_FOUND, exception.getMessage());
        assertEquals(1, solarSystem.getNumPlanets());

        solarSystem.addPlanet(planet3, LocalDate.now());
        solarSystem.addPlanet(planet4, LocalDate.now());

        assertEquals(3, solarSystem.getNumPlanets());

        solarSystem.removePlanet(planet2);

        assertEquals(2, solarSystem.getNumPlanets());

        assertFalse(solarSystem.containsPlanet(planet1));
        assertFalse(solarSystem.containsPlanet(planet2));
        assertTrue(solarSystem.containsPlanet(planet3));
        assertTrue(solarSystem.containsPlanet(planet4));
        assertEquals(planet3, solarSystem.getPlanets()[0]);
        assertNull(solarSystem.getPlanets()[1]);
        assertEquals(planet4, solarSystem.getPlanets()[2]);
    }

    @Test
    @Order(13)
    @DisplayName("SolarSystem - Other functionalities")
    public void testLastPlanetAdded() {
        SolarSystem solarSystem = new SolarSystem("Solar System", 1, 1000, LocalDate.now(), 7);

        Planet planet1 = new Planet("Mercury", 0, 3.30e23, 2439, 3.70, LocalDate.now(), false);
        Planet planet2 = new Planet("Venus", 0, 4.87e24, 6052, 8.87, LocalDate.now(), false);
        Planet planet3 = new Planet("Earth", 1, 5.97e24, 6371, 9.81, LocalDate.now(), false);
        Planet planet4 = new Planet("Mars", 2, 6.42e23, 3389, 3.71, LocalDate.now(), false);
        Planet planet5 = new Planet("Jupiter", 79, 1.90e27, 69911, 24.79, LocalDate.now(), false);
        Planet planet6 = new Planet("Saturn", 82, 5.68e26, 58232, 10.44, LocalDate.now(), true);
        Planet planet7 = new Planet("Uranus", 27, 8.68e25, 25362, 8.69, LocalDate.now(), false);

        assertNull(solarSystem.getLastPlanetAdded());

        solarSystem.addPlanet(planet1, LocalDate.of(2010, 1, 1));
        assertEquals(LocalDate.of(2010, 1, 1), solarSystem.getLastPlanetAdded());

        solarSystem.addPlanet(planet2, LocalDate.of(2009, 2, 2));
        assertEquals(LocalDate.of(2009, 2, 2), solarSystem.getLastPlanetAdded());

        solarSystem.addPlanet(planet3, LocalDate.of(2011, 3, 3));
        assertEquals(LocalDate.of(2011, 3, 3), solarSystem.getLastPlanetAdded());

        solarSystem.addPlanet(planet4, null);
        assertEquals(LocalDate.of(2011, 3, 3), solarSystem.getLastPlanetAdded());

        assertEquals(0.75, (double) Math.round(solarSystem.getAverageMoonsByPlanet() * 100) / 100);

        solarSystem.addPlanet(planet5, LocalDate.now());
        assertEquals(LocalDate.now(), solarSystem.getLastPlanetAdded());

        assertEquals(16.4, (double) Math.round(solarSystem.getAverageMoonsByPlanet() * 100) / 100);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> solarSystem.addPlanet(planet6, LocalDate.now().plusDays(1)));
        assertEquals(SolarSystem.INVALID_LAST_PLANET_ADDED, exception.getMessage());
        assertEquals(16.4, (double) Math.round(solarSystem.getAverageMoonsByPlanet() * 100) / 100);

        solarSystem.addPlanet(planet6, LocalDate.now().minusDays(5));
        assertEquals(LocalDate.now().minusDays(5), solarSystem.getLastPlanetAdded());
        assertEquals(5, solarSystem.getDaysFromLastPlanetAdded());
        assertEquals(27.33, (double) Math.round(solarSystem.getAverageMoonsByPlanet() * 100) / 100);

        solarSystem.addPlanet(planet7, LocalDate.now().minusDays(10));
        assertEquals(LocalDate.now().minusDays(10), solarSystem.getLastPlanetAdded());
        assertEquals(10, solarSystem.getDaysFromLastPlanetAdded());
        assertEquals(27.29, (double) Math.round(solarSystem.getAverageMoonsByPlanet() * 100) / 100);
    }

}
