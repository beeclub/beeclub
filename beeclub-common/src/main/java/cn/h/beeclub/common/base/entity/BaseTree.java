package cn.h.beeclub.common.base.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;

import cn.h.beeclub.common.base.entity.handler.BaseTreeMappingHandler;
import lombok.Data;

@Data
public class BaseTree implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3850581718873589871L;
	private Long id;
	private Long pid;
	private List<BaseTree> children;
	public static List<? extends BaseTree> tree(List<? extends BaseTree> listData, Class<? extends BaseTree> clazz,BaseTreeMappingHandler handler){
		Mapper mapper = DozerBeanMapperBuilder.create().build();
		Map<Long, List<BaseTree>> pidMap = 
				new HashMap<Long, List<BaseTree>>();
		
		List<BaseTree> resDataList = new ArrayList<>();

		rowHandle(listData, clazz, handler, mapper, (Map<Long, List<BaseTree>>) pidMap, (List<BaseTree>) resDataList);
		List<BaseTree> resList = new ArrayList<BaseTree>();
		resDataList.forEach(row -> {
			row.setChildren(pidMap.get(row.getId()));
			if(row.getPid() == 0) {
				resList.add(row);
			}
		});
		return resList;
	}

	private static void rowHandle(List<? extends BaseTree> listData, Class<? extends BaseTree> clazz, BaseTreeMappingHandler handler, Mapper mapper, Map<Long, List<BaseTree>> pidMap, List<BaseTree> resDataList) {
		listData.forEach( row -> {
			Long pid = row.getPid();

			List<BaseTree> children = pidMap.get(pid);

			BaseTree item = mapper.map(row, clazz);
			if(handler != null) {
				handler.handler(item, row);
			}
			if(children != null) {
				children.add(item);
			}else {
				children = new ArrayList<>();
				children.add(item);
				pidMap.put(pid, children);
			}
			resDataList.add(item);
		});
	}

	public static List<? extends BaseTree> getLeafNodes(List<? extends BaseTree> listData, Class<? extends BaseTree> clazz,BaseTreeMappingHandler handler){
		Mapper mapper = DozerBeanMapperBuilder.create().build();
		Map<Long, List<BaseTree>> pidMap = 
				new HashMap<Long, List<BaseTree>>();
		
		List<BaseTree> resDataList = new ArrayList<>();

		rowHandle(listData, clazz, handler, mapper, (Map<Long,List<BaseTree>>) pidMap, (List<BaseTree>) resDataList);
		List<BaseTree> resList = new ArrayList<BaseTree>();
		resDataList.forEach(row -> {
			List<BaseTree> children = pidMap.get(row.getId());
			if(children == null || children.isEmpty()) {
				resList.add(row);
			}
		});
		return resList;
	}
}
