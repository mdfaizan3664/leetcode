package com.faizan.leetcode.problems;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNthFromEnd(head, head, head, n);
    }
    public ListNode removeNthFromEnd(ListNode head,ListNode first, ListNode second, int n){
        if(n>0) return removeNthFromEnd(head, first, second.next, n-1);
        if (second == null) return head.next; // for last node
        if(second.next == null) {
            first.next = first.next.next; // in b/w
            return head;
        } else if(second.next.next == null && first == second){  // for first node
            first.next = null;
            return head;
        }
        return removeNthFromEnd(head, first.next, second.next, n);
    }
}
