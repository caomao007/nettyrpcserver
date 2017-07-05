package com.xxx.handlers;

import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderUtil;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.multipart.MemoryAttribute;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.util.CharsetUtil;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.xxx.entities.GloablBean;
import com.xxx.utils.GlobalConstant;

/**
 * 
 * @author wangzhen
 * @emails 2502355536@qq.com
 * 有合作需求请发邮件，非诚勿扰
 */
public class HttpReqHandler extends ChannelHandlerAdapter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2185360295990734225L;
	private GloablBean gloablBean;

	public HttpReqHandler(GloablBean gloablBean) {
		this.gloablBean = gloablBean;
	}

	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	/**
	 * 读取post消息内容并处理
	 */
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		if (msg instanceof HttpRequest) {
			HttpRequest req = (HttpRequest) msg;
			if (HttpHeaderUtil.is100ContinueExpected(req)) {
				ctx.write(new DefaultFullHttpResponse(HTTP_1_1, CONTINUE));
			}
			boolean keepAlive = HttpHeaderUtil.isKeepAlive(req);
			if (req.uri().equals("/favicon.ico")) {
				return;
			}
			if (req.method().equals(HttpMethod.POST)) {
				if (msg instanceof HttpContent) {
					HttpContent httpContent = (HttpContent) msg;
					ByteBuf content = httpContent.content();
					final StringBuilder buf = new StringBuilder();
					buf.append(content.toString(CharsetUtil.UTF_8));
					String str = buf.toString();//httpclient发来的请求
				 
				} else {
					handleReqMsg(req, msg);
				}
			}
		}
	}

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		responseHandle(ctx, false, GlobalConstant.POST_RESPONSE_STATU_SSUCCESS);
		ctx.close();
	}

	public void handleReqMsg(HttpRequest req, Object msg) {
		HttpPostRequestDecoder decoder = new HttpPostRequestDecoder(
				new DefaultHttpDataFactory(false), req);
		try {
			List<InterfaceHttpData> postList = decoder.getBodyHttpDatas();
			for (InterfaceHttpData data : postList) {
				String name = data.getName();
				String value = null;
				if (InterfaceHttpData.HttpDataType.Attribute == data
						.getHttpDataType()) {
					MemoryAttribute attribute = (MemoryAttribute) data;
					attribute.setCharset(CharsetUtil.UTF_8);
					value = attribute.getValue();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 返回http请求
	 * 
	 * @param ctx
	 * @param keepAlive
	 * @param str
	 */
	public void responseHandle(ChannelHandlerContext ctx, boolean keepAlive,
			String str) {
		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK,
				Unpooled.wrappedBuffer(str.getBytes()));
		response.headers().setInt(CONTENT_LENGTH,
				response.content().readableBytes());
		if (!keepAlive) {
			ctx.write(response).addListener(ChannelFutureListener.CLOSE);
		} else {
			response.headers().set(CONNECTION, HttpHeaderValues.KEEP_ALIVE);
			ctx.write(response);
		}
	}

	private void handleCmdHttpRequest(String mPilesId, ByteBuf content,
			boolean keepAlive, ChannelHandlerContext ctx) {
	  
	

	}
	
	
	
}
