package ordination.ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DagligFastTest {

    private DagligFast dfast1Dag;
    private DagligFast dfast1DagFlereDoser;

    private DagligFast dfast10Dag;
    private DagligFast doegnDagligFast10Dag;
    private DagligFast doegnDagligFast1Dage;
    private DagligFast doegn1Samlet_1Dag;
    private DagligFast createDosis1DoseOprettet;
    private DagligFast create3DoserOprettet;
    private DagligFast Doser4Oprettet;
    private DagligFast OrdinationOprettet1;
    private DagligFast OrdinationOprettet2;


    private Patient p1;
    private Patient p2;
    private Patient p3;
    private Patient p4;


    private Laegemiddel l1;
    private Laegemiddel l2;
    private Laegemiddel l3;
    private Laegemiddel l4;



    @BeforeEach
    void setUp() {
        this.l1 = new Laegemiddel("Paracetamol", 1, 1.5, 2, "ML");
        this.p1 = new Patient("070985-1153", "Finn Madsen", 83.2);
        this.l2 = new Laegemiddel("Acetylsalicylsyre", 0.1,0.15,0.16, "Styk");
        this.p2 = new Patient("121256-0512", "Jane Jensen", 63.4);
        this.l3 = new Laegemiddel("Paracetamol", 1, 1.5, 2, "ML");
        this.l4 = new Laegemiddel("Paracetamol", 1, 1.5, 2, "ML");
        this.p3 = new Patient("121256-0512", "Jane Jensen", 63.4);
        this.p4 = new Patient("121256-0512", "Jane Jensen", 63.4);

        dfast1Dag = new DagligFast(LocalDate.of(2022, 9, 20), LocalDate.of(2022, 9, 20), p1, l1);
        dfast1DagFlereDoser = new DagligFast(LocalDate.of(2022, 9, 20), LocalDate.of(2022, 9, 20), p1, l1);
        dfast10Dag = new DagligFast(LocalDate.of(2022, 9, 20), LocalDate.of(2022, 9, 29), p1, l1);
        doegnDagligFast10Dag = new DagligFast(LocalDate.of(2022, 9, 20), LocalDate.of(2022, 9, 29), p1, l1);
        doegnDagligFast1Dage = new DagligFast(LocalDate.of(2022, 9, 20), LocalDate.of(2022, 9, 20), p1, l1);
        doegn1Samlet_1Dag = new DagligFast(LocalDate.of(2022, 9, 20), LocalDate.of(2022, 9, 20), p1, l1);
    }

    @Test
    void TC1_1Dag_1Doser_10EnhederPrDag() {

        // Arrange
        int antalDoserForDfast1Dag = 10;

        dfast1Dag.createDosis(LocalTime.of(2, 0), 10);
        dfast1Dag.createDosis(LocalTime.of(8, 0), 0);
        dfast1Dag.createDosis(LocalTime.of(14, 0), 0);
        dfast1Dag.createDosis(LocalTime.of(20, 0), 0);


        // Act
        dfast1Dag.samletDosis();


        // Assert
        assertEquals(antalDoserForDfast1Dag, dfast1Dag.samletDosis());
    }

    @Test
    void TC2_1Dag_4Doser_17EnhederPrDag() {
        // Arrange
        int antalDoserForDfast1DagFlereDoser = 17;


        dfast1DagFlereDoser.createDosis(LocalTime.of(8, 0), 4);
        dfast1DagFlereDoser.createDosis(LocalTime.of(14, 0), 4);
        dfast1DagFlereDoser.createDosis(LocalTime.of(20, 0), 5);
        dfast1DagFlereDoser.createDosis(LocalTime.of(2, 0), 4);

        // Act
        dfast1DagFlereDoser.samletDosis();

        // Assert
        assertEquals(antalDoserForDfast1DagFlereDoser, dfast1DagFlereDoser.samletDosis());
    }

    @Test
    void TC3_10Dage_4Doser_10EnhederPrDag() {

        // Arrange
        int antalDoserForDfast10Dag = 100;

        dfast10Dag.createDosis(LocalTime.of(8, 0), 2);
        dfast10Dag.createDosis(LocalTime.of(14, 0), 2);
        dfast10Dag.createDosis(LocalTime.of(20, 0), 2);
        dfast10Dag.createDosis(LocalTime.of(2, 0), 4);

        // Act
        dfast10Dag.samletDosis();

        // Assert
        assertEquals(antalDoserForDfast10Dag, dfast10Dag.samletDosis());
    }

    @Test
    void TC4_100samlet_10Dage() {

        // Arrange
        int antaldoegnDagligFast = 10;
        doegnDagligFast10Dag.createDosis(LocalTime.of(2, 0), 10);
        doegnDagligFast10Dag.createDosis(LocalTime.of(8, 0), 0);
        doegnDagligFast10Dag.createDosis(LocalTime.of(14, 0), 0);
        doegnDagligFast10Dag.createDosis(LocalTime.of(20, 0), 0);

        // Act
        doegnDagligFast10Dag.doegnDosis();

        // Assert
        assertEquals(antaldoegnDagligFast, doegnDagligFast10Dag.doegnDosis());
    }

    // doegnDagligFast10Dage
    @Test
    void TC5_10Samlet_10Dage() {

        // Arrange
        int antaldoegnDagligFast1Dage = 10;

        doegnDagligFast1Dage.createDosis(LocalTime.of(2, 0), 10);
        doegnDagligFast1Dage.createDosis(LocalTime.of(8, 0), 0);
        doegnDagligFast1Dage.createDosis(LocalTime.of(14, 0), 0);
        doegnDagligFast1Dage.createDosis(LocalTime.of(20, 0), 0);

        // Act
        doegnDagligFast1Dage.doegnDosis();


        // Assert
        assertEquals(antaldoegnDagligFast1Dage, doegnDagligFast1Dage.doegnDosis());
    }

    @Test
    void TC6_1Samlet_1Dag() {

        // Arrange
        int antaldoegn1Samlet_1Dag = 1;

        doegn1Samlet_1Dag.createDosis(LocalTime.of(2, 0), 1);
        doegn1Samlet_1Dag.createDosis(LocalTime.of(8, 0), 0);
        doegn1Samlet_1Dag.createDosis(LocalTime.of(14, 0), 0);
        doegn1Samlet_1Dag.createDosis(LocalTime.of(20, 0), 0);

        // Act
        doegn1Samlet_1Dag.doegnDosis();


        // Assert
        assertEquals(antaldoegn1Samlet_1Dag, doegn1Samlet_1Dag.doegnDosis());
    }

    @Test
    void TC9_1DoseOprettet(){
        // Arrange
        createDosis1DoseOprettet = new DagligFast(LocalDate.of(2022, 9, 20), LocalDate.of(2022, 9, 29), p2, l2);

        // Act
        createDosis1DoseOprettet.createDosis(LocalTime.of(8, 0), 3);


        // Assert
        assertNotNull(createDosis1DoseOprettet.getDoser()[0]);
    }

    @Test
    void TC10_3DoserOprettet(){
        // Arrange
        create3DoserOprettet = new DagligFast(LocalDate.of(2022, 9, 20), LocalDate.of(2022, 9, 29), p2, l2);

        // Act
        create3DoserOprettet.createDosis(LocalTime.of(8, 0), 2);
        create3DoserOprettet.createDosis(LocalTime.of(14, 0), 2);
        create3DoserOprettet.createDosis(LocalTime.of(20, 0), 2);

        // Assert
        assertNotNull(create3DoserOprettet.getDoser()[0]);
        assertNotNull(create3DoserOprettet.getDoser()[1]);
        assertNotNull(create3DoserOprettet.getDoser()[2]);
    }

    @Test
    void TC11_4DoserOprettet(){
        // Arrange
        Doser4Oprettet = new DagligFast(LocalDate.of(2022, 9, 20), LocalDate.of(2022, 9, 29), p2, l2);

        // Act
        Doser4Oprettet.createDosis(LocalTime.of(8, 0), 1);
        Doser4Oprettet.createDosis(LocalTime.of(14, 0), 1);
        Doser4Oprettet.createDosis(LocalTime.of(20, 0), 1);
        Doser4Oprettet.createDosis(LocalTime.of(2, 0), 1);

        // Assert
        assertNotNull(Doser4Oprettet.getDoser()[0]);
        assertNotNull(Doser4Oprettet.getDoser()[1]);
        assertNotNull(Doser4Oprettet.getDoser()[2]);
    }

    @Test
    void TC12_OrdinationOprettet(){
        // Arrange
        OrdinationOprettet1 = new DagligFast(LocalDate.of(2022, 9, 20), LocalDate.of(2022, 9, 29), p3, l3);


        // Act


        // Assert

    }

    @Test
    void TC13_OrdinationOprettet(){

    }

}