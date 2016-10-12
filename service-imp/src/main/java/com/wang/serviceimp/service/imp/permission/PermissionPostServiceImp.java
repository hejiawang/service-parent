package com.wang.serviceimp.service.imp.permission;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.service.service.permission.PermissionPostService;
import com.wang.serviceimp.model.permission.PermissionPostModel;

/**
 * 岗位service imp
 * 
 * @author HeJiawang
 * @date   2016.10.12
 */
@Service
public class PermissionPostServiceImp implements PermissionPostService {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionPostServiceImp.class);
	
	/**
	 * permissionpostModel
	 */
	@Autowired
	private PermissionPostModel permissionpostModel;
}
