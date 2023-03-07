package SortedIntegerList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;
public class SortedIntegerList {
    private boolean DuplicatePermission;
    private LinkedList<Integer> head;

    public SortedIntegerList(boolean check) {
        DuplicatePermission = check;
        head = new LinkedList<Integer>();
    }

    public void add(int val) {
        if (head.isEmpty()) {
            head.add(val);
        } else {
            ListIterator<Integer> it = head.listIterator();
            while (it.hasNext()) {
                Integer current = it.next();
                if (current > val) {
                    it.previous();
                    it.add(val);
                    return;
                }
                if (current == val && !this.DuplicatePermission) {
                    return;
                }
            }
            it.add(val);
        }
    }

    public void remove(int val) {
        ListIterator<Integer> it = head.listIterator();
        while (it.hasNext()) {
            Integer current = it.next();
            if (val == current) {
                it.remove();
                return;
            }
        }
    }

    public boolean equal(SortedIntegerList a) {
        if (this.head == a.head)
            return true;
        if (a instanceof SortedIntegerList) {
            ListIterator<Integer> ThisIt = head.listIterator();
            ListIterator<Integer> OtherIt = a.head.listIterator();

            while (ThisIt.hasNext() && OtherIt.hasNext()) {
                if (!Objects.equals(ThisIt.next(), OtherIt.next()))
                    return false;
            }
        }
        if (head.size() != a.head.size()) {
            return false;
        }
        if (this.DuplicatePermission != a.DuplicatePermission) {
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder c = new StringBuilder();
        c.append("SortedLinkedList {size = ").append(head.size()).append(" \n Values: ");
        for (Integer it : head) {
            c.append(it).append(" ");
        }
        c.append("\n").append("}");
        return c.toString();
    }

}
