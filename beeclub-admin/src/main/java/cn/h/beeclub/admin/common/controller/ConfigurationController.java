package cn.h.beeclub.admin.common.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.h.beeclub.common.api.dic.CodeValue;
import cn.h.beeclub.common.enums.CommonEnums.PeriodType;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

	@GetMapping("/codeValueList/{group}")
	public List<CodeValue> codeValueList(@PathVariable String group){
		List<CodeValue> res = new ArrayList<>();
		switch (group) {
		case "periodType":
			PeriodType[] values = PeriodType.values();
			for(PeriodType value : values) {
				res.add(new CodeValue(value.getCode(), value.getText()));
			}
			return res;
		default:
			break;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		PeriodType[] values = PeriodType.values();
		List<PeriodType> asList = Arrays.asList(values);
		System.out.println(asList);
	}
}
