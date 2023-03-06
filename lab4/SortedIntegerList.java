import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;

public class SortedIntegerList {
    private boolean DuplicatePermission;
    private LinkedList<Integer> head;

    SortedIntegerList(boolean check) {
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
                if (current == val && this.DuplicatePermission) {
                    it.add(val);
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

    public boolean equal(LinkedList<Integer> a) {
        if (a != null) {
            ListIterator<Integer> ThisIt = head.listIterator();
            ListIterator<Integer> OtherIt = a.listIterator();

            while (ThisIt.hasNext() && OtherIt.hasNext()) {
                if (!Objects.equals(ThisIt.next(), OtherIt.next()))
                    return false;
            }
        }
        if (head.size() != a.size()) {
            return false;
        }
        return false;
    }

    public void PrintMyList() {
        for (Integer it : head) {
            System.out.println(it);
        }
    }
}
