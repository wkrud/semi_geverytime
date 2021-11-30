package com.zea.geverytime.info.model.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.zea.geverytime.common.model.vo.Attachment;

public class Info extends InfoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int recommend;
	private int attachCount;
	private List<Attachment> attachments;
	private int commentCount;
	
	public Info() {
		super();
	}
	
	
	
	public Info(String code, String memberId, int viewCount, String regCheck, String businessNo, Date regDate,
			String businessName, String businessAddress, String businessTel, String location, String headContent,
			String bodyContents, String serviceContent, String site, String mon, String tue, String wed, String thu,
			String fri, String sat, String sun, String launch, String dinner, String holiday) {
		super(code, memberId, viewCount, regCheck, businessNo, regDate, businessName, businessAddress, businessTel, location,
				headContent, bodyContents, serviceContent, site, mon, tue, wed, thu, fri, sat, sun, launch, dinner, holiday);
		// TODO Auto-generated constructor stub
	}



	public Info(String code, String memberId, int viewCount, String regCheck, String businessNo, Date regDate,
			String businessName, String businessAddress, String businessTel, String location, String headContent,
			String bodyContents, String serviceContent, String site, String mon, String tue, String wed, String thu,
			String fri, String sat, String sun, String launch, String dinner, String holiday, int recommend,
			int attachCount, List<Attachment> attachments, int commentCount) {
		super(code, memberId, viewCount, regCheck, businessNo, regDate, businessName, businessAddress, businessTel,
				location, headContent, bodyContents, serviceContent, site, mon, tue, wed, thu, fri, sat, sun, launch,
				dinner, holiday);
		this.recommend = recommend;
		this.attachCount = attachCount;
		this.attachments = attachments;
		this.commentCount = commentCount;
	}

	

	public int getRecommend() {
		return recommend;
	}



	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}



	public int getAttachCount() {
		return attachCount;
	}



	public void setAttachCount(int attachCount) {
		this.attachCount = attachCount;
	}



	public List<Attachment> getAttachments() {
		return attachments;
	}



	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}



	public int getCommentCount() {
		return commentCount;
	}



	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}



	@Override
	public String toString() {
		return "Info [ " + super.toString()
				+ "recommend=" + recommend
				+ "attachCount=" + attachCount 
				+ ", attachments=" + attachments 
				+ ", commentCount=" + commentCount	+ "]";
	}
	
	
	

}
