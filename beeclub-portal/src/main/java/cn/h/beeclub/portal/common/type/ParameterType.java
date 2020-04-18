package cn.h.beeclub.portal.common.type;

import java.util.HashMap;
import java.util.Map;

public class ParameterType {

	public static enum  BaseServiceType{
		byId, byProvider, other
	}
	
	public static final Map<String, Class<?>> parameterProvider = new HashMap<String, Class<?>>(); 
}
