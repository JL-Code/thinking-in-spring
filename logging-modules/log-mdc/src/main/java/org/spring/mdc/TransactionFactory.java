package org.spring.mdc;

import static java.lang.Math.floor;
import static java.lang.Math.random;

/**
 * 模拟的交易工厂
 * <p>创建时间: 2024/3/13 </p>
 *
 * @author <a href="mailto:jiangliu0316@dingtalk.com" rel="nofollow">蒋勇</a>
 */
public class TransactionFactory {
    private static final String[] NAMES = {"John", "Susan", "Marc", "Samantha"};
    private static long nextId = 1;

    public Transfer newInstance() {
        String transactionId = String.valueOf(nextId++);
        String owner = NAMES[(int) floor(random() * NAMES.length)];
        long amount = (long) (random() * 1500 + 500);
        return new Transfer(transactionId, owner, amount);
    }
}
