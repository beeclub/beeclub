package cn.h.beeclub.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.github.pagehelper.Page;

import cn.h.beeclub.common.base.result.PageResult;

public class PageUtils {

	
	public static <T> PageResult<T> pageConvertPageResult(List<T> pageList){
		Page<T> page =  (Page<T>) pageList;
		PageResult<T> resPage = new PageResult<T>( page.getTotal(), page);
		return resPage;
	}
	
	
	public static <T, K> PageResult<T> pageConvertPageResult(List<K> list, Function<K, T> function){
		Page<K> page = (Page<K>) list;
		List<T> listDate = new ArrayList<>();
		list.forEach(item -> {
			listDate.add(function.apply(item));
		});
		return new PageResult<T>(page.getTotal(), listDate);
	}

}
