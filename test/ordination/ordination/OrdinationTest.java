package ordination.ordination;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrdinationTest {

    @Test
    void TC20_1_dag_antalDage() {
        // Arrange
        LocalDate startDato = LocalDate.of(2022, 9, 1);
        LocalDate slutDato = LocalDate.of(2022, 9, 1);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");

        Ordination pn = new PN(startDato,slutDato, patient, lm, 3);

        // Act
        int actual = pn.antalDage();

        // Assert
        assertEquals(1, actual);
    }
    @Test
    void TC21_5_dage_antalDage() {
        // Arrange
        LocalDate startDato = LocalDate.of(2022, 9, 1);
        LocalDate slutDato = LocalDate.of(2022, 9, 5);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");

        Ordination pn = new PN(startDato,slutDato, patient, lm, 3);

        // Act
        int actual = pn.antalDage();

        // Assert
        assertEquals(5, actual);
    }
}