class MedianFinder {

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (maxQ.isEmpty() || maxQ.peek() > num)
                maxQ.add(num);

            else
                minQ.add(num);

            if (maxQ.size() > minQ.size() + 1) {
                minQ.add(maxQ.poll());
            } else if(minQ.size() > maxQ.size() + 1)
                maxQ.add(minQ.poll());
        }

        public double findMedian() {
            int total = minQ.size() + maxQ.size();
            if (total % 2 == 0)
                return (double) (minQ.peek() + maxQ.peek()) / 2;
            else {
                return minQ.size() > maxQ.size() ? minQ.peek() : maxQ.peek();
            }

        }
    }