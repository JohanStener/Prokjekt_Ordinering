package ordination.ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PNTest {

    /*@BeforeEach
    public void setup() {
        PN pn;
    }*/


    @Test
    void TC_36_givDosis() {
        // Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 10);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");

        PN pn = new PN(StartDen, SlutDen, patient, lm, 5);

        // Act
        boolean actualTrue1 = pn.givDosis(LocalDate.of(2022, 9, 1));
        boolean actualTrue2 = pn.givDosis(LocalDate.of(2022, 9, 10));
        boolean actualFalse1 = pn.givDosis(LocalDate.of(2022, 9, 11));
        boolean actualFalse2 = pn.givDosis(LocalDate.of(2022, 8, 30));



        // Assert
        assertEquals(true, actualTrue1);
        assertEquals(true, actualTrue2);
        assertEquals(false, actualFalse1);
        assertEquals(false, actualFalse2);
    }

    @Test
    void TC33_5_enheder_5_dage_getAntalGangeGivet() {
        // Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 10);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        PN pn = new PN(StartDen, SlutDen, patient, lm, 5);
        pn.givDosis(LocalDate.of(2022, 9, 1));
        pn.givDosis(LocalDate.of(2022, 9, 2));
        pn.givDosis(LocalDate.of(2022, 9, 5));


        // Act
        int actual = pn.getAntalGangeGivet();


        // Assert
        assertEquals(3, actual);
    }

    @Test
    void TC34_3_enheder_9_dage_getAntalGangeGivet() {
        // Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 10);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        PN pn = new PN(StartDen, SlutDen, patient, lm, 3);
        pn.givDosis(LocalDate.of(2022, 9, 2));
        pn.givDosis(LocalDate.of(2022, 9, 6));
        pn.givDosis(LocalDate.of(2022, 9, 9));

        // Act
        int actual = pn.getAntalGangeGivet();

        // Assert
        assertEquals(3, actual);
    }

    @Test
    void TC17_6samlet_10Dage_doegnDosis() {
        // Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 10);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        PN pn = new PN(StartDen, SlutDen, patient, lm, 5);
        pn.givDosis(LocalDate.of(2022, 9, 1));
        pn.givDosis(LocalDate.of(2022, 9, 2));
        pn.givDosis(LocalDate.of(2022, 9, 5));


        // Act
        double actual = pn.doegnDosis();

        // Assert
        assertEquals(3, actual);
    }

    @Test
    void TC29_3Enheder_9Dage_doegnDosis() {
        // Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 10);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        PN pn = new PN(StartDen, SlutDen, patient, lm, 3);
        pn.givDosis(LocalDate.of(2022, 9, 2));
        pn.givDosis(LocalDate.of(2022, 9, 6));
        pn.givDosis(LocalDate.of(2022, 9, 10));


        // Act
        double actual = pn.doegnDosis();

        // Assert
        assertEquals(1, actual);
    }

    @Test
    void TC30_6Enheder_5Dage_doegnDosis() {
        // Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 10);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        PN pn = new PN(StartDen, SlutDen, patient, lm, 5);
        pn.givDosis(LocalDate.of(2022, 9, 5));
        pn.givDosis(LocalDate.of(2022, 9, 5));
        pn.givDosis(LocalDate.of(2022, 9, 8));


        // Act
        double actual = pn.doegnDosis();

        // Assert
        assertEquals(3.75, actual);
    }


    @Test
    void getType() {
    }

    @Test
    void TC26_1Dag_1Enhed_samletDosis() {
        // Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 10);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        PN pn = new PN(StartDen, SlutDen, patient, lm, 1);
        pn.givDosis(LocalDate.of(2022, 9, 1));
        pn.givDosis(LocalDate.of(2022, 9, 1));
        pn.givDosis(LocalDate.of(2022, 9, 1));


        // Act
        double actual = pn.samletDosis();

        // Assert
        assertEquals(3, actual);
    }

    @Test
    void TC27_6Dage_10Enheder_samletDosis() {
        // Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 10);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        PN pn = new PN(StartDen, SlutDen, patient, lm, 10);
        pn.givDosis(LocalDate.of(2022, 9, 1));
        pn.givDosis(LocalDate.of(2022, 9, 3));
        pn.givDosis(LocalDate.of(2022, 9, 4));
        pn.givDosis(LocalDate.of(2022, 9, 9));


        // Act
        double actual = pn.samletDosis();

        // Assert
        assertEquals(40, actual);
    }




}