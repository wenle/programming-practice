package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * date 16/6/24
 *
 * @author wbao
 */
public class ForkJoinSum {

    private final ForkJoinPool forkJoinPool = new ForkJoinPool();

    public int sum(int[] numbers) {

        return forkJoinPool.invoke(new ForkJoinSumTask(numbers, 0, numbers.length-1));
    }


    class ForkJoinSumTask extends RecursiveTask<Integer> {

        private int[] numbers;
        private int from;
        private int to;

        public ForkJoinSumTask(int[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Integer compute() {

            System.out.println("from index: " + from + "; to index : " + to);
            List<ForkJoinSumTask> forks = new ArrayList<>();
            if(from > to) {
                return 0;
            }
            if(to-from > 1) {
                int index = (from+to) / 2;
                ForkJoinSumTask task1 = new ForkJoinSumTask(numbers, from, index);
                ForkJoinSumTask task2 = new ForkJoinSumTask(numbers, index+1, to);
                forks.add(task1);
                forks.add(task2);
                task1.fork();
                task2.fork();
            } else if (from == to) {
                return numbers[from];
            } else {
                return numbers[from] + numbers[to];
            }

            int total = 0;
            for(ForkJoinSumTask task : forks) {
                total += task.join();
            }
            return total;
        }
    }

    public static void main(String[] args) {

        int[] numbers = new int[]{1,2,3,4,5,6,7,8,9,10};
        ForkJoinSum forkJoinSum = new ForkJoinSum();
        System.out.println("The total is " + forkJoinSum.sum(numbers));
    }

}
