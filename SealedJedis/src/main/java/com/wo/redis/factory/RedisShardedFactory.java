package com.wo.redis.factory;

import java.io.IOException;

import com.wo.redis.client.RedisShardedClient;

/**
 * @author ����<zhen.wang@w-oasis.com>
 * @version ����ʱ�䣺2018-7-6 ����4:33:21
 * ˵����
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
