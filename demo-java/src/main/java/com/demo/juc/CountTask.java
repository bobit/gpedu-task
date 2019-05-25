package com.demo.juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoin是Java7提供的原生多线程并行处理框架，使用了工作窃取的思想（work-stealing），算法从其他队列中窃取任务来执行，其基本思想是将大任务分割成小任务，最后将小任务聚合起来得到结果。
 * 它非常类似于HADOOP提供的MapReduce框架，只是MapReduce的任务可以针对集群内的所有计算节点，可以充分利用集群的能力完成计算任务。ForkJoin更加类似于单机版的MapReduce。
 *
 * @author: zhangb
 */
public class CountTask extends RecursiveTask<Integer> {
    private static final long serialVersionUID = -3611254198265061729L;

    public static final int threshold = 2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= threshold;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);

            // 执行子任务
            leftTask.fork();
            rightTask.fork();

            //等待任务执行结束合并其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            //合并子任务
            sum = leftResult + rightResult;

        }

        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkjoinPool = new ForkJoinPool();

        //生成一个计算任务，计算1+2+3+4
        CountTask task = new CountTask(1, 100);

        //执行一个任务
        Future<Integer> result = forkjoinPool.submit(task);

        try {
            System.out.println(result.get());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
