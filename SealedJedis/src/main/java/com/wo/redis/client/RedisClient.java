package com.wo.redis.client;

import java.io.Closeable;
import redis.clients.jedis.BasicCommands;
import redis.clients.jedis.JedisCommands;

/**
 * @author 王震<zhen.wang@w-oasis.com>
 * @version 创建时间：2018-7-6 下午4:55:02
 * 说明：
 */

public interface RedisClient extends JedisCommands, BasicCommands, Closeable {

}
