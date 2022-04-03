package com.kulu.utils;


import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 	JWT 工具類 (生成token)
 * 	生成對應加密的字串
 * 	解析加密的字串
 * 
 * @author user
 *
 */
public class JwtUtil {
	// 有效期限
	public static final Long JWT_TTL = 60 * 60 * 1000L;//60*60*1000 一小時
	// 設置秘鑰明文
	public static final String JWT_KEY = "kulu";
	
	/**
	 *  創建token
	 *  @param id			UUID生成
	 *  @param subject		jwt or token 攜帶的數據
	 *  @param ttlMillis	超時時間
	 *  @return
	 */
	public static String createJWT(String id, String subject, Long ttlMillis) {
		
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		Long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		if (ttlMillis == null) {
			ttlMillis = JwtUtil.JWT_TTL;
		}
		long expMillis = nowMillis + ttlMillis;
		Date expDate = new Date(expMillis);
		SecretKey secretKey = generalKey();
		
		JwtBuilder builder = Jwts.builder()
				.setId(id)									// 唯一id
				.setSubject(subject)						// 主題		可以是JSON數據
				.setIssuer("jian")							// 簽發者
				.setIssuedAt(now)							// 簽發時間
				.signWith(signatureAlgorithm, secretKey)	// 使用HS256對稱加密算法簽名，第二個參數為秘鑰
				.setExpiration(expDate);					// 設置過期時間
		return builder.compact();
	}
	
	/**
	 *  生成加密後的秘鑰 secretKey
	 *  @return
	 */
	public static SecretKey generalKey() {
		byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
		return key;
	}
	
	/**
	 * 	解析
	 * 
	 * 	@param jwt			傳入之前生成的token
	 *  @return				解析獲得之前攜帶的數據
	 *  @throws Exception
	 */
	public static Claims parseJWT(String jwt) throws Exception {
		SecretKey secretKey = generalKey();
		return Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(jwt)
				.getBody();
	}
	
	/*
	 *  測試一下工具類是否正常
	 */
	public static void main(String[] args) throws Exception {
		/*
		 *	創建 token (UUID, 秘鑰明文, 超時時間(毫秒L))
		 */
		String token = JwtUtil.createJWT(UUID.randomUUID().toString(), "kulu", null);
		System.out.println(token);
		
		/*
		 *	解析 token
		 */
		Claims claims = JwtUtil.parseJWT(token);
		String subject = claims.getSubject();
		System.out.println(subject);
	}
	
}
