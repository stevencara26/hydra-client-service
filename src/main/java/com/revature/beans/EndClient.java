package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name= "Caliber_EndClient")
@Cacheable
public class EndClient implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1686377310978306024L;
	
	//id of end client
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "End_Client_ID_Sequence")
	@SequenceGenerator(name= "End_Client_ID_Sequence", sequenceName = "End_Client_ID_Sequence")
	private Integer endClientId;
	
	//name of end client
	@NotEmpty
	@Column
	private String endClientName;

	public EndClient() {
		super();
	}
	
	public EndClient(Integer endClientId, String endClientName) {
		super();
		this.endClientId = endClientId;
		this.endClientName = endClientName;
	}

	public Integer getEndClientId() {
		return endClientId;
	}

	public void setEndClientId(Integer endClientId) {
		this.endClientId = endClientId;
	}

	public String getEndClientName() {
		return endClientName;
	}

	public void setEndClientName(String endClientName) {
		this.endClientName = endClientName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endClientId == null) ? 0 : endClientId.hashCode());
		result = prime * result + ((endClientName == null) ? 0 : endClientName.hashCode());
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
		EndClient other = (EndClient) obj;
		if (endClientId == null) {
			if (other.endClientId != null)
				return false;
		} else if (!endClientId.equals(other.endClientId))
			return false;
		if (endClientName == null) {
			if (other.endClientName != null)
				return false;
		} else if (!endClientName.equals(other.endClientName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EndClient [endClientId=" + endClientId + ", endClientName=" + endClientName + "]";
	}
	
	
}	