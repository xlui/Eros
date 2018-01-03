package style.dx.eros.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {
	private static Logger logger = null;

	public static Logger getLogger() {
		if (logger == null) {
			logger = LoggerFactory.getLogger("Eros");
		}
		return logger;
	}
}
