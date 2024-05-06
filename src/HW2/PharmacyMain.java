package HW2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PharmacyMain {
    public static void main(String[] args) {
        Component pineceline = new Component("pineceline", "10mg", 100);
        Component salt = new Component("salt", "20g", 10);
        Component sugar = new Component("sugar", "87g", 80);

        IterablePharmacy pharmacy1 = new IterablePharmacy();
        pharmacy1.addComponents(salt, pineceline);

        IterablePharmacy pharmacy2 = new IterablePharmacy();
        pharmacy2.addComponents(sugar, pineceline);

        IterablePharmacy pharmacy3 = new IterablePharmacy();
        pharmacy3.addComponents(pineceline, salt);

        IterablePharmacy pharmacy4 = new IterablePharmacy();
        pharmacy4.addComponents(salt, sugar);

//        for (Component c : pharmacy2) {
//            System.out.println(c);
//        }

        List<Component> list = new ArrayList<>();
        list.add(pineceline);
        list.add(salt);
        list.add(sugar);
        System.out.println(list);

        Set<IterablePharmacy> result = new HashSet<>();
        result.add(pharmacy1);
        result.add(pharmacy2);
        result.add(pharmacy3);
        result.add(pharmacy4);


        System.out.println(result.size());
    }
}
