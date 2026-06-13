class Solution {
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
    }

    private SegmentTree st;

    public int subarraySum(int[] nums) {
        st = new SegmentTree(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans += st.query(Math.max(0, i-nums[i]), i);
        }
        return ans;  
    }
}