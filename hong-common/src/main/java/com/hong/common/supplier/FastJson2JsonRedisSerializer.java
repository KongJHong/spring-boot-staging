package com.hong.common.supplier;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.lang.Nullable;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Description     :
 */
public class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T> {

	static final byte[] EMPTY_ARRAY = new byte[0];

	static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

	private Class<T> clazz;

	static {
		ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
	}

	public FastJson2JsonRedisSerializer(Class<T> clazz) {
		super();
		this.clazz = clazz;
	}

	@Override
	public byte[] serialize(@Nullable T source) throws SerializationException {
		if (source == null) return EMPTY_ARRAY;
		else {
			try {
				return JSON.toJSONString(source, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
			} catch (Exception ex) {
				throw new SerializationException("Could not write JSON:" + ex.getMessage(), ex);
			}
		}
	}

	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		if (isEmpty(bytes)) return null;
		String str = new String(bytes, DEFAULT_CHARSET);
		return JSON.parseObject(str, clazz);
	}

	static boolean isEmpty(@Nullable byte[] data) {
		return data == null || data.length == 0;
	}
}
