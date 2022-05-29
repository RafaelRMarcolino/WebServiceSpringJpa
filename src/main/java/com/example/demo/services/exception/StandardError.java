package com.example.demo.services.exception;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError {
	
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 'T' HH:mm:ss 'Z'", timezone = "GMT")
	private Instant timeStamp;
	private Integer status;
	private String error;
	private String messege;
	private String path;
	
	public StandardError(Instant instant, Integer status, String error, String messege, String path) {
		super();
		this.timeStamp = instant;
		this.status = status;
		this.error = error;
		this.messege = messege;
		this.path = path;
	}
	
	
	public Instant getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Instant timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	

}
