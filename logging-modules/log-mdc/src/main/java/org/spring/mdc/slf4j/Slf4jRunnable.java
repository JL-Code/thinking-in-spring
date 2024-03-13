package org.spring.mdc.slf4j;

import org.slf4j.MDC;
import org.spring.mdc.Transfer;

/**
 * Slf4j 多线程接口实现
 * <p>创建时间: 2024/3/13 </p>
 *
 * @author <a href="mailto:jiangliu0316@dingtalk.com" rel="nofollow">蒋勇</a>
 */
public class Slf4jRunnable implements Runnable {
    private final Transfer tx;

    public Slf4jRunnable(Transfer tx) {
        this.tx = tx;
    }

    public void run() {

        MDC.put("transaction.id", tx.getTransactionId());
        MDC.put("transaction.owner", tx.getSender());

        new Slf4TransferService().transfer(tx.getAmount());

        // MDC.clear(); We don't need this with MdcAwareThreadPoolExecutor

    }
}
