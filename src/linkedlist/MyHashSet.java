//https://leetcode.com/problems/design-hashset/
//2022-09-04

package linkedlist;

//Runtime: 975 ms, faster than 7.94% of Java online submissions for Design HashSet.
//Memory Usage: 56.7 MB, less than 57.63% of Java online submissions for Design HashSet.
public class MyHashSet {
    private class HashList{
        int val;
        HashList next;

        public HashList(){}

        public HashList(int val) {
            this.val = val;
        }
        public HashList(int val, HashList next){
            this.val = val;
            this.next = next;
        }
    }
    HashList head = new HashList();
    public MyHashSet(){}
    public void add(int key){
        if(contains(key)) return;
        HashList backup = head;
        HashList adding = new HashList(key);
        while(head.next != null) head = head.next;
        head.next = adding;
        head = backup;
    }
    public void remove(int key){
        HashList backup = new HashList(0, head);
        while(head.next != null){
            if(head.next.val == key){
                if(head.next.next == null) head.next = null;
                else head.next = head.next.next;
                head = backup.next;
                return;
            }
            head = head.next;
        }
        head = backup.next;
    }
    public boolean contains(int key){
        HashList backup = new HashList(0, head);
        while(head.next != null){
            if(head.next.val == key){
                head = backup.next;
                return true;
            }
            head = head.next;
        }
        head = backup.next;
        return false;
    }
}
