package org.cs.logmodel;

import java.util.Arrays;

public class ReturnType {

	private Integer result;
	
	private String fileString;
	
	private byte[] fileBytes;
	
	private Long lastPosition;

	public ReturnType(String fileString, byte[] fileBytes, Long lastPosition,Integer result) {
		super();
		this.fileString = fileString;
		this.fileBytes = fileBytes;
		this.lastPosition = lastPosition;
		this.result = result;
	}

	public String getFileString() {
		return fileString;
	}

	public void setFileString(String fileString) {
		this.fileString = fileString;
	}

	public byte[] getFileBytes() {
		return fileBytes;
	}

	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}

	public Long getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(Long lastPosition) {
		this.lastPosition = lastPosition;
	}

	public ReturnType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ReturnType [result=" + result + ", fileString=" + fileString + ", fileBytes="
				+ Arrays.toString(fileBytes) + ", lastPosition=" + lastPosition + "]";
	}
	
	
	
}
