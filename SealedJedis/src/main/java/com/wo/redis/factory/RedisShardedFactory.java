package com.wo.redis.factory;

import java.io.IOException;

import com.wo.redis.client.RedisShardedClient;

/**
 * @author 王震<zhen.wang@w-oasis.com>
 * @version 创建时间：2018-7-6 下午4:33:21
 * 说明：
 */

public class RedisShardedFactory implements RedisClientFactory<RedisShardedClient>{

	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void build() {
		// TODO Auto-generated method stub
		
	}

	public RedisShardedClient getResource() {
		// TODO Auto-generated method stub
		return null;
	}

	public void returnResource(RedisShardedClient client) {
		// TODO Auto-generated method stub
		
	}


}
