package java_example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by JINSHENGJIE on 16/10/31 .
 * ========================================
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * ========================================
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList rdsl = new RemoveDuplicatesFromSortedList();
        ArrayList<Integer> list = new ArrayList(Arrays.asList(1, 1, 1, 1, 2, 3, 5, 5, 6));
        Iterator<Integer> iterator = rdsl.removeDuplicate_1(list).iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.print(next + ",");
        }
    }

    /**
     * Remove duplicate array list.
     * ===origin===
     *   ----------------------------以ArrayList 代替 ListNode-----------------------------------
     * @param list the list
     * @return the array list
     */
    public ArrayList removeDuplicate_1(ArrayList<Integer> list) {
        ArrayList<Integer> resultList = new ArrayList<>();
/*

        for (Integer item : list) {
            if (resultList.isEmpty()) {
                resultList.add(item);
            } else if (item != resultList.get(resultList.size() - 1)) {
                resultList.add(item);
            }
        }
*/
        //java8
        list.forEach(t -> {
            if (resultList.isEmpty() || t != resultList.get(resultList.size() - 1))
                resultList.add(t);
        });
        return resultList;
    }

    /**
     * Remove duplicate 2 list node.
     *
     * @param head the head
     * @return the list node
     */
    public ListNode removeDuplicate_2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        if(head.val == head.next.val){
            head.next = head.next.next;
            head = removeDuplicate_2(head);
        }
        head.next = removeDuplicate_2(head.next);
        return head;
    }

}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }