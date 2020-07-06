package com.demo.jwt;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * Jwt Token generator
 * @author Administrator
 * @since 2020-07-05
 */
@Component
public class JWTTokenGenerator {

	final static String USER_CLAIM = "name";

	@Autowired
	Algorithm algorithm;

	@Value("${server.jwt.expire:3000}")
	int expireTime;

	@Autowired
	ValueOperations<String, Object> redisOperation;

	private String simpleIssuer = "SPH";

	/**
	 * get or create a token
	 * @param account
	 * @return
	 */
	public String getOrCreat(String account) {
		String token = (String) redisOperation.get("account");
		if (token != null) {
			return token;
		} else {
			// create token
			Date now = new Date();
			token = JWT.create().withIssuer(simpleIssuer)
					.withIssuedAt(now)
					.withExpiresAt(DateUtils.addSeconds(now, expireTime))
					.withClaim(USER_CLAIM, account)
					.sign(algorithm);
			redisOperation.set(account, token, expireTime, TimeUnit.SECONDS);
		}

		return token;
	}

}
