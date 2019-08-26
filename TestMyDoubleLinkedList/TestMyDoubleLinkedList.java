package cn.dataStructure2.com;

public class TestMyDoubleLinkedList {
    public static void main(String[] args) {
        MyDoubleLinkedList list = new MyDoubleLinkedList();
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addFirst("4");
        list.addFirst("5");
        list.addLast("6");
        list.addLast("7");
        list.addLast("8");
        list.addFirst("0");
        list.addFirst("0");
        list.addLast("0");
        list.addLast("0");
        list.addIndex(4,"0");
        list.display();
        System.out.println(list.getLength());
//        list.removeAllKey("0");
//        list.display();
        list.remove("0");
        list.display();
        list.remove("0");
        list.display();
        list.remove("0");
        list.display();
//        list.remove("0");
//        list.display();
//        list.clear();
//        list.display();
//        list.addFirst("0");
//        list.display();
    }
}
