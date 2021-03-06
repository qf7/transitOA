package com.expect.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expect.admin.data.dao.RoleJdgxbGxbRepository;
import com.expect.admin.data.dao.UserRepository;
import com.expect.admin.data.dataobject.Role;
import com.expect.admin.data.dataobject.RoleJdgxbGxb;
import com.expect.admin.data.dataobject.User;
import com.expect.admin.service.vo.RoleJdgxbGxbVo;
import com.expect.admin.service.vo.UserVo;

@Service
public class RoleJdgxbGxbService {
	
	@Autowired
	private RoleJdgxbGxbRepository roleJdgxbGxbRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	
	public RoleJdgxbGxbVo getByFunctionId(String roleId){
		return new RoleJdgxbGxbVo(
				roleJdgxbGxbRepository.findByRoleId(roleId));
	}
	
	/**
	 * 获取用户可以审核的文件的状态
	 * @param bz
	 * @param wjzl
	 * @return
	 */
	public RoleJdgxbGxbVo getWjzt(String bz, String wjzl){
		UserVo userVo = userService.getLoginUser();
		User user = userRepository.findOne(userVo.getId());
//		User user = userRepository.findOne("2c913b71590fcb3201590fd15ada0007");
		if(user.getRoles() == null || user.getRoles().size() == 0) return new RoleJdgxbGxbVo();
		List<String> roleIds = new ArrayList<>(user.getRoles().size());
		for (Role role : user.getRoles()) {
			roleIds.add(role.getId());
		}
		RoleJdgxbGxb roleJdgxbGxb = roleJdgxbGxbRepository.findByBzAndWjzlAndRoleIdIn(bz, wjzl, roleIds);//有错
		if(roleJdgxbGxb == null) return new RoleJdgxbGxbVo();
		return new RoleJdgxbGxbVo(roleJdgxbGxb);
	}

}
