//package cn.h.beeclub.admin.system.vo;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.dozer.DozerBeanMapper;
//import org.dozer.Mapper;
//
//import cn.h.beeclub.admin.system.domain.SysResource;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@EqualsAndHashCode(callSuper=false)
//public class SysResourceTreeNode extends SysResource{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 2121150005064803074L;
//	private List<SysResourceTreeNode> children;
//	
//	
//	
//	public static List<SysResourceTreeNode> treeOrder(List<SysResource> listData){
//		log.info("tree");
//		Mapper mapper = new DozerBeanMapper();
//		Map<Long, SysResourceTreeNode> map = new HashMap<Long, SysResourceTreeNode>();
//		List<SysResourceTreeNode> res = new ArrayList<>();
//		for(SysResource resource : listData) {
//			SysResourceTreeNode item = mapper.map(resource, SysResourceTreeNode.class);
//			if(resource.getPid() == null || resource.getPid() == 0) {
//				map.put(resource.getId(), item);
//				res.add(item);
//			}else {
//				SysResourceTreeNode parent = map.get(resource.getPid());
//				if(parent == null) {
//					continue;
//				}
//				List<SysResourceTreeNode> children = parent.getChildren();
//				if(children == null) {
//					children =  new ArrayList<>();
//					parent.setChildren(children);
//				}
//				children.add(item);
//			}
//		}
//		return res;
//	}
//	
//	public static List<SysResourceTreeNode> tree(List<SysResource> listData){
//		log.info("tree");
//		Mapper mapper = new DozerBeanMapper();
//		Map<Long, List<SysResourceTreeNode>> pidMap = new HashMap<>();
//		List<SysResourceTreeNode> resDataList = new ArrayList<>();
//		listData.forEach(row -> {
//			Long pid = row.getPid();
//			List<SysResourceTreeNode> children = pidMap.get(pid);
//			SysResourceTreeNode item = mapper.map(row, SysResourceTreeNode.class);
//			if(children  != null) {
//				children.add(item);
//			}else {
//				children = new ArrayList<>();
//				children.add(item);
//				pidMap.put(pid, children);
//			}
//			resDataList.add(item);
//		});
//		
//		List<SysResourceTreeNode> resList = new ArrayList<>();
//		resDataList.forEach(row -> {
//			row.setChildren(pidMap.get(row.getId()));
//			if(row.getPid() == 0) {
//				resList.add(row);
//			}
//		});
//		return resList;
//	}
//
//	public List<SysResourceTreeNode> getChildren() {
//		return children;
//	}
//
//}
