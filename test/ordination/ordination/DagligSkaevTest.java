package ordination.ordination;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

class DagligSkaevTest {

    @Test
    void TC14_1Dag_1DosePrDag_Samlet() {
        //Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 1);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        DagligSkaev dagligSkaev = new DagligSkaev(StartDen, SlutDen, patient,lm);
        dagligSkaev.opretDosis(LocalTime.of(12,0),8);

        //Act
        double expected = 8;
        double actual = dagligSkaev.samletDosis();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void TC15_1Dage_3DoserPrDag_Samlet() {
        //Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 1);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        DagligSkaev dagligSkaev = new DagligSkaev(StartDen, SlutDen, patient,lm);
        dagligSkaev.opretDosis(LocalTime.of(12,0),8);
        dagligSkaev.opretDosis(LocalTime.of(16,0),2);
        dagligSkaev.opretDosis(LocalTime.of(18,0),5);


        //Act
        double expected = 15;
        double actual = dagligSkaev.samletDosis();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void TC16_10Dage_5DoserPrDag_Samlet() {
        //Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 10);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        DagligSkaev dagligSkaev = new DagligSkaev(StartDen, SlutDen, patient,lm);
        dagligSkaev.opretDosis(LocalTime.of(12,0),8);
        dagligSkaev.opretDosis(LocalTime.of(16,0),2);
        dagligSkaev.opretDosis(LocalTime.of(18,0),5);
        dagligSkaev.opretDosis(LocalTime.of(20,0),3);
        dagligSkaev.opretDosis(LocalTime.of(22,0),2);


        //Act
        double expected = 200;
        double actual = dagligSkaev.samletDosis();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void TC17_1Dose_2Enheder_doegnDosis() {
        //Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 1);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        DagligSkaev dagligSkaev = new DagligSkaev(StartDen, SlutDen, patient,lm);
        dagligSkaev.opretDosis(LocalTime.of(12,0),2);

        //Act
        double expected = 2;
        double actual = dagligSkaev.doegnDosis();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void TC18_1Dose_6Enheder_doegnDosis() {
        //Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 1);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        DagligSkaev dagligSkaev = new DagligSkaev(StartDen, SlutDen, patient,lm);
        dagligSkaev.opretDosis(LocalTime.of(12,0),6);

        //Act
        double expected = 6;
        double actual = dagligSkaev.doegnDosis();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void TC19_3Doser_6Enheder_doegnDosis() {
        //Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 1);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        DagligSkaev dagligSkaev = new DagligSkaev(StartDen, SlutDen, patient,lm);
        dagligSkaev.opretDosis(LocalTime.of(12,0),2);
        dagligSkaev.opretDosis(LocalTime.of(14,0),2);
        dagligSkaev.opretDosis(LocalTime.of(16,0),2);

        //Act
        double expected = 6;
        double actual = dagligSkaev.doegnDosis();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void TC22_DosisOprettet_opretDosis () {
        //Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 10);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        DagligSkaev dagligSkaev = new DagligSkaev(StartDen, SlutDen, patient,lm);
        dagligSkaev.opretDosis(LocalTime.of(16,0),1);

        //Act
        double expected = 1;
        double actual = dagligSkaev.getDoses().get(0).getAntal();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void TC23_DosisOprettet_opretDosis () {
        //Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 10);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        DagligSkaev dagligSkaev = new DagligSkaev(StartDen, SlutDen, patient,lm);
        dagligSkaev.opretDosis(LocalTime.of(16,0),5);

        //Act
        double expected = 5;
        double actual = dagligSkaev.getDoses().get(0).getAntal();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void TC24_DagligSkaevOprettet_constructor(){
        //Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 10);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");

        //Act
        DagligSkaev dagligSkaev = new DagligSkaev(StartDen, SlutDen, patient,lm);

        //Assert
        assertNotNull(dagligSkaev);
    }

    @Test
    void TC25_DagligSkaevOprettet_constructor(){
        //Arrange
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 10);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");

        //Act
        DagligSkaev dagligSkaev = new DagligSkaev(StartDen, SlutDen, patient,lm);

        //Assert
        assertNotNull(dagligSkaev);
    }




}