package com.wo.redis.client;

import java.io.Closeable;
import redis.clients.jedis.BasicCommands;
import redis.clients.jedis.JedisCommands;

/**
 * @author ����<zhen.wang@w-oasis.com>
 * @version ����ʱ�䣺2018-7-6 ����4:55:02
 * ˵����
 */

public interface RedisClient extends JedisCommands, BasicCommands, Closeable {

}
