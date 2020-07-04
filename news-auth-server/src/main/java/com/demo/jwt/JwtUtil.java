package com.demo.jwt;

import java.text.ParseException;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.exception.TokenAuthenticationException;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

/**
 * JWT Util
 * 
 * @author Larry_lee
 * @since 2020-07-04
 */
public class JwtUtil {
	
	static Logger logger = LoggerFactory.getLogger(JwtUtil.class);

	/**
	 * simple secret (news md5)
	 */
	private static final byte[] SECRET = "508C75C8507A2AE5223DFD2FAEB98122".getBytes();

	private static final long EXPIRE_TIME = TimeUnit.SECONDS.toMillis(5);

	/**
	 * generate JWT token
	 * 
	 * @param account
	 * @return
	 */
	public static String generateJwtToken(String account,Long expire) {
		
		Date expireTime = expire != null ? 
				new Date(System.currentTimeMillis() + expire) : 
				new Date(System.currentTimeMillis() + EXPIRE_TIME);
		try {
			MACSigner macSigner = new MACSigner(SECRET);
			JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
					.subject(null)
					.issuer(null)
					.expirationTime(expireTime)
					.claim("account", account)
					.build();

			SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
			signedJWT.sign(macSigner);

			String token = signedJWT.serialize();
			return token;
		} catch (KeyLengthException e) {
			logger.error("key length err",e);
		} catch (JOSEException e) {
			logger.error("jos err",e);
		}
		return null;
	}
	
	/**
     * check token
     * @param token
     * @return
     */
    public static String checkToken(String token ) {
        try {
            SignedJWT jwt = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(SECRET);
            // check token is valid
            if (!jwt.verify(verifier)) {
                throw new TokenAuthenticationException("Token is invalid");
            }

            // check token is expire
            Date expirationTime = jwt.getJWTClaimsSet().getExpirationTime();
            if (new Date().after(expirationTime)) {
            	throw new TokenAuthenticationException("Token is invalid");
            }

            //if token is valid
            Object account = jwt.getJWTClaimsSet().getClaim("account");
            //check account
            if (Objects.isNull(account)){
            	throw new TokenAuthenticationException("account is null");
            }
            return account.toString();
        } catch (JOSEException e) {
        	logger.error("jos err",e);
        } catch (ParseException e) {
        	logger.error("parse err",e);
		}
        return null;
    }
    
}