package com.xxx.channels;

import java.io.Serializable;

import com.xxx.entities.GloablBean;
import com.xxx.handlers.HttpReqHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
/**
 * 
 * @author wangzhen
 * @emails 2502355536@qq.com
 * 有合作需求请发邮件，非诚勿扰
 */
public class HttpReqChildChannels extends ChannelInitializer<SocketChannel> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1932627197782137000L;
	private GloablBean gloablBean;
	public HttpReqChildChannels(GloablBean gloablBean) {
		this.gloablBean = gloablBean;
	}

	public void initChannel(SocketChannel ch) throws Exception {

		ChannelPipeline p = ch.pipeline();
		// Uncomment the following line if you want HTTPS
		// SSLEngine engine =
		// SecureChatSslContextFactory.getServerContext().createSSLEngine();
		// engine.setUseClientMode(false);
		// p.addLast("ssl", new SslHandler(engine));
		// p.addLast("codec", new HttpServerCodec());
		// p.addLast("encode", new HttpRequestDecoder());
		// p.addLast("decode", new HttpResponseDecoder());
		p.addLast("http-codec", new HttpServerCodec());
		p.addLast("aggregator", new HttpObjectAggregator(65536)); 
		p.addLast("http-chunked", new ChunkedWriteHandler()); 
		p.addLast("handler", new HttpReqHandler(gloablBean));
	}
	
}
