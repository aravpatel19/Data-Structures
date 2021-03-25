public class TreeSetTaskRunner {

    public TreeSetTaskRunner(){

        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(10);
        tree.add(6);
        tree.add(12);
        tree.add(3);
        tree.add(7);
        tree.add(15);
        tree.add(4);
        tree.add(5);
        tree.add(10);
        tree.add(11);
        tree.add(19);
        System.out.println(tree.preOrderTraversal());
    }
    public class TreeSet<E extends Comparable<E>>{

        private TreeNode root;
        private int size=0;
        private String str;   //for toString recursive methods


        public void add(E value){
            if(root == null){
                root = new TreeNode(value);
                size++;
            }
            else{
                add(value, root);
            }
        }
        public void add(E value, TreeNode<E> root){
            if(root.getValue().equals(value)){
                return;
            }

            //left
            else if(value.compareTo(root.getValue()) < 0){
                if(root.getLeft() == null) {
                    root.setLeft(new TreeNode(value));
                    size++;
                    return;
                }
                else{
                    add(value, root.getLeft());
                }
            }
            //right
            else{
                if(root.getRight() == null){
                    root.setRight(new TreeNode(value));
                    size++;
                    return;
                }
                else{
                    add(value, root.getRight());
                }
            }
        }
        public void remove(){

        }
        public int size(){
            return size;
        }
        public String preOrderTraversal(){
            if(size == 0){
                return "[]";
            }
            str = "[";
            str += preOrderTraversal(root);

            return str.substring(1, str.length()-2) + "]";
        }
        String preOrderTraversal(TreeNode root){
            if(root != null){
                str += root.getValue() + ", ";
                preOrderTraversal(root.getLeft());
                preOrderTraversal(root.getRight());
            }
            return str;
        }


        public class TreeNode<E extends Comparable<E>>{
            private TreeNode leftNode;
            private TreeNode rightNode;
            private E value;
            public TreeNode(E value){
                this.value = value;
                this.leftNode = null;
                this.rightNode = null;
            }
            public TreeNode getRight(){
                return rightNode;
            }
            public TreeNode getLeft(){
                return leftNode;
            }
            public void setRight(TreeNode node){
                this.rightNode = node;
            }
            public void setLeft(TreeNode node){
                this.leftNode = node;
            }
            public E getValue(){
                return value;
            }
            public String toString(){
                return (String) value;
            }
        }
    }

    public static void main(String[]args){
        TreeSetTaskRunner app = new TreeSetTaskRunner();
    }
}
