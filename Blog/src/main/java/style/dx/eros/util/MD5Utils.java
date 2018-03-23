package style.dx.eros.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 获取字符串的 md5
 */
public class MD5Utils {
	public static String getMD5(String source) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(source.getBytes());
			byte[] md = messageDigest.digest();
			int i;
			StringBuilder stringBuffer = new StringBuilder("");
			for (byte aMd : md) {
				i = aMd;
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					stringBuffer.append("0");
				}
				stringBuffer.append(Integer.toHexString(i));
			}
			return stringBuffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
