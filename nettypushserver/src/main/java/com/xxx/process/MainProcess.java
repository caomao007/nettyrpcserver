package com.xxx.process;

import com.xxx.entities.GloablBean;
import com.xxx.servers.HttpReqServer;
import com.xxx.servers.WebSocketServer;

import io.netty.channel.local.LocalAddress;

/**
 * 
 * @author wangzhen
 * @emails 2502355536@qq.com
 * 有合作需求请发邮件，非诚勿扰
 */
public class MainProcess {
	
	
	public static void main(String[] args) {
		GloablBean gloablBean=new GloablBean(); 	 
        new Thread(new HttpReqServer(gloablBean)).start();
        new Thread(new WebSocketServer(gloablBean)).start();

	}
	
	

}
