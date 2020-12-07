import java.util.List;

public class SuperList<E>{

    private ListNode<E> root;
    private ListNode<E> end;
    private int size;


    public SuperList(){
        root = null;
        end = null;
        size = 0;
    }

    public void add(E value){    //adds value to the end of the list

        ListNode<E> newNode = new ListNode<E>(value);

        //1. List is empty
        if(root == null){
            root = newNode;
            end = root;
        }

        //2. List is not empty
        else{
            end.setNext(newNode);
            newNode.setPrevious(end);
            end = newNode;
        }
        size++;

    }

    public void add(int index, E value){   //adds value to any index in the list

        ListNode<E> newNode = new ListNode<>(value);

        if(index == size){
            add(value);
        }

        else if(index == 0){   //add value at index 0
            newNode.setNext(root);
            root.setPrevious(newNode);
            root = newNode;
            size++;
        }

        else if (0 < index && index < size){    //add value in middle somewhere
            ListNode<E> temp = root;
            for(int i=0; i<size; i++){
                if (i == index){

                    ListNode<E> prev = temp.getPrevious();
                    ListNode<E> next = temp;

                    prev.setNext(newNode);

                    newNode.setPrevious(prev);
                    newNode.setNext(next);

                    next.setPrevious(newNode);
                    size++;
                    break;
                }
                temp = temp.getNext();
            }
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void push(E value){    //adds value to end of the list

        add(value);
    }

    public E pop() {   //gets last index and removes it

        E temp = end.getValue();
        if(size == 1){
            clear();
            return temp;
        }
        end = end.getPrevious();
        size--;
        return temp;
    }

    public E poll(){    //gets 0 index and removes it

        E temp = root.getValue();
        if(size == 1){
            clear();
            return temp;
        }
        root = root.getNext();
        size--;
        return temp;
    }

    public E stackPeek(){    //peeks at last index

        return end.getValue();
    }

    public E queuePeek(){    //peeks at 0 index

        return root.getValue();
    }

    public E get(int index){   //gets at any index

        ListNode<E> temp = root;

        for(int i=0; i<size; i++){
            if(i == index){
                return temp.getValue();
            }
            temp = temp.getNext();
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size(){

        return size;
    }

    public E remove(int index){     //removes an index from the list

        if(index == 0){
            return poll();
        }
        if(index == size-1){
            return pop();
        }

        ListNode<E> temp = root;

        for(int i=0; i<size; i++){
            if(i == index){
                ListNode<E> prev = temp.getPrevious();
                ListNode<E> next = temp.getNext();

                prev.setNext(next);
                next.setPrevious(prev);

                size--;

                return temp.getValue();
            }
            temp = temp.getNext();
        }

        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty(){    //checks to see if empty
        return (size == 0);
    }

    public void clear(){    //empties the list
        root = null;
        end = null;
        size = 0;
    }

    public boolean contains(E value){    //checks to see if list contains a value

        ListNode<E> newNode = new ListNode<>(value);

        ListNode<E> temp = root;
        for(int i=0; i<size; i++){
            if(newNode.getValue().equals(temp.getValue())){
                return true;
            }
            temp = temp.getNext();
        }

        return false;
    }

    public String toString(){   //print

        String st = "[";

        try {
            ListNode<E> temp = root;
            for (int i = 0; i < size; i++) {
                st += temp.getValue();
                if (i < size - 1) {
                    st += ", ";
                }
                temp = temp.getNext();
            }
        }catch(NullPointerException e){

        }
        st += "]";
        return st;
    }

    public class ListNode<E>{
        private E value;
        private ListNode<E> next;
        private ListNode<E> previous;

        public ListNode(E value){

            this.value = value;
            next = null;
            previous = null;
        }
        public E getValue(){
            return value;
        }
        public ListNode<E> getNext(){
            return next;
        }
        public ListNode<E> getPrevious(){
            return previous;
        }
        public void setNext(ListNode<E> newNode){
            next = newNode;
        }
        public void setPrevious(ListNode<E> newNode){
            previous = newNode;
        }
    }
}
