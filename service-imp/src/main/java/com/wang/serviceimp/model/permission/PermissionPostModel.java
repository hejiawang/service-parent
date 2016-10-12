package com.wang.serviceimp.model.permission;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.serviceimp.dao.permission.read.PermissionPostReadDao;
import com.wang.serviceimp.dao.permission.write.PermissionPostWriteDao;

/**
 * 岗位 model
 * 
 * @author HeJiawang
 * @date   2016.10.12
 */
@Service
public class PermissionPostModel {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionPostModel.class);
	
	/**
	 * permissionPostReadDao
	 */
	@Autowired
	private PermissionPostReadDao permissionPostReadDao;
	
	/**
	 * permissionPostWriteDao
	 */
	@Autowired
	private PermissionPostWriteDao permissionPostWriteDao;
}
