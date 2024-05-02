package HW2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VetClinic {
    private List<Animal> patients = new ArrayList<>();
    public void addpatients(Animal ... animals) {
        Collections.addAll(patients, animals);
    }
    public List<Goable> getgoables() {
        List<Goable> result = new ArrayList<>(patients.size());
        for (Animal animal: patients) {
            if (animal instanceof Goable) result.add((Goable) animal);
        }
        return result;
    }
    public List<Swimmable> getswimmables() {
        List<Swimmable> result = new ArrayList<>(patients.size());
        for (Animal animal: patients) {
            if (animal instanceof Swimmable) result.add((Swimmable) animal);
        }
        return result;
    }
    public List<Flyable> getflyables() {
        List<Flyable> result = new ArrayList<>(patients.size());
        for (Animal animal: patients) {
            if (animal instanceof Flyable) result.add((Flyable) animal);
        }
        return result;
    }
    public List<Animal> getPatients() {
        return patients;
    }
}
