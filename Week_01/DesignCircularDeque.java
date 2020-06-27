//Design your implementation of the circular double-ended queue (deque). 
//
// Your implementation should support following operations: 
//
// 
// MyCircularDeque(k): Constructor, set the size of the deque to be k. 
// insertFront(): Adds an item at the front of Deque. Return true if the operati
//on is successful. 
// insertLast(): Adds an item at the rear of Deque. Return true if the operation
// is successful. 
// deleteFront(): Deletes an item from the front of Deque. Return true if the op
//eration is successful. 
// deleteLast(): Deletes an item from the rear of Deque. Return true if the oper
//ation is successful. 
// getFront(): Gets the front item from the Deque. If the deque is empty, return
// -1. 
// getRear(): Gets the last item from Deque. If the deque is empty, return -1. 
// isEmpty(): Checks whether Deque is empty or not. 
// isFull(): Checks whether Deque is full or not. 
// 
//
// 
//
// Example: 
//
// 
//MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 
//3
//circularDeque.insertLast(1);			// return true
//circularDeque.insertLast(2);			// return true
//circularDeque.insertFront(3);			// return true
//circularDeque.insertFront(4);			// return false, the queue is full
//circularDeque.getRear();  			// return 2
//circularDeque.isFull();				// return true
//circularDeque.deleteLast();			// return true
//circularDeque.insertFront(4);			// return true
//circularDeque.getFront();			// return 4
// 
//
// 
//
// Note: 
//
// 
// All values will be in the range of [0, 1000]. 
// The number of operations will be in the range of [1, 1000]. 
// Please do not use the built-in Deque library. 
// 
// Related Topics 设计 队列

package com.wsz.leetcode.editor.cn;
public class DesignCircularDeque {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new DesignCircularDeque().new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));
        System.out.println(myCircularDeque.insertLast(2));
        System.out.println(myCircularDeque.insertFront(3));
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.isFull());
        System.out.println(myCircularDeque.deleteLast());
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.getFront());

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class ListNode {
        int value;
        ListNode front;
        ListNode next;
        ListNode () { this.front = null; this.next = null;}
        ListNode (int value) {
            this.value = value;
            this.next = this;
            this.front = this;
        }
    }
    class MyCircularDeque {

        ListNode listNode;

        int current;

        int size;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            this.current = 0;
            this.size = k;
            listNode = new ListNode();
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (this.current == this.size) {
                return false;
            }
            if (this.current == 0) {
                this.listNode = new ListNode(value);
            } else {
                ListNode node = new ListNode(value);
                node.next = this.listNode;
                node.front = this.listNode.front;
                this.listNode.front.next = node;
                this.listNode.front = node;
                this.listNode = node;
            }
            this.current++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (this.current == this.size) {
                return false;
            }
            if (this.current == 0) {
                this.listNode = new ListNode(value);
            } else {
                ListNode node = new ListNode(value);
                node.next = this.listNode.front.next;
                node.front = this.listNode.front;
                this.listNode.front.next = node;
                this.listNode.front = node;
            }
            this.current++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (this.current == 0) {
                return false;
            }
            if(this.current == 1) {
                this.listNode = new ListNode();
            } else {
                this.listNode = this.listNode.next;
                this.listNode.front = this.listNode.front.front;
                this.listNode.front.next = this.listNode;
            }
            this.current--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (this.current == 0) {
                return false;
            }
            if(this.current == 1) {
                this.listNode = new ListNode();
            } else {
                this.listNode.front.front.next = this.listNode;
                this.listNode.front = this.listNode.front.front;
            }
            this.current--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (this.current == 0) {
                return -1;
            }
            return this.listNode.value;
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (this.current == 0) {
                return -1;
            }
            return this.listNode.front.value;
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return this.current == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return this.current == this.size;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
