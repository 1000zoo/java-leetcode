//https://leetcode.com/problems/design-hashmap/
//2022-09-04

package linkedlist;

//Runtime: 163 ms, faster than 10.64% of Java online submissions for Design HashMap.
//Memory Usage: 48.9 MB, less than 93.78% of Java online submissions for Design HashMap.
public class MyHashMap {

    static private class MapList {
        int key;
        int val;
        MapList next;
        MapList(){}

        MapList(int key, int val) {
            this.key = key;
            this.val = val;
        }

        MapList(int key, int val, MapList next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    MapList head = new MapList();
    public MyHashMap(){}

    public void put(int key, int value) {
        MapList curr = head;
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next.val = value;
                return;
            }
            curr = curr.next;
        }
        curr.next = new MapList(key, value);
    }

    public int get(int key) {
        MapList curr = head;
        while (curr.next != null) {
            if (curr.next.key == key) {
                return curr.next.val;
            }
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        MapList curr = head;
        while (curr.next != null) {
            if (curr.next.key == key) {
                if (curr.next.next == null) {
                    curr.next = null;
                } else {
                    curr.next = curr.next.next;
                }
                return;
            }
            curr = curr.next;
        }
    }
}
