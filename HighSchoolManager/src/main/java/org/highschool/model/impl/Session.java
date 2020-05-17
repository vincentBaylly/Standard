package org.highschool.model.impl;

import java.util.Date;

public class Session implements Comparable<Session>{
	
	private Integer id;
	private String label;	
	private Date submitDate;
	
	public Session(Integer id, String label, Date submitDate) {
		super();
		this.id = id;
		this.label = label;
		this.submitDate = submitDate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((submitDate == null) ? 0 : submitDate.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Session other = (Session) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (submitDate == null) {
			if (other.submitDate != null)
				return false;
		} else if (!submitDate.equals(other.submitDate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Session [id=" + id + ", label=" + label + ", submitDate=" + submitDate + "]";
	}

	@Override
	public int compareTo(Session s) {
		//return this.getSubmitDate().compareTo(s.getSubmitDate());
		return this.getLabel().compareTo(this.getLabel());
	}
	
}
