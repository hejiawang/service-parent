package com.wang.test.service.test;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wang.core.ServiceResult;
import com.wang.entity.test.TestEntity;
import com.wang.service.test.TestService;

/**
 * 框架测试 
 * @author HeJiawang
 * @date   2016.09.14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/service-deploy.xml")
public class TestTest {
	
	@Resource
	private TestService testService;
	
	@Test
	public void getTestByIdTest(){
		ServiceResult<TestEntity> result = testService.getTestById(1);
		TestEntity testEntity = result.getResult();
		System.out.println(testEntity.getID() + "  " + testEntity.getContext() + "  " + testEntity.getUpdateTime());
	}
}
