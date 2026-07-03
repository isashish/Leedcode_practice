class KthLargest {
    ArrayList<Integer> list = new ArrayList<>();
    int k;

    private void swap(int first, int second) {
        int temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    public void insert(int val) {
        list.add(val);
        upheap(list.size() - 1);
    }

    private void upheap(int index) {
        if (index == 0) {
            return;
        }
        int p = parent(index);
        if (list.get(index) < list.get(p)) {
            swap(index, p);
            upheap(p);
        }
    }

    public int remove() {
        int temp = list.get(0);
        int last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }
        return temp;
    }

    private void downheap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(min) > list.get(left)) {
            min = left;
        }
        if (right < list.size() && list.get(min) > list.get(right)) {
            min = right;
        }

        if (min != index) {
            swap(min, index);
            downheap(min);
        }
    }

    public KthLargest(int k, int[] nums) {
        for (int num : nums) {
            insert(num);

            if (list.size() > k) {
                remove();
            }
        }
        this.k = k;
    }

    public int add(int val) {
        insert(val);

        if (list.size() > k) {
            remove();
        }

        return list.get(0);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */