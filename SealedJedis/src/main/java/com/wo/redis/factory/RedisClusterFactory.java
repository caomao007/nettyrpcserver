package com.wo.redis.factory;

import java.io.IOException;

import com.wo.redis.client.RedisClusterClient;

/**
 * @author ����<zhen.wang@w-oasis.com>
 * @version ����ʱ�䣺2018-7-6 ����4:33:01
 * ˵����
 */

public class RedisClusterFactory implements RedisClientFactory<RedisClusterClient>{

	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void build() {
		// TODO Auto-generated method stub
		
	}

	public RedisClusterClient getResource() {
		// TODO Auto-generated method stub
		return null;
	}

	public void returnResource(RedisClusterClient client) {
		// TODO Auto-generated method stub
		
	}

	

}
