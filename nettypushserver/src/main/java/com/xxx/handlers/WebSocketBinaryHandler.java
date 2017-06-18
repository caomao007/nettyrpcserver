package com.xxx.handlers;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import java.nio.charset.Charset;
import com.xxx.entities.GloablBean;


 /**
  * 
  * @author wangzhen
  * @emails 2502355536@qq.com
  * 有合作需求请发邮件，非诚勿扰
  */
 
 
public class WebSocketBinaryHandler extends SimpleChannelInboundHandler<Object> {

	private GloablBean gloablBean;

  public WebSocketBinaryHandler(GloablBean gloablBean) {
    this.gloablBean = gloablBean;
  }

  /**
   * 接收消息
   */
  protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {

    if (msg instanceof CloseWebSocketFrame) {
      ctx.channel().writeAndFlush(new CloseWebSocketFrame(1000, ""));
      ctx.channel().close();
    }

    if (msg instanceof BinaryWebSocketFrame) {
      handlerBinaryWebSocketFrame(ctx, (BinaryWebSocketFrame) msg);
      return;
    }
  }

  /**
   * 处理二进制消息
   * 
   * @param ctx
   * @param msg
   */
  private void handlerBinaryWebSocketFrame(ChannelHandlerContext ctx, BinaryWebSocketFrame msg) {
    ByteBuf buffer = msg.content();
    String str = keepByte(buffer);
    handleMsg(ctx, str);
    str = null;
  }

  /**
   * 异常处理
   * 
   * @param ctx
   * @param e
   */
  public void exceptionCaught(ChannelHandlerContext ctx, Exception e) {
    ctx.channel().close();
  }

  /**
   * 处理消息
   * 
   * @param ctx
   * @param e
   */
  public void handleMsg(final ChannelHandlerContext ctx, String str) {// 处理消息
  }

  /**
   * 转化接收到的字节为字符串
   * @param bf
   * @return String
   */
  private static String keepByte(ByteBuf bf) {
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

  /**
   * 处理完毕
   * @param ctx
   * @param e
   */
  public void channelReadComplete(ChannelHandlerContext ctx) {
    ctx.channel().flush();
  }
}
