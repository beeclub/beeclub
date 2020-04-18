package cn.h.beeclub.common.base.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Pair {
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class IdName<I,N> implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 6862243235000489666L;
		private I id;
		private N name;

	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ValueText<I, N> implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = -6557266384822629047L;
		private I value;
		private N text;
	}
}
