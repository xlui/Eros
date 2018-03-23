package style.dx.eros.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {
	public static Logger getInstance() {
		return Inner.logger;
	}

	private static final class Inner {
		private static final Logger logger = LoggerFactory.getLogger("Eros");
	}
}
