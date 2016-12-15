package com.expect.admin.service.vo;

import com.expect.admin.data.dataobject.Lcrzb;
import com.expect.admin.utils.DateUtil;


public class LcrzbVo {
	private String userName;
	private String userDepartmnet;
	private String clsj;//处理时间
	private String message;//处理意见
	private String cljg;//处理结果
//	private String clnrid;//处理内容的id（所处理的东西的id）
//	private String clnrfl;
	
	public LcrzbVo(){
		
	}
	
	public LcrzbVo(String cljg, String message){
		this.message = message;
		this.cljg = cljg;
	}
	
	public LcrzbVo(Lcrzb lcrzb) {
		this.userName = lcrzb.getUser().getFullName();
		this.userDepartmnet = lcrzb.getUser().getDepartment().getName();
		this.cljg = lcrzb.getCljg();
		this.clsj = lcrzb.getClsj() == null? "" : 
			DateUtil.format(lcrzb.getClsj(), DateUtil.webFormat);
		this.message = lcrzb.getMessage();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserDepartmnet() {
		return userDepartmnet;
	}
	public void setUserDepartmnet(String userDepartmnet) {
		this.userDepartmnet = userDepartmnet;
	}
	public String getClsj() {
		return clsj;
	}
	public void setClsj(String clsj) {
		this.clsj = clsj;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCljg() {
		return cljg;
	}
	public void setCljg(String cljg) {
		this.cljg = cljg;
	}
	
	
}