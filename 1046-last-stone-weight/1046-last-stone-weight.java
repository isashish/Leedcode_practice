class Solution {
    class MaxHeap {
        private ArrayList<Integer> list;

        public MaxHeap(){
            list = new ArrayList<>();
        }

        private void swap(int first, int second){
            int temp = list.get(first);
            list.set(first, list.get(second));
            list.set(second, temp);
        }

        private int parent(int idx){
            return (idx - 1)/2;
        }

        private int left(int idx){
            return 2*idx + 1;
        }

        private int right(int idx){
            return 2*idx + 2;
        }

        public void insert(int value){
            list.add(value);
            upheap(list.size() - 1);
        }

        private void upheap(int index){
            if(index == 0){
                return;
            }
            int p = parent(index);
            if(list.get(index) > list.get(p)){
                swap(index, p);
                upheap(p);
            }
        }

        public int remove(){
            // if(list.isEmpty()){
            //     throw new Exception("Removing from an empty list!");
            // }
            int temp = list.get(0);
            int last = list.remove(list.size()-1);

            if(!list.isEmpty()){
                list.set(0, last);
                downheap(0);
            }
            return temp;
        }

        private void downheap(int index){
            int max = index;
            int left = left(index);
            int right = right(index);

            if(left < list.size() && list.get(max) < list.get(left)){
                max = left;
            }
            if(right < list.size() && list.get(max) < list.get(right)){
                max = right;
            }

            if(max != index){
                swap(max, index);
                downheap(max);
            }
        }
        public int heapSize(){
            return list.size();
        }
    }
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1){
            return stones[0];
        }
        MaxHeap maxHeap = new MaxHeap();
        for(int i = 0; i < stones.length; i++){
            maxHeap.insert(stones[i]);
        }

        while(maxHeap.heapSize() > 1){
            int first = maxHeap.remove();
            int second = maxHeap.remove();
            if(first != second){
                if(first > second){
                    maxHeap.insert(first - second);
                }
                else{
                    maxHeap.insert(second - first);
                }
            }
        }

        if(maxHeap.heapSize() != 0){
            return maxHeap.remove();
        }

        return 0;
    }
}