package cn.tiny77.algorithm;


import java.util.logging.Logger;

public class TestMain<T> {

	static GirlFriend me = new GirlFriend(true, true, true);

	static Logger logger = null;

	public static void main(String[] args) throws Throwable {
		logger.info("七夕 start");
		GirlFriend myGirlFriend = new GirlFriend(true,
				true, true);
		me.sendGiftTo(myGirlFriend, "flower");
		me.datingWith(myGirlFriend);
		while (!isQixiEnd()) {
			Thread.sleep(1000);
		}
		me.endDating();
		myGirlFriend.destroy();
		logger.info("七夕 end");

	}

	private static boolean isQixiEnd() {
		return false;
	}

	static class GirlFriend {

		public GirlFriend(boolean white, boolean rich, boolean beautiful) {

		}

		public void destroy() {}

		public void endDating() {}

		public void datingWith(GirlFriend target) {}

		public void sendGiftTo(GirlFriend target, String gift) {}
	}
}