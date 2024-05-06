package HW2;

import java.util.Iterator;

public class ComponentIterator implements Iterator<Component> {
    private int index = 0;
    public IterablePharmacy pharmacy;
    @Override
    public boolean hasNext() {
        return index < pharmacy.getComponents().size();
    }

    @Override
    public Component next() {
        //component c = components
        //index++
        //return c
        return pharmacy.getComponents().get(index++);
    }
}
