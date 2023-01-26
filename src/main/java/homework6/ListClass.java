package homework6;

import java.util.*;

public class ListClass {

    List<Integer> list1 = new ArrayList<Integer>();
    List list2 = new LinkedList();
    List list3 = new Vector();
    List list4 = new Stack();

    public void addToList() { // todo узнать почему метод add() не работает вне какого-то еще метода
        for (int i = 0; i < 5; i++) {
            list1.add(i);
        }
    }

}
