package cn.h.beeclub.common.base.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.h.beeclub.common.base.entity.handler.BaseTreeMappingHandler;
import lombok.Data;

@Data
public class TreeNodeEntity<K,V> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4167461690221453266L;
	private K id;
	private K pid;
	private List<TreeNodeEntity<K, V>> children;
	
	public static <K, V> List<TreeNodeEntity<K, V>> tree(List<TreeNodeEntity<K, V>> listData, BaseTreeMappingHandler handler){
		//先循环左右的，将所有的有子节点的保存在map中，并将子节点都保存
		Map<K, List<TreeNodeEntity<K, V>>> pidChildren = pidChildren(listData);
		
		List<TreeNodeEntity<K, V>> resList = new ArrayList<TreeNodeEntity<K, V>>();
		
		listData.forEach(row -> {
			row.setChildren(pidChildren.get(row.getId()));
			K pid = row.getPid();
			if(pid == null || "0".equals(pid.toString()) || "".equals(pid.toString())) {
				resList.add(row);
			}
		});
		return resList;
	}
	
	public static <K, V> List<TreeNodeEntity<K, V>> getLeafNodes(List<TreeNodeEntity<K, V>> listData, BaseTreeMappingHandler handler){
		
		Map<K, List<TreeNodeEntity<K, V>>> pidChildren = pidChildren(listData);
		
		List<TreeNodeEntity<K, V>> resList = new ArrayList<TreeNodeEntity<K, V>>();
		listData.forEach(row -> {
			List<TreeNodeEntity<K, V>> children = pidChildren.get(row.getId());
			if(children == null || children.isEmpty()) {
				resList.add(row);
			}
		});
		return resList;
	}
	
	private static <K, V> Map<K, List<TreeNodeEntity<K, V>>> pidChildren(List<TreeNodeEntity<K, V>> listData){
		Map<K, List<TreeNodeEntity<K, V>>> pidChildren = 
				new HashMap<K, List<TreeNodeEntity<K, V>>>();
		//先循环左右的，将所有的有子节点的保存在map中，并将子节点都保存
		listData.forEach( row -> {
			K pid = row.getPid();
			List<TreeNodeEntity<K, V>> children = pidChildren.get(pid);
			if(children != null) {
				children.add(row);
			}else {
				children = new ArrayList<>();
				children.add(row);
				pidChildren.put(pid, children);
			}
		});
		return pidChildren;
	}
}
