package cn.h.beeclub.sem.biz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.h.beeclub.sem.biz.domain.SemPromotionDo;

public interface SemPromotionDao {

	
	int create(SemPromotionDo param);
	
	@Select("select * from t_sem_promotion where on_sale = true and module = #{module}")
	List<SemPromotionDo> listOnSaleByModule(@Param("module") Integer module);

	@Update("update ")
	int update(SemPromotionDo param);

	@Select("select * from t_sem_promotion ")
	List<SemPromotionDo> listAll();
}
