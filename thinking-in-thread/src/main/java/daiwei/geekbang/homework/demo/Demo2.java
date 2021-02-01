package daiwei.geekbang.homework.demo;

import daiwei.geekbang.homework.common.TaskResult;
import daiwei.geekbang.homework.common.TaskThread;

import java.util.concurrent.TimeUnit;

/**
 * thread + loopCheck
 * Created by Daiwei on 2021/2/1
 */
public class Demo2 {

    public static void main(String[] args) throws Exception {

        long start=System.currentTimeMillis();

        TaskResult res = new TaskResult();

        new TaskThread(res).start();

        //循环校验值是否已经返回
        while (true) {
            if (res.isDone()) {
                break;
            }
        }

        Integer result = res.getRes();

        System.out.println("异步计算结果为："+ result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }
}
