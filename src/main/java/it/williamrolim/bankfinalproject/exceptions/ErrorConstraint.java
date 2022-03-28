package it.williamrolim.bankfinalproject.exceptions;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

public class ErrorConstraint implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Instant timeStamp;
	private Integer status;
	private String error;
	private String path;
	
	private List<String> details;
	
	public ErrorConstraint() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public ErrorConstraint(Instant timeStamp, Integer status, String error, String path, List<String> details) {
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.path = path;
		this.details = details;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}
	
	
	
	
	

}
