package lists2;

class ListNode {
    String data;
    ListNode next;

    public ListNode(String data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private ListNode head;

    public LinkedList() {
        this.head = null;
    }

    public void addElement(String element) {
        ListNode newNode = new ListNode(element);
        newNode.next = head;
        head = newNode;
    }

    public void displayOnScreen() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void sortAndMoveMaxLengthToStart() {
        if (head == null || head.next == null) {
            // Список пуст или содержит только один элемент, сортировка не требуется
            return;
        }

        ListNode maxLengthNode = head;
        ListNode prevMaxLengthNode = null;
        ListNode current = head;
        ListNode prev = null;

        while (current.next != null) {
            if (compareStrings(current.next.data, maxLengthNode.data) > 0) {
                maxLengthNode = current.next;
                prevMaxLengthNode = current;
            }
            prev = current;
            current = current.next;
        }

        if (prevMaxLengthNode != null) {
            // Исключение максимального элемента из текущей позиции
            prevMaxLengthNode.next = maxLengthNode.next;
            // Включение максимального элемента в начало списка
            maxLengthNode.next = head;
            head = maxLengthNode;
        }
    }

    private int compareStrings(String str1, String str2) {
        int lengthCompare = Integer.compare(str2.length(), str1.length());

        if (lengthCompare != 0) {
            return lengthCompare;
        } else {
            return str1.compareTo(str2);
        }
    }
}

public class ListSort {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Добавление элементов
        list.addElement("apple");
        list.addElement("orange");
        list.addElement("banana");
        list.addElement("grape");

        // Вывод на экран до сортировки
        System.out.println("Список до сортировки:");
        list.displayOnScreen();

        // Сортировка и перемещение максимального элемента (по длине строки) в начало списка
        list.sortAndMoveMaxLengthToStart();

        // Вывод на экран после сортировки
        System.out.println("Список после сортировки:");
        list.displayOnScreen();
    }
}
