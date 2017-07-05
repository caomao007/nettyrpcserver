package com.xxx.channels;
import java.io.Serializable;

import com.xxx.entities.GloablBean;
import com.xxx.handlers.WebSocketBinaryHandler;
import com.xxx.handlers.WebSocketHandShakeHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
/**
 * 
 * @author wangzhen
 * @emails 2502355536@qq.com
 * 有合作需求请发邮件，非诚勿扰
 */
public class WebSocketChildChannels extends ChannelInitializer<SocketChannel> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6970185295635667552L;
	private GloablBean gloablBean;

	public WebSocketChildChannels(GloablBean gloablBean) {
		this.gloablBean = gloablBean;
	}
	
	protected void initChannel(SocketChannel e) throws Exception {
	 
		e.pipeline().addLast("http-codec", new HttpServerCodec());
		e.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
		e.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
//		e.pipeline().addLast("idlestateHandler",new IdleStateHandler(10, 50, 10));
		e.pipeline().addLast("stringdecoder", new StringDecoder());
		e.pipeline().addLast("stringEncoder", new StringEncoder());
		 e.pipeline().addLast(new ReadTimeoutHandler(15));
	//	 e.pipeline().addLast("codec", new HttpServerCodec());
	//	 e.pipeline().addLast("httpPosthandler",new HttpPostHandler(commonBean));
		 e.pipeline().addLast("webSocketServerHandler",new WebSocketHandShakeHandler(gloablBean));
		 e.pipeline().addLast("binaryMsghandler",new WebSocketBinaryHandler(gloablBean));
	}

}
