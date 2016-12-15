package com.expect.admin.data.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.expect.admin.service.vo.ContractVo;
import com.expect.admin.utils.DateUtil;
import com.expect.admin.utils.StringUtil;

@Entity
@Table(name = "s_contract_inf")
public class Contract {

	private String id;
	private String bh;//合同编号
	private User nhtr;//拟合同人
	private String htbt;//合同标题
	private String htnr;//合同能容
	private Date nqdrq;//拟签订日期
	private String qx;//期限
	private String htshzt;//合同审核状态
	private String htfl;//合同分类（东交合同    集团合同  其他公司合同）
	private String lcbs;//流程标识
	private Date sqsj;//申请时间
	private String sfsc;//是否已经删除（采用软删除，只标识，不删除）
	
	public Contract() {
	}
	
	public Contract(ContractVo contractVo) {
		this.id = contractVo.getId();
		this.bh = contractVo.getBh();
		this.htbt = contractVo.getHtbt();
		this.htnr = contractVo.getHtnr();
		if(!StringUtil.isBlank(contractVo.getNqdrq()))
			this.nqdrq = DateUtil.parse(contractVo.getNqdrq(), DateUtil.webFormat);
		this.qx = contractVo.getQx();
		this.htshzt = contractVo.getHtshzt();
		this.htfl = contractVo.getHtfl();
		this.lcbs = contractVo.getLcbs();
		if(StringUtil.isBlank(contractVo.getSqsj())){
			this.sqsj = DateUtil.today();
		}
	}
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "id", nullable = false, unique = true, length = 32)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "bh", length = 20)
	public String getBh() {
		return bh;
	}
	public void setBh(String bh) {
		this.bh = bh;
	}

	@Column(name="nqdrq")
	public Date getNqdrq() {
		return nqdrq;
	}
	
	@ManyToOne
	@JoinColumn(name = "nhtr_id")
	public User getNhtr() {
		return nhtr;
	}
	public void setNhtr(User nhtr) {
		this.nhtr = nhtr;
	}
	
	@Column(name = "lcbs", length = 32)
	public String getLcbs() {
		return lcbs;
	}
	public void setLcbs(String lcbs) {
		this.lcbs = lcbs;
	}
	public void setNqdrq(Date nqdrq) {
		this.nqdrq = nqdrq;
	}
	
	@Column(name = "htshzt", length = 200)
	public String getHtshzt() {
		return htshzt;
	}
	public void setHtshzt(String htshzt) {
		this.htshzt = htshzt;
	}
	
	@Column(name = "htfl", length = 20)
	public String getHtfl() {
		return htfl;
	}
	public void setHtfl(String htfl) {
		this.htfl = htfl;
	}
	
	@Column(name = "htbt", length = 100)
	public String getHtbt() {
		return htbt;
	}
	public void setHtbt(String htbt) {
		this.htbt = htbt;
	}
	
	@Column(name = "htnr")
	public String getHtnr() {
		return htnr;
	}
	public void setHtnr(String htnr) {
		this.htnr = htnr;
	}
	
	@Column(name = "qx", length = 20)
	public String getQx() {
		return qx;
	}
	public void setQx(String qx) {
		this.qx = qx;
	}

	@Column(name = "sqsj")
	public Date getSqsj() {
		return sqsj;
	}

	public void setSqsj(Date sqsj) {
		this.sqsj = sqsj;
	}

	@Column(name = "sfsc", length = 2)
	public String getSfsc() {
		return sfsc;
	}

	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
	}
	
	
}