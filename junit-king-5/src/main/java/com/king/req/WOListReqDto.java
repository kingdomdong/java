package com.king.req;

import java.util.List;

public class WOListReqDto {

	private String sourceId;

	private Integer woType;

	/**
	 * 人员(执行人)ID
	 */
	private String staffId;

	/**
	 * 设备ID
	 */
	private String deviceId;

	/**
	 * 任务ID
	 */
	private Integer taskId;

	private Integer pageSize;

	private Integer pageNum;

	private List<Integer> statusCodes;

	private Integer expiredFlag;

	private Object detail;

	public boolean isLegal() {
		return true;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public Integer getWoType() {
		return woType;
	}

	public void setWoType(Integer woType) {
		this.woType = woType;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public List<Integer> getStatusCodes() {
		return statusCodes;
	}

	public void setStatusCodes(List<Integer> statusCodes) {
		this.statusCodes = statusCodes;
	}

	public Integer getExpiredFlag() {
		return expiredFlag;
	}

	public void setExpiredFlag(Integer expiredFlag) {
		this.expiredFlag = expiredFlag;
	}

	public Object getDetail() {
		return detail;
	}

	public void setDetail(Object detail) {
		this.detail = detail;
	}
}
