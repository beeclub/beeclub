package cn.h.beeclub.common.api.dic;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class CodableValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7200920950419393119L;
	private List<CodeValue> codes;
	private String text;
}
