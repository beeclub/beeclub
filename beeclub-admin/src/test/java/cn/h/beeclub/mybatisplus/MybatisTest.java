package cn.h.beeclub.mybatisplus;



import java.util.Date;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.h.beeclub.BaseTest;
import cn.h.beeclub.common.enums.CommonEnums.OrganType;
import cn.h.beeclub.organization.biz.domain.Organization;
import cn.h.beeclub.organization.biz.mapper.OrganizationMapper;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MybatisTest extends BaseTest{

	@Autowired
	private OrganizationMapper organizationMapper;
	
	@Test
	public void test() {
		System.out.println(organizationMapper.selectById(1));
		Page<Organization> page = new Page<>(1, 1);
		IPage<Map<String, Object>> selectMapsPage = organizationMapper.selectMapsPage(page, null);
		log.info("{}",selectMapsPage);
		System.out.println(JSONUtil.toJsonPrettyStr(selectMapsPage));
	}
	
	@Test
	public void creatTest() {
		Organization org = new Organization();
		org.setName("小蜜蜂");
		org.setOrganCode("0000");
		org.setType(OrganType.organization);
		organizationMapper.insert(org);
	}
	
	@Test
	public void updateTest() {
		Organization selectById = organizationMapper.selectById(1);
		selectById.setModifyTime(new Date());
		organizationMapper.updateById(selectById);
	}
	
	@Test
	public void deleteTest() {
		int i = organizationMapper.deleteById(2);
		System.out.println(i);
	}
}
