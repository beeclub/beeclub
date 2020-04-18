package cn.h.beeclub.portal.api.pub;

import java.util.*;

import cn.h.beeclub.portal.vo.response.NavigationVo;
import cn.h.beeclub.sem.biz.dto.SemPromotionDto;
import cn.h.beeclub.sem.biz.service.SemPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.h.beeclub.common.base.entity.handler.TreeHandler;
import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.common.vo.ApplicationVo;
import cn.h.beeclub.course.biz.dto.CourseCategoryDto;
import cn.h.beeclub.course.biz.service.CourseCategoryService;
import cn.h.beeclub.portal.common.constant.ApiConstant;

/**
 * @author huanghao
 */
@RestController
@RequestMapping(ApiConstant.API_PUBLIC_V1_PREFIX + "/common")
public class PubCommonController {

	
	@Autowired
	private CourseCategoryService courseCategoryService;

	@Autowired
	private SemPromotionService semPromotionService;

	/**
	 * 获取网站信息
	 * @description
	 * @return
	 */
	@GetMapping("/getApp")
	public SimpleResult<ApplicationVo> getApp(){
		/**
		 * 名称
		 * 版本
		 * 版本所属
		 * logo  Map  需要的log数据
		 */
		Map<String, String> logos = new HashMap<String, String>();
		ApplicationVo applicationVo = new ApplicationVo("小蜜蜂", "1.0.0","huanghao", null);
		return SimpleResult.ok(applicationVo);
	}

	/**
	 *
	 * @return
	 */
	@GetMapping("/getNavigation")
	public SimpleResult<List<NavigationVo>> getNavigation(){
		NavigationVo courseNav = new NavigationVo("全部课程", "/course/list.html");
		NavigationVo liveNav = new NavigationVo("直播", "/live/index.html");
		NavigationVo columnNav = new NavigationVo("专栏", "/column/index.html");
		NavigationVo mallNav = new NavigationVo("商城", "/mall/index.html");
		List<NavigationVo> resList = new ArrayList<>();
		Collections.addAll(resList, courseNav, liveNav, columnNav,mallNav);
		return SimpleResult.ok(resList);
	}

	/**
	 * 获取类别
	 * @description 
	 * @return
	 */
	@GetMapping("/courseCategoryTree")
	public SimpleResult<List<CourseCategoryDto>> courseCategoryTree(){
		List<CourseCategoryDto> listTopCourseCategory = courseCategoryService.listTopCourseCategory();
		return SimpleResult.ok((List<CourseCategoryDto>)TreeHandler.tree(listTopCourseCategory, null));
	}

	@GetMapping("/sem/promotion/{module}")
	public SimpleResult<List<SemPromotionDto>> semPromotions(@PathVariable Integer module){
		return SimpleResult.ok(semPromotionService.listOnSaleByModule(module));
	}
}
