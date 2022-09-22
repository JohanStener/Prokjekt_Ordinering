package ordination.ordination;

import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {
    ArrayList<Dosis> doses = new ArrayList<>();


    public Dosis opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        doses.add(dosis);
        return dosis;
    }

    @Override
    public double samletDosis() {
        int antal = 0;
        for (Dosis d : doses) {
            antal += d.getAntal();
        }

        return antal * antalDage();
    }

    @Override
    public double doegnDosis() {
        int sum = 0;
        for (Dosis d : doses) {
            sum += d.getAntal();
        }
        return sum;
        //return samletDosis() / antalDage();
    }

    @Override
    public String getType() {
        return null;
    }

    public ArrayList<Dosis> getDoses() {
        return new ArrayList<>(doses);
    }
}
