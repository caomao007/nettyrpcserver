package com.xxx.servers;

import com.xxx.channels.HttpReqChildChannels;
import com.xxx.entities.GloablBean;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
/**
 * 
 * @author wangzhen
 * @emails 2502355536@qq.com
 * 有合作需求请发邮件，非诚勿扰
 */
public class HttpReqServer implements Runnable{

	private GloablBean gloablBean;
	
	public HttpReqServer(GloablBean gloablBean){
		this.gloablBean=gloablBean;
	}
	
	public void run() {
	  /**
	   * Netty内部都是通过线程在处理各种数据，EventLoopGroup就是用来管理调度他们的，注册Channel，管理他们的生命周期
	   */
		EventLoopGroup  bossGroup=new NioEventLoopGroup();
		EventLoopGroup  workGroup=new NioEventLoopGroup();
		
		try {
			
			ServerBootstrap b=new ServerBootstrap();
			b.group(bossGroup, workGroup);////设置循环对象，前者用来处理accept事件，后者用于处理已经建立的连接的io  
			b.channel(NioServerSocketChannel.class);// //用它来建立新accept的连接，用于构造serversocketchannel的工厂类  
			b.childHandler(new HttpReqChildChannels(gloablBean));////当新连接accept的时候，这个方法会调用  
			Channel ch = b.bind(9000).sync().channel(); //会为其绑定本地端口，并对其进行初始化，为其的pipeline加一些默认的handler  
			ch.closeFuture().sync();// 相当于在这里阻塞，直到serverchannel关闭 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
		
	}

}
