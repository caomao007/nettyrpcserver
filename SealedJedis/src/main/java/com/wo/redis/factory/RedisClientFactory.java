package com.wo.redis.factory;

import java.io.Closeable;

import com.wo.redis.client.RedisClient;

/**
 * @author ����<zhen.wang@w-oasis.com>
 * @version ����ʱ�䣺2018-7-6 ����5:22:16
 * ˵����
 */

public interface RedisClientFactory<C extends RedisClient>  extends Closeable{
	void build();

    /**
     * �� �󲢷�����£�ʵ�����getResource ������
     * ��� ���� synchronized��
     * ��֤ resource ��һ����
     *
     * @return
     */
    C getResource();

    void returnResource(C client);
}
