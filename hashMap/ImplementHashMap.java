package hashMap;

import java.util.ArrayList;
import java.util.LinkedList;

class ImplementHashMap {

    static class HashMap<K, V> {

        private LinkedList<HMNode>[] buckets; // N - size of bucket
        int size = 0; // n - no. of key value pairs

        static final double LAMBDA_CONSTANT = 2.0;

        HashMap() {
            initBuckets(4); // size of buckets / linked list
            size = 0;

        }

        private void initBuckets(int N) {
            buckets = new LinkedList[N];

            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        class HMNode {
            V value;
            K key;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = getIndexWithInBucket(key, bi);

            if (di != -1) {
                // update
                HMNode node = buckets[bi].get(di);
                node.value = value;
            } else {
                // insert
                buckets[bi].add(new HMNode(key, value));
                size++;
            }

            // check for lambda value to call rehash function
            double lambda = size * 0.1 / buckets.length;
            if (lambda > LAMBDA_CONSTANT) {
                rehash();
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = getIndexWithInBucket(key, bi);

            if (di != -1) {
                // key found
                size--;
                return buckets[bi].remove(di).value;
            } else {
                // not found
                return null;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = getIndexWithInBucket(key, bi);

            if (di != -1) {
                // key found
                return buckets[bi].get(di).value;
            } else {
                // not found
                return null;
            }
        }

        public boolean countainsKey(K key) {
            int bi = hashFunction(key);
            int di = getIndexWithInBucket(key, bi);

            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> list = new ArrayList<>();

            for (LinkedList<HMNode> bucket : buckets) {
                for (HMNode node : bucket) {
                    list.add(node.key);
                }
            }

            return list;
        }

        public int size() {
            return size;
        }

        public void rehash() {
            LinkedList<HMNode>[] oldBucketArray = buckets;

            initBuckets(oldBucketArray.length * 2);
            size = 0;

            // add all key and value pairs
            for (LinkedList<HMNode> bucket : oldBucketArray) {
                for (HMNode node : bucket) {
                    put(node.key, node.value);
                }
            }
        }

        private int hashFunction(K key) {
            int hashCode = key.hashCode();
            return Math.abs(hashCode) % buckets.length; // hashcode abs value % N - no. of buckets
        }

        private int getIndexWithInBucket(K key, int bi) {
            LinkedList<HMNode> bucket = buckets[bi];

            int di = 0;
            for (HMNode n : bucket) {
                if (n.key.equals(key)) {
                    return di;
                }
                di++;
            }

            return -1;
        }
    }

    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 120);
        hm.put("US", 130);
        hm.put("India", 110);
        hm.put("China", 140);

        System.out.println(hm.size());
        System.out.println(hm.get("India"));
        System.out.println(hm.get("US"));
        System.out.println(hm.get("China"));
        System.out.println(hm.keySet());
        System.out.println(hm.remove("China"));
        System.out.println(hm.size);
    }
}