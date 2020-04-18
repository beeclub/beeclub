package cn.h.beeclub.common.api.dic;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeValue implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7283028491023974616L;
	private String value;
	private String text;

}
