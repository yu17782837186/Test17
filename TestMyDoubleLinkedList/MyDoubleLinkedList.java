package cn.dataStructure2.com;

public class MyDoubleLinkedList implements doubleLinked {
    class Node {
        private Object data;
        private Node next;
        private Node pre;

        public Node(Object data) {
            this.data = data;
        }
    }
    private Node head;
    private Node last;

    public MyDoubleLinkedList() {
        this.head = null;
        this.last = null;
    }

    @Override
    public void addFirst(Object data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            last = node;
        }else {
            node.next = head;
            head.pre = node;
            head = node;
        }
    }

    @Override
    public void addLast(Object data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            last = node;
        }
        last.next = node;
        node.pre= last;
        last = node;
    }
    private void checkIndex(int index) {
        if (index < 0 || index > getLength()) {
            throw new RuntimeException("下标越界异常："+index);
        }
    }
    private Node pre(int index) {
        checkIndex(index);
        Node cur = head;
        int n = 0;
        while(n < index) {
            cur = cur.next;
            n++;
        }
        return cur;
    }
    @Override
    public boolean addIndex(int index, Object data) {
        if (index == 0) {
            addFirst(data);
            return true;
        }
        if (index == getLength()) {
            addLast(data);
            return true;
        }
        Node node = new Node(data);
        Node tmp = pre(index);
        node.next = tmp;
        node.pre = tmp.pre;
        node.pre.next = node;
        node.next.pre = node;
        return true;
    }

    @Override
    public boolean contains(Object key) {
        Node p = head;
        while(p != null) {
            if (p.data == key) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    @Override
    public Object remove(Object key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                Object oldData = cur.data;
                //要删除的节点是头结点
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.pre = null;
                }else {
                    //cur.next != null表示删除的不是
                    //尾节点
                    if(cur.next != null) {
                        cur.pre.next = cur.next;
                        cur.next.pre = cur.pre;
                    }else {
                        //尾节点删除，last需要移动
                        this.last = cur.pre;
                        last.next = null;
                    }
                }
                return oldData;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void removeAllKey(Object key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                //要删除的节点是头结点
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.pre = null;
                }else {
                    //cur.next != null表示删除的不是
                    //尾节点
                    if(cur.next != null) {
                        cur.pre.next = cur.next;
                        cur.next.pre = cur.pre;
                    }else {
                        //尾节点删除，last需要移动
                        this.last = cur.pre;
                        last.next = null;
                    }
                }
            }
            cur = cur.next;
        }
    }

    @Override
    public int getLength() {
        Node p = head;
        int count = 0;
        while(p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node p = head;
        while(p != null) {
            System.out.print(p.data+" ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while(head.next != null) {
            Node p = head.next;
            head.next = p.next;
            p.pre = null;
        }
        head = null;
    }
}
