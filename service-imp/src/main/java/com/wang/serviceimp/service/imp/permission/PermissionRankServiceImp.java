package com.wang.serviceimp.service.imp.permission;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.service.service.permission.PermissionRankService;
import com.wang.serviceimp.model.permission.PermissionRankModel;

/**
 * 职级service imp
 * 
 * @author HeJiawang
 * @date   2016.10.13
 */
@Service
public class PermissionRankServiceImp implements PermissionRankService {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionRankServiceImp.class);
	
	/**
	 * permissionpostModel
	 */
	@Autowired
	private PermissionRankModel permissionRankModel;
}
