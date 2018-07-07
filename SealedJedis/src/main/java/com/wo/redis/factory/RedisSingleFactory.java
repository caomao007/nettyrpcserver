package com.wo.redis.factory;

import java.io.IOException;

import com.wo.redis.client.RedisSingleClient;

/**
 * @author 王震<zhen.wang@w-oasis.com>
 * @version 创建时间：2018-7-6 下午4:32:32
 * 说明：
 */

public class RedisSingleFactory implements RedisClientFactory<RedisSingleClient>{

	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void build() {
		// TODO Auto-generated method stub
		
	}

	public RedisSingleClient getResource() {
		// TODO Auto-generated method stub
		return null;
	}

	public void returnResource(RedisSingleClient client) {
		// TODO Auto-generated method stub
		
	}

	

}
