package com.wo.redis.client;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.BitPosParams;
import redis.clients.jedis.DebugParams;
import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;

/**
 * @author 王震<zhen.wang@w-oasis.com>
 * @version 创建时间：2018-7-6 下午4:55:54
 * 说明：
 */

public class RedisClusterClient implements RedisClient{

	private JedisCluster jedisCluster;
	
	public RedisClusterClient(JedisCluster jedisCluster){
		this.jedisCluster=jedisCluster;
	}
	
	public String set(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public String set(String key, String value, String nxxx, String expx,
			long time) {
		// TODO Auto-generated method stub
		return null;
	}

	public String set(String key, String value, String nxxx) {
		// TODO Auto-generated method stub
		return null;
	}

	public String get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean exists(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long persist(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public String type(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long expire(String key, int seconds) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long pexpire(String key, long milliseconds) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long expireAt(String key, long unixTime) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long pexpireAt(String key, long millisecondsTimestamp) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long ttl(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long pttl(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean setbit(String key, long offset, boolean value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean setbit(String key, long offset, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean getbit(String key, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long setrange(String key, long offset, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getrange(String key, long startOffset, long endOffset) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSet(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long setnx(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public String setex(String key, int seconds, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public String psetex(String key, long milliseconds, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long decrBy(String key, long integer) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long decr(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long incrBy(String key, long integer) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double incrByFloat(String key, double value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long incr(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long append(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public String substr(String key, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long hset(String key, String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public String hget(String key, String field) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long hsetnx(String key, String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public String hmset(String key, Map<String, String> hash) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> hmget(String key, String... fields) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long hincrBy(String key, String field, long value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double hincrByFloat(String key, String field, double value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean hexists(String key, String field) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long hdel(String key, String... field) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long hlen(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> hkeys(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> hvals(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, String> hgetAll(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long rpush(String key, String... string) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long lpush(String key, String... string) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long llen(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> lrange(String key, long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

	public String ltrim(String key, long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

	public String lindex(String key, long index) {
		// TODO Auto-generated method stub
		return null;
	}

	public String lset(String key, long index, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long lrem(String key, long count, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public String lpop(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public String rpop(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long sadd(String key, String... member) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> smembers(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long srem(String key, String... member) {
		// TODO Auto-generated method stub
		return null;
	}

	public String spop(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> spop(String key, long count) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long scard(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean sismember(String key, String member) {
		// TODO Auto-generated method stub
		return null;
	}

	public String srandmember(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> srandmember(String key, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long strlen(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long zadd(String key, double score, String member) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long zadd(String key, double score, String member, ZAddParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long zadd(String key, Map<String, Double> scoreMembers) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long zadd(String key, Map<String, Double> scoreMembers,
			ZAddParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> zrange(String key, long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long zrem(String key, String... member) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double zincrby(String key, double score, String member) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double zincrby(String key, double score, String member,
			ZIncrByParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long zrank(String key, String member) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long zrevrank(String key, String member) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> zrevrange(String key, long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Tuple> zrangeWithScores(String key, long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long zcard(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double zscore(String key, String member) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> sort(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> sort(String key, SortingParams sortingParameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long zcount(String key, double min, double max) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long zcount(String key, String min, String max) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> zrangeByScore(String key, double min, double max) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> zrangeByScore(String key, String min, String max) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> zrevrangeByScore(String key, double max, double min) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> zrangeByScore(String key, double min, double max,
			int offset, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> zrevrangeByScore(String key, String max, String min) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> zrangeByScore(String key, String min, String max,
			int offset, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> zrevrangeByScore(String key, double max, double min,
			int offset, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max,
			double min) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Tuple> zrangeByScoreWithScores(String key, double min,
			double max, int offset, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> zrevrangeByScore(String key, String max, String min,
			int offset, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Tuple> zrevrangeByScoreWithScores(String key, String max,
			String min) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Tuple> zrangeByScoreWithScores(String key, String min,
			String max, int offset, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max,
			double min, int offset, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Tuple> zrevrangeByScoreWithScores(String key, String max,
			String min, int offset, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long zremrangeByRank(String key, long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long zremrangeByScore(String key, double start, double end) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long zremrangeByScore(String key, String start, String end) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long zlexcount(String key, String min, String max) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> zrangeByLex(String key, String min, String max) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> zrangeByLex(String key, String min, String max,
			int offset, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> zrevrangeByLex(String key, String max, String min) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> zrevrangeByLex(String key, String max, String min,
			int offset, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long zremrangeByLex(String key, String min, String max) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long linsert(String key, LIST_POSITION where, String pivot,
			String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long lpushx(String key, String... string) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long rpushx(String key, String... string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Deprecated
	public
	List<String> blpop(String arg) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> blpop(int timeout, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Deprecated
	public
	List<String> brpop(String arg) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> brpop(int timeout, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long del(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public String echo(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long move(String key, int dbIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long bitcount(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long bitcount(String key, long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long bitpos(String key, boolean value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long bitpos(String key, boolean value, BitPosParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Deprecated
	public
	ScanResult<Entry<String, String>> hscan(String key, int cursor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Deprecated
	public
	ScanResult<String> sscan(String key, int cursor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Deprecated
	public
	ScanResult<Tuple> zscan(String key, int cursor) {
		// TODO Auto-generated method stub
		return null;
	}

	public ScanResult<Entry<String, String>> hscan(String key, String cursor) {
		// TODO Auto-generated method stub
		return null;
	}

	public ScanResult<Entry<String, String>> hscan(String key, String cursor,
			ScanParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	public ScanResult<String> sscan(String key, String cursor) {
		// TODO Auto-generated method stub
		return null;
	}

	public ScanResult<String> sscan(String key, String cursor, ScanParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	public ScanResult<Tuple> zscan(String key, String cursor) {
		// TODO Auto-generated method stub
		return null;
	}

	public ScanResult<Tuple> zscan(String key, String cursor, ScanParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long pfadd(String key, String... elements) {
		// TODO Auto-generated method stub
		return null;
	}

	public long pfcount(String key) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Long geoadd(String key, double longitude, double latitude,
			String member) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long geoadd(String key,
			Map<String, GeoCoordinate> memberCoordinateMap) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double geodist(String key, String member1, String member2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double geodist(String key, String member1, String member2,
			GeoUnit unit) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> geohash(String key, String... members) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GeoCoordinate> geopos(String key, String... members) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GeoRadiusResponse> georadius(String key, double longitude,
			double latitude, double radius, GeoUnit unit) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GeoRadiusResponse> georadius(String key, double longitude,
			double latitude, double radius, GeoUnit unit, GeoRadiusParam param) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GeoRadiusResponse> georadiusByMember(String key, String member,
			double radius, GeoUnit unit) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GeoRadiusResponse> georadiusByMember(String key, String member,
			double radius, GeoUnit unit, GeoRadiusParam param) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Long> bitfield(String key, String... arguments) {
		// TODO Auto-generated method stub
		return null;
	}

	public String ping() {
		// TODO Auto-generated method stub
		return null;
	}

	public String quit() {
		// TODO Auto-generated method stub
		return null;
	}

	public String flushDB() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long dbSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public String select(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public String flushAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public String auth(String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public String save() {
		// TODO Auto-generated method stub
		return null;
	}

	public String bgsave() {
		// TODO Auto-generated method stub
		return null;
	}

	public String bgrewriteaof() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long lastsave() {
		// TODO Auto-generated method stub
		return null;
	}

	public String shutdown() {
		// TODO Auto-generated method stub
		return null;
	}

	public String info() {
		// TODO Auto-generated method stub
		return null;
	}

	public String info(String section) {
		// TODO Auto-generated method stub
		return null;
	}

	public String slaveof(String host, int port) {
		// TODO Auto-generated method stub
		return null;
	}

	public String slaveofNoOne() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getDB() {
		// TODO Auto-generated method stub
		return null;
	}

	public String debug(DebugParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	public String configResetStat() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long waitReplicas(int replicas, long timeout) {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
