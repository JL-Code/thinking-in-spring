package org.spring.mdc;

import org.spring.mdc.pool.MdcAwareThreadPoolExecutor;
import org.spring.mdc.slf4j.Slf4jRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.MINUTES;

/**
 * 入口类
 * <p>创建时间: 2024/3/13 </p>
 *
 * @author <a href="mailto:jiangliu0316@dingtalk.com" rel="nofollow">蒋勇</a>
 */
public class Entry {
    public static void main(String[] args) {
        ExecutorService executor = new MdcAwareThreadPoolExecutor(3,
                3,
                0,
                MINUTES,
                new LinkedBlockingQueue<>(),
                Thread::new,
                new ThreadPoolExecutor.AbortPolicy());

        TransactionFactory transactionFactory = new TransactionFactory();

        for (int i = 0; i < 10; i++) {
            Transfer tx = transactionFactory.newInstance();

            Runnable task = new Slf4jRunnable(tx);

            executor.submit(task);
        }

        executor.shutdown();

    }
}
