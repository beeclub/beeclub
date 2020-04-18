package cn.h.beeclub.core.common;

public class MongoConfig {

	public static enum BeeClubCollection{
		audit("audit","审核");
		
		String value;
		String name;
		
		BeeClubCollection(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

	}
}
