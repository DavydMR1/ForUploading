package HW2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IterablePharmacy implements Iterable<Component>, Comparable<IterablePharmacy>, IterPharmacy {
    private int index;
    private List<Component> components;
    public IterablePharmacy() {
        this.index = 0;
        this.components = new ArrayList<>();
    }

    public void addComponents(Component...components) {
        if (components.length == 0) System.out.println("Nothing was added!");
        Collections.addAll(this.components, components);
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public Iterator<Component> iterator() {
        return new Iterator<Component>() {
            @Override
            public boolean hasNext() {
                return index < components.size();
            }

            @Override
            public Component next() {
                return components.get(index++);
            }
        };
    }

    @Override
    public int compareTo(IterablePharmacy o) {

    }

    @Override
    public int compareTo(IterablePharmacy i, IterablePharmacy j) {
        if (i.components.size() != j.components.size()) {
            return 1;
        }
        else {
            int a = 0;
            for (int k = 0; k < i.components.size(); k++) {
                if (j.components.contains(i.components.get(k))) {
                    a += 1;
                }
            }
            if (a != i.components.size()) {
                return 1;
            }
            else return 0;
        }
    }
}
