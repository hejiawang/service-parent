package com.wang.dao.test.read;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.entity.test.TestEntity;

/**
 * 框架测试 
 * @author HeJiawang
 * @date   2016.09.14
 */
@MyBatisRepository
public interface TestReadDao {

	/**
	 * 框架测试——获取实体
	 * @author HeJiawang
	 * @date   2016.09.14
	 * @param  ID Test ID
	 * @return TestEntity
	 */
	public TestEntity getTestById( @Param("ID") Integer ID );
	
}
