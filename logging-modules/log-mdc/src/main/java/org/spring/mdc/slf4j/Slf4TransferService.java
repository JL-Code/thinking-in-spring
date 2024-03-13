package org.spring.mdc.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.mdc.TransferService;


/**
 * <p>创建时间: 2024/3/13 </p>
 *
 * @author <a href="mailto:jiangliu0316@dingtalk.com" rel="nofollow">蒋勇</a>
 */
public class Slf4TransferService extends TransferService {

    private static final Logger logger = LoggerFactory.getLogger(Slf4TransferService.class);

    @Override
    protected void beforeTransfer(long amount) {
        logger.info("Preparing to transfer {}$.", amount);
    }

    @Override
    protected void afterTransfer(long amount, boolean outcome) {
        logger.info("Has transfer of {}$ completed successfully ? {}.", amount, outcome);
    }
}
