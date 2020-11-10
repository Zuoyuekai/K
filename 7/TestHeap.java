package K_7;

import java.util.Arrays;

public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void adjustDown ( int parent, int len ) {
        int child = parent*2+1;
        while ( child < len ) {
            if ( child+1 < len && this.elem[child] < this.elem[child+1] ) {
                child++;
            }
            if ( this.elem[child] > this.elem[parent] ){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child;
                child = child*2+1;
            }else {
                break;
            }
        }
    }

    public void initHeap (int[] array) {
        for (int i = 0; i < array.length ; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }

        for (int i = (usedSize-1-1)/2; i >= 0; i--) {
            adjustDown( i, usedSize );
        }
        System.out.println("===========================");
    }

    public void adjustUp (int child) {
        int parent = (child-1)/2;
        while (child > 0) {
            if (this.elem[child] > this.elem[parent]) {
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    public boolean isFull() {
        return  this.usedSize == this.elem.length;
    }

    public void push(int val) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2*elem.length);
        }

        this.elem[this.usedSize] = val;
        this.usedSize++;
        adjustUp(this.usedSize-1);
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }

        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        this.elem[this.usedSize-1] = tmp;
        this.usedSize--;

        adjustDown(0,this.usedSize);
        System.out.println("============================");
    }




}
