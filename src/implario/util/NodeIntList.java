package implario.util;

public class NodeIntList {
    private Node node = new Node(-1);

    public boolean add(int t) {
        node.add(t);
        return true;
    }

    public void remove(int index) {
        node.remove(index);
    }

    public int get(int index) {
        return node.get(index);
    }

    public int size() {
        return node.size() - 1;
    }

    public NodeIterator iterator() {
        return new NodeIterator();
    }

    private class Node{
        private Node next;
        private int object;

        private Node(int object){
            this.object = object;
        }

        private int get(int index){
            if(next == null)return -1;
            if(index == 0)return next.object;
            else return next.get(index - 1);
        }

        private void add(int object){
            if(next == null)next = new Node(object);
            else next.add(object);
        }

        private void remove(int index){
            if(next == null)return;
            if(index == 0)next = next.next;
            else next.remove(index - 1);
        }

        private int size(){
            return next == null ? 1 : next.size() + 1;
        }
    }

    private class NodeIterator{
        private Node next = node;

        public boolean hasNext() {
            return next.next != null;
        }

        public int next() {
            return (next = next.next).object;
        }
    }
}
