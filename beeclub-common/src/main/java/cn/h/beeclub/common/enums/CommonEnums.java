package cn.h.beeclub.common.enums;

public final class CommonEnums {

	/**
	 * 业务类型
	 */
	public static enum BizType {
		course, column, live, mall
	}

	public static enum CourseType {
		video, // 视频
		column// 专栏
	}

	public static enum PeriodType {
		second("second", "秒"), minute("minute", "分钟"), hour("hour", "小时"), day("day", "天"), week("week", "周"),
		month("month", "月"), season("season", "季度"), year("year", "年"), ever("ever", "终身");

		private String code;
		private String text;

		PeriodType(String code, String text) {
			this.code = code;
			this.text = text;
		}

		public String getCode() {
			return code;
		}

		public String getText() {
			return text;
		}
	}

	public static enum Difficulty {
		one(1,"one","初级"), two(2,"two","中级"), three(3,"three","高级"), four(4,"four","资深"), five(5,"four","大师");

		private int value;
		private String code;
		private String text;

		Difficulty(int value, String code, String text) {
			this.value = value;
			this.code = code;
			this.text = text;
		}

		public String getCode() {
			return code;
		}

		public String getText() {
			return text;
		}

		public int getValue() {
			return value;
		}

		public Difficulty get(int i) {
			switch (i) {
			case 1:
				return one;
			case 2:
				return two;
			case 3:
				return three;
			case 4:
				return four;
			case 5:
				return five;
			default:
				return null;
			}
		}
	}

	public static enum CourseStatus {
		init("init", "待审核"), passed("passed", "审核通过"), noPassed("noPassed", "审核未通过"), onlined("onlined", "已上线"),
		offlined("offlined", "已下线"), deleted("deleted", "已删除");

		private String code;
		private String text;

		CourseStatus(String code, String text) {
			this.code = code;
			this.text = text;
		}

		public String getCode() {
			return code;
		}

		public String getText() {
			return text;
		}

	}

	public static enum OrganType {
		organization("organization", "公司"), department("department", "部门");

		private String code;
		private String text;

		OrganType(String code, String text) {
			this.code = code;
			this.text = text;
		}

		public String getCode() {
			return code;
		}

		public String getText() {
			return text;
		}
	}
	
	public static enum DataStatus{
		enable, disable, delete
	}

}
