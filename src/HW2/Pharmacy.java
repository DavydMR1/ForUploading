package HW2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Pharmacy implements Iterator<Component> {
    private int index;
    private List<Component> components;
    public Pharmacy() {
        this.index = 0;
        this.components = new ArrayList<>();
    }

    public void addComponents(Component...components) {
        if (components.length == 0) System.out.println("Nothing was added!");
        Collections.addAll(this.components, components);
    }

    @Override
    public boolean hasNext() {
        return index < components.size();
    }

    @Override
    public Component next() {
        //component c = components
        //index++
        //return c
        return components.get(index++);
    }
}
