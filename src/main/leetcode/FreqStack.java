package main.leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class FreqStack {

    int time = 0;

    HashMap<Integer, Integer> freq;

    PriorityQueue<Node> pq;


    class Node {
        int val;
        int freq;
        int time;

        public Node(int _v, int _f, int _t) {
            val = _v;
            freq = _f;
            time = _t;
        }
    }

    public FreqStack() {
        freq = new HashMap<>();
        pq = new PriorityQueue<>((Node a, Node b) -> a.freq == b.freq ? b.time - a.time : b.freq - a.freq);
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        Node n = new Node(x, f, time++);
        pq.add(n);
        freq.put(x, f);
    }

    public int pop() {
        Node n = pq.poll();
        freq.put(n.val, freq.get(n.val)-1);
        return n.val;
    }
}
