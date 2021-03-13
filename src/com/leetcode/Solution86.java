package com.leetcode;

/**
 * @author : lovingyf
 * @software : Intellij IDEA 2020
 * @date : 2021/1/3 15:22
 */
public class Solution86 {
    public Solution86() {
        ListNode listNode = new ListNode(1);
        ListNode start = listNode;
        listNode.next = new ListNode(4);
        listNode = listNode.next;
        listNode.next = new ListNode(3);
        listNode = listNode.next;
        listNode.next = new ListNode(2);
        listNode = listNode.next;
        listNode.next = new ListNode(5);
        listNode = listNode.next;
        listNode.next = new ListNode(2);

        ListNode end = partition(start, 3);
    }
    public ListNode partition(ListNode head, int x) {
        ListNode result=head;
        ListNode temp;
        ListNode tempHead=null;
        while (head!=null&&head.val<x){
            tempHead=head;
            head=head.next;
        }

        while (head.next != null) {
            if (head.next.val < x) {
                //拼接前面
                temp=new ListNode(head.next.val);
                temp.next=tempHead.next;
                tempHead.next=temp;
                tempHead=temp;
                //拼接后面
                head.next=head.next.next;
            }else
                head=head.next;
        }
        return result;
    }
//    public ListNode partition(ListNode head, int x) {
//        ListNode resultHead = new ListNode(0);
//        ListNode resultTail = new ListNode(0);
//
//        ListNode listNodeHead = resultHead;
//        ListNode listNodeTail = resultTail;
//
//
//        while (head != null) {
//            if (head.val < x) {
//                listNodeHead.next = new ListNode(head.val);
//                listNodeHead = listNodeHead.next;
//            } else {
//                listNodeTail.next = new ListNode(head.val);
//                listNodeTail = listNodeTail.next;
//            }
//            head = head.next;
//        }
//        listNodeHead.next = resultTail.next;
//        System.out.println();
//        return resultHead.next;
//    }

    public class ListNode {
        int val;
        ListNode next=null;

        ListNode(int x) {
            val = x;
        }
    }

}
