package com.wang.model.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.dao.test.read.TestReadDao;
import com.wang.entity.test.TestEntity;

/**
 * 框架测试 
 * @author HeJiawang
 * @date   2016.09.14
 */
@Service
public class TestModel {

	private final Logger logger = LoggerFactory.getLogger(TestModel.class);
	
	@Autowired 
	private TestReadDao testReadDao;
	
	/**
	 * 框架测试——获取实体
	 * @author HeJiawang
	 * @date   2016.09.14
	 * @param  ID Test ID
	 * @return TestEntity
	 */
	public TestEntity getTestById(Integer ID) {
		Assert.notNull(testReadDao, "Property 'testReadDao' is required.");
		
		if (ID == null || ID <= 0) {
			throw new BusinessException("id不能为空,或者小于0");
		}
		
		return testReadDao.getTestById(ID);
	}

}
