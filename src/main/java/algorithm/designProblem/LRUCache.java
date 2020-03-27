package algorithm.designProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU算法实现
 * 使用双向链表记录节点的使用，尾部为最近最少使用的节点
 */
public class LRUCache {
    class Data{
        //双向链表的节点定义
        int key;
        int value;
        Data pre;
        Data next;

        public Data(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public Data(){}
    }

    Map<Integer,Data> cacheMap = new HashMap();
    /**
     * 容量
     */
    int capacity;
    /**
     * 实际已有的数据量
     */
    int size = 0;
    Data head = new Data();
    Data tail = new Data();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 删除节点
     */
    private void removeData(Data data){
        //从双向链表中删除该节点
        Data prev = data.pre;
        Data next = data.next;
        prev.next = next;
        next.pre = prev;
        data.pre = null;
        data.next = null;
    }

    /**
     * 添加数据，往链表头添加
     */
    private void addData(Data data){
        Data next = head.next;
        data.next = next;
        data.pre = head;
        next.pre = data;
        head.next = data;
    }

    /**
     * 删除链表尾部节点并返回
     * @return
     */
    private Data popTail(){
        Data data = tail.pre;
        removeData(data);
        return data;
    }

    public int get(int key) {
        if(cacheMap.containsKey(key)){
            Data data = cacheMap.get(key);
            removeData(data);
            addData(data);
            return data.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(!cacheMap.containsKey(key)){
            //添加时要判断容量是否已满
            if(size == capacity) {
                //空间已满了，删除尾部节点，然后再把新的加到头
                Data lruData = popTail();
                cacheMap.remove(lruData.key);
                size--;
            }
            //添加新的节点到链表头并加入map
            Data data = new Data(key,value);
            addData(data);
            cacheMap.put(key,data);
            size++;
        }else{
            //已经存在则将该节点移动到链表头，并且更新值
            Data data = cacheMap.get(key);
            removeData(data);
            addData(data);
            data.value = value;
        }
    }
}
