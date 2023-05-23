package com.damp.damproject.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class OpenCrypt {

	public static byte[] generateKey(String algorithm, int keySize) throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
		keyGenerator.init(keySize);
		SecretKey key = keyGenerator.generateKey();
		return key.getEncoded();
	}
	
	public static String aesEncrypt(String msg, byte[] key) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		String iv = "AAAAAAAAAAAAAAAA";
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(iv.getBytes()));
		
		byte[] encrypted = cipher.doFinal(msg.getBytes());
		return byteArrayToHex(encrypted);
	}
	
	public static String aesDecrypt(String msg, byte[] key) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		String iv = "AAAAAAAAAAAAAAAA";
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(iv.getBytes()));
		byte[] encrypted = hexToByteArray(msg);
		byte[] original = cipher.doFinal(encrypted);
		return new String(original);
	}
	
	public static byte[] hexToByteArray(String hex) {
		if (hex == null || hex.length() == 0) return null;

		byte[] ba = new byte[hex.length() / 2];
		for (int i = 0; i < ba.length; i++) ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		return ba;
	}
	
	public static String getSHA256(String source, String salt) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(source.getBytes());
		md.update(salt.getBytes());
		byte[] byteData = md.digest();
		String hashMsg = byteArrayToHex(byteData);
		return hashMsg;
	}
	
	public static String byteArrayToHex(byte[] ba) {
		int length = ba.length;
		if (ba == null || length == 0) return null;

		StringBuffer sb = new StringBuffer(length * 2);
		String hexNumber;
		for (int x = 0; x < length; x++) {
			hexNumber = "0" + Integer.toHexString(0xff & ba[x]);
			sb.append(hexNumber.substring(hexNumber.length() - 2));
		}
		return sb.toString();
	}
	
}
