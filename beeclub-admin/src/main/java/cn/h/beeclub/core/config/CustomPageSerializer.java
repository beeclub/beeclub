package cn.h.beeclub.core.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.github.pagehelper.Page;

public class CustomPageSerializer extends JsonSerializer<Page> {

	@Override
	public void serialize(Page value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("pageNum", value.getPageNum());
		res.put("pageSize", value.getPageSize());
		res.put("total", value.getTotal());
		res.put("pages", value.getPages());
		res.put("list", value);
		gen.writeObject(res);
		
	}
	
}
