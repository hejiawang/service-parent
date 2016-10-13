package com.wang.serviceimp.model.permission;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.serviceimp.dao.permission.read.PermissionRankReadDao;
import com.wang.serviceimp.dao.permission.write.PermissionRankWriteDao;

/**
 * 职级model
 * 
 * @author HeJiawang
 * @date   2016.10.13
 */
@Service
public class PermissionRankModel {
	
	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionRankModel.class);
	
	/**
	 * permissionPostReadDao
	 */
	@Autowired
	private PermissionRankReadDao permissionRankReadDao;
	
	/**
	 * permissionPostWriteDao
	 */
	@Autowired
	private PermissionRankWriteDao permissionRankWriteDao;
}
