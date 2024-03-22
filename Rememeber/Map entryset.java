 for(Map.Entry<Integer,Integer> entry:map.entrySet())
            ans.add(entry.getValue());

TreeMap lowerKey()
numMap.lowerKey(7);

TreeMap higherKey()
treemap.higherKey(3);



  public void assign(K keyBegin, K keyEnd, V val) {
        if (keyBegin.compareTo(keyEnd) >= 0) {
            return; // Empty interval, do nothing
        }

        // Remove existing mappings in the interval
        map.subMap(keyBegin, keyEnd).clear();
        map.put(keyBegin, val);
        map.put(keyEnd, map.getOrDefault(keyEnd, valBegin));
    }

    public V get(K key) {
        Map.Entry<K, V> entry = map.floorEntry(key);
        return entry != null ? entry.getValue() : valBegin;
    }
