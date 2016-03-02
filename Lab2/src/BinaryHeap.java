import GraphPack.Vertex;

import java.util.List;

public class BinaryHeap {
    private List<Vertex> keys;

    public void siftDown(int i) {
        while ((2 * i + 1) > (this.keys.size() - 1)) {
            int right = 2 * i + 2;
            int left = 2 * i + 1;
            int cur = left;
            if (right < (this.keys.size() - 1)) {
                cur = right;
            }
            if (this.keys.get(i).key > this.keys.get(cur).key) {
                break;
            }
            swap(i, cur);
            i = cur;
        }
    }

    public void siftUp(int i) {
        while ((i > 0) && (keys.get(i).key < keys.get((i - 1) / 2).key)) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public Vertex extractMin() {
        Vertex min = this.keys.get(0);
        this.keys.set(0,this.keys.get(this.keys.size()-1));
        this.keys.remove(this.keys.size()-1);
        siftDown(0);
        return min;
    }

    public void add(Vertex vertex) {
        this.keys.add(vertex);
        this.siftUp(this.keys.size() - 1);
    }

    void swap(int i, int j) {
        Vertex buff = this.keys.get(i);
        this.keys.set(i, this.keys.get(j));
        this.keys.set(j, buff);
    }
}
