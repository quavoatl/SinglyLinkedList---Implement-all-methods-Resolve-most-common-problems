package com.example;

public class LinkedListt {

    Node head;

    public void printList(Node node) {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + ", ");
            n = n.next;
        }
    }

    public Node push(int data) {

        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
        return new_node;
    }

    public Node insertAfterGivenNode(Node prevNode, int data) {

        if (prevNode == null) {
            System.out.println("No such previous node found");
        }
        Node new_node = new Node(data);
        new_node.next = prevNode.next;
        prevNode.next = new_node;

        return new_node;
    }

    public Node append(int data) {

        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
        }
        new_node.next = null;

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
        return new_node;
    }

    public void deleteNode(Node nodeToDelete) {

        Node prev = head;
        while (prev.next != nodeToDelete) {
            prev = prev.next;
        }
        prev.next = nodeToDelete.next;
    }

    public void deleteNodeAtGivenPosition(int position) {

        Node temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        Node next = temp.next.next;
        temp.next = next;
    }

    public void deleteNodeAtGivenPosition2(int position) {
        Node temp = head;
        Node prev = null;
        int count = 0;

        while (temp != null) {
            prev = temp;
            temp = temp.next;
            count++;

            if (count == position) {
                prev.next = temp.next;
            }
        }
    }

    public void swapNodes(Node node1, Node node2) {

        Node currentNode1 = head;
        Node prevNode1 = null;
        while (currentNode1 != node1) {
            prevNode1 = currentNode1;
            currentNode1 = currentNode1.next;
        }

        Node copyNode1 = currentNode1;
        Node copyPrevNode1 = prevNode1;

        Node currentNode2 = head;
        Node prevNode2 = null;
        while (currentNode2 != node2) {
            prevNode2 = currentNode2;
            currentNode2 = currentNode2.next;
        }
        Node copyNode2 = currentNode2;
        Node copyPrevNode2 = prevNode2;

        Node temp = copyNode2.next;
        copyNode2.next = copyNode1.next;
        copyNode1.next = temp;

        if (copyPrevNode1 == null) {
            head = copyNode2;
            copyPrevNode2.next = copyNode1;
        }

        if (copyPrevNode2 == null) {
            head = copyNode1;
            copyPrevNode1.next = copyNode2;
        }

        if (prevNode1 != null && prevNode2 != null) {
            prevNode1.next = copyNode2;
            prevNode2.next = copyNode1;
        }
    }

    public Node reverse(Node node) {

        Node next = null;
        Node prev = null;
        Node current = node;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public Node mergeSort(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node middleNode = getMiddleNode(head);
        Node nextToMiddle = middleNode.next;

        middleNode.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);

        Node sortedList = sortMerge(left, right);
        return sortedList;
    }

    public Node sortMerge(Node node1, Node node2) {
        Node result = null;

        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        if (node1.data <= node2.data) {
            result = node1;
            result.next = sortMerge(node1.next, node2);
        } else {
            result = node2;
            result.next = sortMerge(node1, node2.next);
        }
        return result;
    }

    public Node getMiddleNode(Node head) {
        //1 -> 2 -> 3 -> 4 -> null
        if (head == null) {
            return head;
        }
        Node fastPointer = head.next;
        Node slowPointer = head;

        while (fastPointer != null) {
            fastPointer = fastPointer.next;

            if (fastPointer != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
        }
        return slowPointer;
    }


    public boolean binarySearch(LinkedListt linkedListt, int target, int low, int high) {
        if (low > high) {
            System.out.println("No such element");
            return false;
        } else {
            int position = (low + high) / 2;
            int mid = getElementAtPosition(position);

            if (target == mid) {
                System.out.println("Found element : " + target);
                return true;
            } else if (target < mid) {
                return binarySearch(linkedListt, target, low, (position - 1));
            } else {
                return binarySearch(linkedListt, target, (position + 1), high);
            }
        }
    }

    public int getElementAtPosition(int position) {
        Node curr = head;
        int count = 0;
        while (count != position) {
            curr = curr.next;
            count++;
            if (count == position) {
                return curr.data;
            }
        }
        return 1;
    }


    public Node mergeTwoLists(Node headA, Node headB) {

        Node dummyNode = new Node(0);
        Node tail = dummyNode;

        while (headA != null && headB != null) {
            if (headA.data <= headB.data) {
                tail.next = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                headB = headB.next;
            }
            tail = tail.next;

            if (headA != null) {
                tail.next = headA;
            }
            if (headB != null) {
                tail.next = headB;
            }
        }
        removeDuplicates(dummyNode.next);
        return dummyNode.next;
    }

    public void removeDuplicates(Node head) {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public Node detectLoop(Node head) {
        Node p = head;
        Node q = head;

        while (p != null && q != null && q.next != null) {
            p = p.next.next;
            q = q.next;
            if(p == q) {
                return p;
            }
        }
        return null;
    }
    public void removeLoop(Node meetingPoint,Node head) {
        Node p = meetingPoint;
        Node q = head;

        while (p != q) {
            p = p.next;
            q = q.next;
        }
        meetingPoint.next.next = null;
    }


    public void rotate(int position,Node startPoint) {
        //1  2  5  7  20
        // position = 3
        //7  20 1  2  5
        startPoint = head;
        Node current = startPoint;
        Node copyOfHead = startPoint;
        Node prev = null;
        Node lastNode = null;

        Node foundNodeAtPosition = getNodeAtPosition(position,startPoint);

        while(current != foundNodeAtPosition) {
            prev = current;
            current = current.next;
        }
        while(current != null) {
            lastNode = current;
            current = current.next;
        }

        head = foundNodeAtPosition;
        lastNode.next = copyOfHead;
        prev.next = null;
    }

    public Node getNodeAtPosition(int position,Node head) {
        Node current = head;
        Node prev = null;
        int count = -1;
        while(current != null) {
            prev = current;
            current = current.next;
            count++;

            if(count == position) {
                return prev;
            }
        }
        return null;
    }

















}

