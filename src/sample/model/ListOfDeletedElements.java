package sample.model;

/* GUIThreadsClearFinally
 *
 * variant 2
 *
 * by Andrukh Sergey
 * 243(2), IFTKN,
 * department Software Engineering
 *
 * 10/30/19
 *
 * (c) YDFD corporated
 */

import java.util.ArrayList;
import java.util.List;

public class ListOfDeletedElements {
    private static volatile List<Transaction> list = new ArrayList<>();

    public static List<Transaction> getList() {
        return list;
    }

    public static void setList(List<Transaction> list) {
        ListOfDeletedElements.list = list;
    }
}
