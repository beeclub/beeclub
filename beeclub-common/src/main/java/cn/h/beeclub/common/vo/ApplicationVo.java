package cn.h.beeclub.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationVo {
	
	private String name;
	private String version;
	private String copyright;
	private Map<String,String> logos = new HashMap<String,String>();
}
