import java.util.ArrayList;

class MaxHeap {

    private ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return i * 2 + 1;
    }

    private int right(int i) {
        return i * 2 + 2;
    }

    private void upHeapify(int i) {
        while (i > 0 && heap.get(parent(i)) < heap.get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void downHeapify(int i) {
        int largest = i;
        int l = left(i);
        int r = right(i);

        if (l < heap.size() && heap.get(l) > heap.get(largest))
            largest = l;

        if (r < heap.size() && heap.get(r) > heap.get(largest))
            largest = r;

        if (largest != i) {
            swap(i, largest);
            downHeapify(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(int x) {
        heap.add(x);
        upHeapify(heap.size() - 1);
    }

    public int popMax() {
        if (heap.isEmpty()) {
            System.out.println("Heap is empty!");
            return -1;
        }

        int maxVal = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);

        if (!heap.isEmpty())
            downHeapify(0);

        return maxVal;
    }

    public void printHeap() {
        for (int x : heap)
            System.out.print(x + " ");
        System.out.println();
    }
}

class Main4 {
    public static void main(String[] args) {
        MaxHeap h = new MaxHeap();

        h.insert(15);
        h.insert(3);
        h.insert(27);
        h.insert(9);
        h.insert(42);
        h.insert(18);

        h.printHeap();   // example: 42 27 18 3 9 15

        System.out.println(h.popMax()); // 42
        h.printHeap();

        System.out.println(h.popMax()); // 27
        h.printHeap();
    }
}
