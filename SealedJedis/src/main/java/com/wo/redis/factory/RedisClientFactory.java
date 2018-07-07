package com.wo.redis.factory;

import java.io.Closeable;

import com.wo.redis.client.RedisClient;

/**
 * @author 王震<zhen.wang@w-oasis.com>
 * @version 创建时间：2018-7-6 下午5:22:16
 * 说明：
 */

public interface RedisClientFactory<C extends RedisClient>  extends Closeable{
	void build();

    /**
     * 在 大并发情况下，实现类的getResource 方法，
     * 务必 加上 synchronized，
     * 保证 resource 的一致性
     *
     * @return
     */
    C getResource();

    void returnResource(C client);
}
