package com.xxx.servers;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import com.xxx.channels.WebSocketChildChannels;
import com.xxx.entities.GloablBean;

/**
 * @author wangzhen
 * @emails 2502355536@qq.com
 * 有合作需求请发邮件，非诚勿扰
 */
public class WebSocketServer implements Runnable {

	private GloablBean gloablBean;

	public WebSocketServer(GloablBean gloablBean) {
		this.gloablBean = gloablBean;
	}

	public void run() {

		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workGroup);
			b.channel(NioServerSocketChannel.class);
			b.childHandler(new WebSocketChildChannels(gloablBean));
			Channel ch = b.bind(9090).sync().channel();
			ch.closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}

	}

}
