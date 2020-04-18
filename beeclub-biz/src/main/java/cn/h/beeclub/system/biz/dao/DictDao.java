package cn.h.beeclub.system.biz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.h.beeclub.system.biz.domain.DictCategoryDo;
import cn.h.beeclub.system.biz.domain.DictItemDo;

/**
 * 
 * @description 
 * @author hao.huang
 * @date 2019年12月17日
 */
public interface DictDao {
	
	@Select("select count(1) from t_dict_category  where code = #{code}")
	int isDictCategoryCode(@Param("code") String code);

	int createDictCategory(DictCategoryDo param);

	List<DictCategoryDo> listDictCategory(@Param("available") Boolean available);
	
	int createDictItem(DictItemDo param);

	List<DictItemDo> listDictItem(@Param("cateCode") String cateCode,@Param("available") Boolean available);
}
