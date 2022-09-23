package ordination.controller;

import ordination.ordination.Laegemiddel;
import ordination.ordination.PN;
import ordination.ordination.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @BeforeEach
    void setup(){

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
        PN pn = controller.opretPNOrdination(StartDen, SlutDen, patient, lm , 5);
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
        PN pn = controller.opretPNOrdination(StartDen, SlutDen, patient, lm , 5);
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
        try{
            PN pn = controller.opretPNOrdination(StartDen, SlutDen, patient, lm , 5);
        }
        catch(IllegalArgumentException e){
            thrown = true;
        }

        assertTrue(thrown);
    }

    @org.junit.jupiter.api.Test
    void opretDagligFastOrdination() {
    }

    @org.junit.jupiter.api.Test
    void opretDagligSkaevOrdination() {
    }

    @org.junit.jupiter.api.Test
    void ordinationPNAnvendt() {
    }

    @org.junit.jupiter.api.Test
    void anbefaletDosisPrDoegn() {
    }
}