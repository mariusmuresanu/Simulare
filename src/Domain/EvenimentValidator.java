package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EvenimentValidator implements IValidator<Eveniment> {

    public void validate(Eveniment eveniment) {

        StringBuilder error = new StringBuilder();
        if (eveniment.getName() == null ) {
            throw new RuntimeException("Evenimentul trebuie sa aiba un nume");
        }
        if (eveniment.getId() == null ) {
            error.append("ID should have a value");
        }
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            format.parse(eveniment.getDate());
        } catch (ParseException pe) {
            throw new RuntimeException("The date of birth is not in a correct format!");
        }
//        if (eveniment.getDuration() < "0"){
//            throw new RuntimeException("Evenimentul trebuie sa aiba o durata de timp!")
//        }

        try {
            format.parse(eveniment.getStartingTime());
        } catch (ParseException pe) {
            throw new RuntimeException("The date of registration is not in a correct format!");
        }
    }
}
