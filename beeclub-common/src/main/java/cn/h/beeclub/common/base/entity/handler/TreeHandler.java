package cn.h.beeclub.common.base.entity.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.h.beeclub.common.base.entity.TreeNode;

public class TreeHandler {
	
	public static <K, V> List<? extends TreeNode<K, V>> tree(List<? extends TreeNode<K, V>> listData, BaseTreeMappingHandler handler){
		//先循环左右的，将所有的有子节点的保存在map中，并将子节点都保存
		Map<K, List<TreeNode<K, V>>> pidChildren = pidChildren(listData);
		
		List<TreeNode<K, V>> resList = new ArrayList<TreeNode<K, V>>();
		
		listData.forEach(row -> {
			row.setChildren(pidChildren.get(row.getId()));
			K pid = row.getPid();
			if(pid == null || "0".equals(pid.toString()) || "".equals(pid.toString())) {
				resList.add(row);
			}
		});
		return resList;
	}
	
	public static <K, V> List<? extends TreeNode<K, V>> getLeafNodes(List<? extends TreeNode<K, V>> listData, BaseTreeMappingHandler handler){
		
		Map<K, List<TreeNode<K, V>>> pidChildren = pidChildren(listData);
		
		List<TreeNode<K, V>> resList = new ArrayList<TreeNode<K, V>>();
		listData.forEach(row -> {
			List<TreeNode<K, V>> children = pidChildren.get(row.getId());
			if(children == null || children.isEmpty()) {
				resList.add(row);
			}
		});
		return resList;
	}
	
	private static <K, V> Map<K, List<TreeNode<K, V>>> pidChildren(List<? extends TreeNode<K, V>> listData){
		Map<K, List<TreeNode<K, V>>> pidChildren = 
				new HashMap<K, List<TreeNode<K, V>>>();
		//先循环左右的，将所有的有子节点的保存在map中，并将子节点都保存
		listData.forEach( row -> {
			K pid = row.getPid();
			List<TreeNode<K, V>> children = pidChildren.get(pid);
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
