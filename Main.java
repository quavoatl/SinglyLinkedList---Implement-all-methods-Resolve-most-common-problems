package com.example;


public class Main {

    public static void main(String[] args) {

        LinkedListt linkedListt = new LinkedListt();
        linkedListt.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        linkedListt.head.next = second;
        second.next = third;

        linkedListt.printList(linkedListt.head);
        System.out.println();
        Node fourNode = linkedListt.push(4);
        linkedListt.printList(linkedListt.head);

        System.out.println();

        Node firstNode = new Node(1);
        linkedListt.head = firstNode;
        firstNode.next = second;
        third.next = fourNode;
        fourNode.next = null;
        linkedListt.printList(linkedListt.head);

        Node sixNode = linkedListt.append(6);
        System.out.println();
        linkedListt.printList(linkedListt.head);
        Node fiveNode = linkedListt.insertAfterGivenNode(fourNode, 5);
        System.out.println();
        linkedListt.printList(firstNode);

        Node sevenNode = linkedListt.append(7);
        Node eightNode = linkedListt.append(8);

        linkedListt.deleteNode(fiveNode);
        System.out.println();
        linkedListt.printList(linkedListt.head);

        linkedListt.deleteNodeAtGivenPosition2(2);
        System.out.println();
        System.out.println("Before swapping");
        linkedListt.printList(linkedListt.head);

        System.out.println();
        System.out.println("After swapping");
        linkedListt.swapNodes(firstNode, sevenNode);
        linkedListt.printList(linkedListt.head);

        System.out.println();
        System.out.println("Before reversing : ");
        LinkedListt linkedListt2 = new LinkedListt();
        Node firstNodee = new Node(7);
        linkedListt2.head = firstNodee;
        Node secondNodee = new Node(2);
        Node thirdNodee = new Node(20);
        Node fourNodee = new Node(1);
        Node fiveNodee = new Node(5);

        firstNodee.next = secondNodee;
        secondNodee.next = thirdNodee;
        thirdNodee.next = fourNodee;
        fourNodee.next = fiveNodee;
        fiveNodee.next = null;


        linkedListt2.printList(linkedListt2.head);
        System.out.println();
        System.out.println("After reversing : ");


        linkedListt2.head = linkedListt2.reverse(linkedListt2.head);
        linkedListt2.printList(linkedListt2.head);
        System.out.println();

        System.out.println();
        System.out.println("Before Merge Sort ");
        linkedListt2.printList(linkedListt2.head);
        System.out.println();

        System.out.println("Merge sort applied for the second linked list");
        linkedListt2.head = linkedListt2.mergeSort(linkedListt2.head);
        linkedListt2.printList(linkedListt2.head);

        System.out.println();

        linkedListt2.binarySearch(linkedListt2, 5, 0, 4);
        System.out.println();
        System.out.println("Rotate linked list");


        linkedListt2.rotate(2,linkedListt2.head);
        linkedListt2.printList(linkedListt2.head);
        System.out.println();

        System.out.println("Merge Sort applied for the first linked list");
        linkedListt.head = linkedListt.mergeSort(linkedListt.head);
        linkedListt.printList(linkedListt.head);
        System.out.println();

        System.out.println("Merge 2 lists");
        linkedListt.head = linkedListt.mergeTwoLists(linkedListt.head,linkedListt2.head);
        linkedListt.printList(linkedListt.head);
        System.out.println();

        System.out.println("Test detecting loop");
        LinkedListt linkedListt3 = new LinkedListt();
        Node loopOne = new Node(1);
        Node loopTwo = new Node(2);
        Node loopThree = new Node(3);
        Node loopFour = new Node(4);
        Node loopFive = new Node(5);
        Node loopSix = new Node(6);
        Node loopSeven = new Node(7);
        Node loopEight = new Node(8);
        Node loopNine = new Node(9);
        Node loopTen = new Node(10);

        linkedListt3.head = loopOne;
        loopOne.next = loopTwo;
        loopTwo.next = loopThree;
        loopThree.next = loopFour;
        loopFour.next = loopFive;
        loopFive.next = loopSix;
        loopSix.next = loopSeven;
        loopSeven.next = loopEight;
        loopEight.next = loopNine;
        loopNine.next = loopTen;
        loopTen.next = loopThree;

        Node detectedLoop = linkedListt3.detectLoop(loopOne);

        if(detectedLoop != null) {
            linkedListt3.removeLoop(detectedLoop, loopOne);
        }
        linkedListt3.printList(loopOne);




    }
}
