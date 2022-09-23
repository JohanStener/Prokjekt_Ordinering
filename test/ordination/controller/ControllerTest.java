package ordination.controller;

import ordination.ordination.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @BeforeEach
    void setup() {

    }

    @Test
    void TC42_Sammedato_opretPNOrdination() {
        // Arrange
        Controller controller = new Controller();
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 10);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");

        // Act + assert
        PN pn = controller.opretPNOrdination(StartDen, SlutDen, patient, lm, 5);
        assertNotNull(pn);

    }

    @Test
    void TC43_Valide_Datoer_opretPNOrdination() {
        // Arrange
        Controller controller = new Controller();
        LocalDate StartDen = LocalDate.of(2022, 8, 30);
        LocalDate SlutDen = LocalDate.of(2022, 9, 3);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");

        // Act + assert
        PN pn = controller.opretPNOrdination(StartDen, SlutDen, patient, lm, 5);
        assertNotNull(pn);
    }

    @Test
    void TC44_Invalide_datoer_opretPNOrdination() {
        // Arrange
        Controller controller = new Controller();
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 8, 1);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        boolean thrown = false;
        // Act + assert
        try {
            PN pn = controller.opretPNOrdination(StartDen, SlutDen, patient, lm, 5);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    void TC45_Valide_Datoer_opretDagligFastOrdination() {
        // Arrange
        Controller controller = new Controller();
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 1);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        boolean thrown = false;

        // Act + assert
        DagligFast DF = controller.opretDagligFastOrdination(StartDen, SlutDen, patient, lm, 5, 5, 5, 5);
        assertNotNull(DF);
    }


    @Test
    void TC46_Valide_Datoer_opretDagligFastOrdination() {
        // Arrange
        Controller controller = new Controller();
        LocalDate StartDen = LocalDate.of(2022, 8, 5);
        LocalDate SlutDen = LocalDate.of(2022, 8, 8);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        boolean thrown = false;

        // Act + assert
        DagligFast DF = controller.opretDagligFastOrdination(StartDen, SlutDen, patient, lm, 5, 5, 5, 5);
        assertNotNull(DF);
    }

    @Test
    void TC47_Invalide_Datoer_opretDagligFastOrdination() {
        // Arrange
        Controller controller = new Controller();
        LocalDate StartDen = LocalDate.of(2022, 8, 20);
        LocalDate SlutDen = LocalDate.of(2022, 8, 19);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        boolean thrown = false;

        // Act + assert
        try {
            DagligFast DF = controller.opretDagligFastOrdination(StartDen, SlutDen, patient, lm, 5, 5, 5, 5);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    void TC48_Valide_Datoer_Valide_Elementer_opretDagligSkaevOrdination() {
        // Arrange
        Controller controller = new Controller();
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 1);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        LocalTime[] klokkeSlet = new LocalTime[3];
        klokkeSlet[0] = LocalTime.of(13, 0);
        klokkeSlet[1] = LocalTime.of(14, 0);
        klokkeSlet[2] = LocalTime.of(15, 0);
        double[] antalEnheder = new double[3];
        antalEnheder[0] = 2.0;
        antalEnheder[1] = 1.0;
        antalEnheder[2] = 2.5;

        // Act + assert
        DagligSkaev DS = controller.opretDagligSkaevOrdination(StartDen, SlutDen, patient, lm, klokkeSlet, antalEnheder);
        assertNotNull(DS);
    }

    @Test
    void TC49_Valide_Datoer_Valide_Datoer_opretDagligSkaevOrdination() {
        // Arrange
        Controller controller = new Controller();
        LocalDate StartDen = LocalDate.of(2022, 8, 5);
        LocalDate SlutDen = LocalDate.of(2022, 8, 8);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        LocalTime[] klokkeSlet = new LocalTime[5];
        klokkeSlet[0] = LocalTime.of(13, 0);
        klokkeSlet[1] = LocalTime.of(14, 0);
        klokkeSlet[2] = LocalTime.of(15, 0);
        klokkeSlet[3] = LocalTime.of(16, 0);
        klokkeSlet[4] = LocalTime.of(17, 0);
        double[] antalEnheder = new double[5];
        antalEnheder[0] = 2.0;
        antalEnheder[1] = 1.0;
        antalEnheder[2] = 2.5;
        antalEnheder[3] = 1.1;
        antalEnheder[4] = 2.3;

        // Act + assert
        DagligSkaev DS = controller.opretDagligSkaevOrdination(StartDen, SlutDen, patient, lm, klokkeSlet, antalEnheder);
        assertNotNull(DS);
    }

    @Test
    void TC50_Invalide_Datoer_Valide_elementer_opretDagligSkaevOrdination() {
        // Arrange
        boolean thrown = false;
        Controller controller = new Controller();
        LocalDate StartDen = LocalDate.of(2022, 8, 20);
        LocalDate SlutDen = LocalDate.of(2022, 8, 19);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        LocalTime[] klokkeSlet = new LocalTime[5];
        klokkeSlet[0] = LocalTime.of(13, 0);
        klokkeSlet[1] = LocalTime.of(14, 0);
        klokkeSlet[2] = LocalTime.of(15, 0);
        klokkeSlet[3] = LocalTime.of(16, 0);
        klokkeSlet[4] = LocalTime.of(17, 0);
        double[] antalEnheder = new double[5];
        antalEnheder[0] = 2.0;
        antalEnheder[1] = 1.0;
        antalEnheder[2] = 2.5;
        antalEnheder[3] = 1.1;
        antalEnheder[4] = 2.3;

        // Act + assert
        try {
            DagligSkaev DS = controller.opretDagligSkaevOrdination(StartDen, SlutDen, patient, lm, klokkeSlet, antalEnheder);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    void TC51_Valide_Datoer_InValide_elementer_opretDagligSkaevOrdination() {
        // Arrange
        boolean thrown = false;
        Controller controller = new Controller();
        LocalDate StartDen = LocalDate.of(2022, 8, 10);
        LocalDate SlutDen = LocalDate.of(2022, 8, 15);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        LocalTime[] klokkeSlet = new LocalTime[8];
        klokkeSlet[0] = LocalTime.of(13, 0);
        klokkeSlet[1] = LocalTime.of(14, 0);
        klokkeSlet[2] = LocalTime.of(15, 0);
        klokkeSlet[3] = LocalTime.of(16, 0);
        klokkeSlet[4] = LocalTime.of(17, 0);
        klokkeSlet[5] = LocalTime.of(18, 0);
        klokkeSlet[6] = LocalTime.of(19, 0);
        klokkeSlet[7] = LocalTime.of(20, 0);
        double[] antalEnheder = new double[3];
        antalEnheder[0] = 2.0;
        antalEnheder[1] = 1.0;
        antalEnheder[2] = 2.5;


        // Act + assert
        try {
            DagligSkaev DS = controller.opretDagligSkaevOrdination(StartDen, SlutDen, patient, lm, klokkeSlet, antalEnheder);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    void TC52__Invalide_Datoer_Invalide_elementer_opretDagligSkaevOrdination() {
        // Arrange
        boolean thrown = false;
        Controller controller = new Controller();
        LocalDate StartDen = LocalDate.of(2022, 9, 10);
        LocalDate SlutDen = LocalDate.of(2022, 9, 8);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");
        LocalTime[] klokkeSlet = new LocalTime[3];
        klokkeSlet[0] = LocalTime.of(13, 0);
        klokkeSlet[1] = LocalTime.of(14, 0);
        klokkeSlet[2] = LocalTime.of(15, 0);

        double[] antalEnheder = new double[4];
        antalEnheder[0] = 2.0;
        antalEnheder[1] = 1.0;
        antalEnheder[2] = 2.5;
        antalEnheder[3] = 1.8;

        // Act + assert
        try {
            DagligSkaev DS = controller.opretDagligSkaevOrdination(StartDen, SlutDen, patient, lm, klokkeSlet, antalEnheder);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }



    @Test
    void TC53_Valid_Dato_ordinationPNAnvendt() {
        // Arrange
        Controller controller = new Controller();
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 10);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");

        LocalDate dato = LocalDate.of(2022, 9, 5);
        PN pn = new PN(StartDen, SlutDen, patient, lm, 5);
        pn.getDatoer().size();

        // Act
        controller.ordinationPNAnvendt(pn, dato);

        // Assert
        assertNotNull(pn.getDatoer().get(pn.getDatoer().size()-1));
    }

    @Test
    void TC54_Invalid_DatoordinationPNAnvendt() {
        // Arrange
        Controller controller = new Controller();
        LocalDate StartDen = LocalDate.of(2022, 9, 1);
        LocalDate SlutDen = LocalDate.of(2022, 9, 10);
        Patient patient = new Patient("94958", "Johan", 80);
        Laegemiddel lm = new Laegemiddel("Ipren", 0.1, 0.2, 0.3, "Dråber");

        LocalDate dato = LocalDate.of(2022, 9, 18);
        PN pn = new PN(StartDen, SlutDen, patient, lm, 5);
        boolean thrown = false;

        // Act
        try{
            controller.ordinationPNAnvendt(pn, dato);
        }
        catch(IllegalArgumentException e){
            thrown = true;
        }


        // Assert
        assertTrue(thrown);

    }

    @Test
    void TC55_Vægt_24_Faktor_001_anbefaletDosisPrDoegn() {
        // Arrange
        Controller controller = new Controller();
        Patient patient = new Patient("94958", "Johan", 24);
        Laegemiddel lm = new Laegemiddel("Methotrexat", 0.01, 0.015, 0.02, "Styk");

        // Act
        double actual = controller.anbefaletDosisPrDoegn(patient, lm);

        // Assert
        assertEquals(0.24,actual);
    }

    @Test
    void TC56_Vægt_24_Faktor_0015_anbefaletDosisPrDoegn() {
        // Arrange
        Controller controller = new Controller();
        Patient patient = new Patient("94958", "Johan", 25);
        Laegemiddel lm = new Laegemiddel("Methotrexat", 0.01, 0.015, 0.02, "Styk");

        // Act
        double actual = controller.anbefaletDosisPrDoegn(patient, lm);

        // Assert
        assertEquals(0.375,actual);
    }

    @Test
    void TC57_Vægt_24_Faktor_0015_anbefaletDosisPrDoegn() {
        // Arrange
        Controller controller = new Controller();
        Patient patient = new Patient("94958", "Johan", 50);
        Laegemiddel lm = new Laegemiddel("Methotrexat", 0.01, 0.015, 0.02, "Styk");

        // Act
        double actual = controller.anbefaletDosisPrDoegn(patient, lm);

        // Assert
        assertEquals(0.75,actual);
    }

    @Test
    void TC58_Vægt_24_Faktor_0015_anbefaletDosisPrDoegn() {
        // Arrange
        Controller controller = new Controller();
        Patient patient = new Patient("94958", "Johan", 120);
        Laegemiddel lm = new Laegemiddel("Methotrexat", 0.01, 0.015, 0.02, "Styk");

        // Act
        double actual = controller.anbefaletDosisPrDoegn(patient, lm);

        // Assert
        assertEquals(1.7999999999999998,actual);
    }

    @Test
    void TC59_Vægt_24_Faktor_02_anbefaletDosisPrDoegn() {
        // Arrange
        Controller controller = new Controller();
        Patient patient = new Patient("94958", "Johan", 121);
        Laegemiddel lm = new Laegemiddel("Methotrexat", 0.01, 0.015, 0.02, "Styk");

        // Act
        double actual = controller.anbefaletDosisPrDoegn(patient, lm);

        // Assert
        assertEquals(2.42,actual);
    }
}