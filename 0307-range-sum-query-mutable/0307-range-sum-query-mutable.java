class NumArray {
    class SegmentTree{
        private static class Node{
            int data;
            int startInterval;
            int endInterval;
            Node left;
            Node right;
            public Node(int val){
                this.data = val;
            }
            public Node(int startInterval, int endInterval){
                this.startInterval = startInterval;
                this.endInterval = endInterval;
            }
        }
        private Node root;

        public SegmentTree(int[] nums){
            //Create tree using this arr
            this.root = constructTree(nums, 0, nums.length-1);
        }

        private Node constructTree(int[] arr, int start, int end){
            if(start == end){
                //leaf node
                Node leaf = new Node(start, end);
                leaf.data = arr[start];
                return leaf;
            }
            //creation of new node with index you are at
            Node node = new Node(start, end);

            int mid = start + (end - start)/2;

            node.left = constructTree(arr, start, mid);
            node.right = constructTree(arr, mid+1, end);

            node.data = node.left.data + node.right.data;
            return node;
        }

        public int query(int qsi, int qei){
            return query(root, qsi, qei);
        }

        private int query(Node node, int qsi, int qei){
            if(node.startInterval >= qsi && node.endInterval <= qei){
                //Completely lying in the interval
                return node.data;
            }
            else if(node.startInterval > qei || node.endInterval < qsi){
                //Not lying in the interval
                return 0;
            }
            else{
                //Overlaping in the interval
                return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
            }
        }

        public void update(int index, int value){
            this.root.data = update(this.root, index, value);
        }

        private int update(Node node, int index, int value){
            if(node.startInterval <= index && index <= node.endInterval){
                if(node.startInterval == index && index == node.endInterval){
                    node.data = value;
                    return node.data;
                }
                else{
                    int leftAns = update(node.left, index, value);
                    int rightAns = update(node.right, index, value);

                    node.data = leftAns + rightAns;
                    return node.data;
                }
            }
            return node.data;
        }
    }

    private SegmentTree st; //making it as a instance variable

    public NumArray(int[] nums) {
        st = new SegmentTree(nums);
    }
    
    public void update(int index, int val) {
        st.update(index, val);
    }
    
    public int sumRange(int left, int right) {
        return st.query(left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */