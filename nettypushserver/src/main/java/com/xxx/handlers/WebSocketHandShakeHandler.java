package com.xxx.handlers;

import java.io.Serializable;
import java.nio.charset.Charset;
import com.xxx.entities.GloablBean;
import com.xxx.utils.GlobalConstant;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;
/**
 * 
 * @author wangzhen
 * @emails 2502355536@qq.com
 * 有合作需求请发邮件，非诚勿扰
 */

public class WebSocketHandShakeHandler extends SimpleChannelInboundHandler<Object> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6765032524878802955L;
	private WebSocketServerHandshaker handshaker;
	private GloablBean gloablBean;
	public WebSocketHandShakeHandler(GloablBean gloablBean) {
		this.gloablBean = gloablBean;
	}

	public void channelActive(ChannelHandlerContext ctx) {
		ctx.fireChannelActive();
	}

	public void channelInactive(ChannelHandlerContext ctx) {
	String	  channelId=ctx.channel().id().asLongText();
	}

	/**
	 * 接收消息
	 */
	protected void messageReceived(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		if (msg instanceof FullHttpRequest) {
			handleHttpRequest(ctx, ((FullHttpRequest) msg));
		} else if (msg instanceof WebSocketFrame) {
			handlerWebSocketFrame(ctx, (WebSocketFrame) msg);
		}
	}

	/**
	 * 处理不同消息类型
	 * 
	 * @param ctx
	 * @param msg
	 */

	private void handlerWebSocketFrame(ChannelHandlerContext ctx,
			WebSocketFrame frame) {

		if (frame instanceof CloseWebSocketFrame) {
			ctx.channel().writeAndFlush(new CloseWebSocketFrame(1000, ""));
			ctx.channel().close();
		}

		if (frame instanceof BinaryWebSocketFrame) {
			ctx.fireChannelRead(frame);// 传递至下一handler
		}
		
	 
		if (frame instanceof PingWebSocketFrame) {
			ctx.channel().writeAndFlush(new PongWebSocketFrame(frame.content().retain()));
			return;
		}
		

	}

	/**
	 * 处理连接http握手
	 * 
	 * @param ctx
	 * @param req
	 */
	private void handleHttpRequest(ChannelHandlerContext ctx,
			FullHttpRequest req) {
		
		if (!req.decoderResult().isSuccess()
				|| (!"WebSocket".equalsIgnoreCase(req.headers().get("Upgrade")
						.toString()))) {
			sendHttpResponse(ctx, req, new DefaultFullHttpResponse(
					HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
			return;
		}

		WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
				GlobalConstant.WEBSOCKET_URL, null, false);
		handshaker = wsFactory.newHandshaker(req);
		if (handshaker == null) {
			WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx
					.channel());
		} else {
			handshaker.handshake(ctx.channel(), req);
		}

	}

	/**
	 * 返回消息
	 * 
	 * @param ctx
	 * @param e
	 */
	private static void sendHttpResponse(ChannelHandlerContext ctx,
			FullHttpRequest req, FullHttpResponse res) {
		if (res.status().code() != 200) {
			ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(),
					CharsetUtil.UTF_8);
			res.content().writeBytes(buf);
			buf.release();
		}

		ChannelFuture f = ctx.channel().writeAndFlush(res);
		if (!isKeepAlive(req) || res.status().code() != 200) {
			f.addListener(ChannelFutureListener.CLOSE);
		}
	}

	private static boolean isKeepAlive(FullHttpRequest req) {
		return false;
	}

	/**
	 * 抓取异常
	 * 
	 * @param ctx
	 * @param e
	 */
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
	 
		ctx.channel().close();
	}

	public void channelReadComplete(ChannelHandlerContext ctx) {

		ctx.channel().flush();
	}

	/**
	 * 解析消息并拼装成string
	 * 
	 * @param ctx
	 * @param e
	 */
	public static String keepByte(ByteBuf bf) {
		byte[] byteArray = new byte[bf.readableBytes()];
		int bfLength = bf.capacity();
		for (int i = 0; i < bfLength; i++) {
			byte b = bf.getByte(i);
			byteArray[i] = b;
		}
		bf.retain();
		String str = new String(byteArray, Charset.forName("utf-8"));
		byteArray = null;
		return str.length() > 0 ? str : null;
	}

	 
}