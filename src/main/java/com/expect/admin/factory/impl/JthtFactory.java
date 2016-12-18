package com.expect.admin.factory.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.expect.admin.factory.WordXmlFactory;
import com.expect.admin.service.ContractService;
import com.expect.admin.service.vo.ContractVo;
import com.expect.admin.utils.WordXmlUtil;

import freemarker.template.TemplateException;

public class JthtFactory implements WordXmlFactory {

	private final String TEMPLATE_NAME = "djh.ftl";
	@Autowired
	private ContractService contractService;
	
	@Override
	public byte[] create(String wjid) throws IOException, TemplateException {
		ContractVo contractVo = contractService.getContractById(wjid);
		if(contractVo == null) return null;
		Map<String,Object> dataMap = new HashMap<String,Object>() ;
		dataMap.put("htbt", contractVo.getHtbt());
		dataMap.put("bh", contractVo.getBh());
		dataMap.put("htnr", contractVo.getHtnr());
		dataMap.put("nhtr", contractVo.getUserName());
		dataMap.put("nqdrq", contractVo.getNqdrq());
		dataMap.put("qx", contractVo.getQx());
		
		dataMap.put("bmsh", "同意");
		dataMap.put("bmfzrsh", "同意");
		dataMap.put("fwyj", "同意");
		dataMap.put("zcglbyj", "同意");
		dataMap.put("fgfzryj", "同意");
		dataMap.put("fzryj", "同意");
		
		byte[] content =  WordXmlUtil.create(dataMap, TEMPLATE_NAME) ;
		return content;
	}

	@Override
	public String getFileName(String wjid) {
		ContractVo contractVo = contractService.getContractById(wjid);
		return contractVo.getHtbt() + contractVo.getBh()+"号.doc";
	}

}