package com.goat.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class RetryService {
    private final static Logger logger = LoggerFactory.getLogger(RetryService.class);

    /**
         * @Description: 功能描述：(这里用一句话描述这个方法的作用)
         * @author: Goat
         * @Param: value:发生指定的异常时进行重试
         * @Param: maxAttempts 最大重试次数 默认 3
         * @Param: backoff 重试补偿机制，默认没有
         * @Param: delay  每次重试的时间间隔
         * @Param: multiplier 指定延迟的倍数，比如delay=5000l,multiplier=2时，第一次重试为5秒后，第二次为10秒，第三次为20秒
         * @Return:
         * @Date:   2018/12/4
     *
     *      @Retryable注解 被注解的方法发生异常时会重试
     *      value：指定发生的异常进行重试
     *      include：和 value 一样，默认空，当exclude也为空时，所有异常都重试
     *      exclude：指定异常不重试，默认空，当include也为空时，所有异常都重试
     *      maxAttemps：重试次数，默认3
     *      backoff：重试补偿机制，默认没有  delay 每隔几秒进行重试  in milliseconds (default 1000)
     *      multiplier：指定延迟的倍数，比如delay=5000l,multiplier=2时，第一次重试为5秒后，第二次为10秒，第三次为20秒
    */
    @Retryable(value = {RemoteAccessException.class}, maxAttempts = 4, backoff = @Backoff(delay = 500L, multiplier = 1))
    public void retry() {
        logger.info(LocalTime.now() + " 执行业务操作...");
        throw new RemoteAccessException("RPC调用异常");
    }

    /**
     * 当重试到达指定次数时，被注解的方法将被回调，可以在该方法中进行日志处理。需要注意的是发生的异常和入参类型一致时才会回调
         @Retryable 注解方法返回值是void，@Recover才会生效
         @Recover 来开启重试失败后调用的方法(注意,需跟重处理方法在同一个类中)
    */
    @Recover
    public void recover(RemoteAccessException e) {
        logger.info(e.getMessage());
        logger.info("@Recover 执行............................. ");
    }
}
