class MyHashMap {
    
    private static final int CAPACITY = 10000;
    DataList[] dataList;

    /** Initialize your data structure here. */
    public MyHashMap() {
        dataList = new DataList[CAPACITY];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        if (dataList[index] == null) {
            dataList[index] = new DataList();
        }
        dataList[index].add(new Data(key, value));
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        DataList dl = dataList[index];
        if (dl == null) {
            return -1;
        }
        Data d = dl.getData(key);
        if (d == null) {
            return -1;
        }
        return d.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        DataList dl = dataList[index];
        if (dl == null) {
            return;
        }
        dl.remove(key);
    }
    
    private int getIndex(int key) {
        return key % CAPACITY;
    }
}

class Data {
    public int key;
    public int value;
    
    public Data(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DataList {
    List<Data> list;
    public DataList() {
        list = new LinkedList<>();
    }
    
    public void add(Data data) {
        Data d = getData(data.key);
        if (d == null) {
            list.add(data);
        } else {
            d.value = data.value;
        }
    }
    
    public List<Data> getDataList() {
        return list;
    }
    
    public Data getData(int key) {
        for (Data d : list) {
            if (d.key == key) {
                return d;
            }
        }
        return null;
    }
    
    public void remove(int key) {
        Data d = getData(key);
        if (d != null) {
            list.remove(d);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
