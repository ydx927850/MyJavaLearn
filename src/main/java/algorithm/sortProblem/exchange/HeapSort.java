package algorithm.sortProblem.exchange;

import util.MyUtil;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author Yandx
 * @version 1.0
 * @date created on 2019/7/11 14:04
 */
public class HeapSort {
    private static int heapSize;

    public static void main(String[] args) {
        int[] nums = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 维持最大堆的性质
     * T(n)=O(lgn)
     *
     * @param heap
     * @param i
     */
    private static void maxHeapify(int[] heap, int i) {
        int left = left(i) + 1;
        int right = right(i) + 1;
        int largest;
        if (left <= heapSize && heap[left] > heap[i]) {
            largest = left;
        } else {
            largest = i;
        }
        if (right <= heapSize && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != i) {
            //交换
            MyUtil.swap(heap, largest, i);
            //交换可能导致之后的子树不满足最大堆性质，因此对新的根节点递归调用维护最大堆方法
            maxHeapify(heap, largest);
        }
    }

    /**
     * 建立最大堆
     * 子数组A([n/2]+1,n)中的元素都是叶子节点，每个叶子节点可以看成只包含一个元素的堆，因此只需要对之前的元素调用一次维护最大堆的性质即可生成整体的最大堆
     * T(n)=O(n)
     *
     * @param heap
     */
    private static void buildMaxHeap(int[] heap) {
        heapSize = heap.length - 1;
        for (int i = heap.length / 2 - 1; i >= 0; i--) {
            maxHeapify(heap, i);
        }
    }

    /**
     * 堆排序
     * 每次将根节点（最大值）和堆顶交换元素，然后以第一层节点为根维护最大堆性质，每次交换后，让有效堆长度减1，直到有效堆长度为2时完成最后一次交换
     * T(n)=O(nlgn)
     *
     * @param heap
     */
    private static void heapSort(int[] heap) {
        buildMaxHeap(heap);
        for (int i = heap.length - 1; i >= 1; i--) {
            MyUtil.swap(heap, i, 0);
            heapSize--;
            maxHeapify(heap, 0);
        }
    }

    private static int parent(int i) {
        return i / 2;
    }

    private static int left(int i) {
        return 2 * i;
    }

    private static int right(int i) {
        return 2 * i + 1;
    }


}
