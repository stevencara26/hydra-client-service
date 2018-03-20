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
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "End_Client_ID_Sequence")
	@SequenceGenerator(name= "End_Client_ID_Sequence", sequenceName = "End_Client_ID_Sequence")
	private Integer EndClientId;
	
	@NotEmpty
	@Column
	private String EndClientName;

	public EndClient() {
		super();
	}

	
	public EndClient(Integer endClientId, String endClientName) {
		super();
		EndClientId = endClientId;
		EndClientName = endClientName;
	}


	public Integer getEndClientId() {
		return EndClientId;
	}


	public void setEndClientId(Integer endClientId) {
		EndClientId = endClientId;
	}


	public String getEndClientName() {
		return EndClientName;
	}


	public void setEndClientName(String endClientName) {
		EndClientName = endClientName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EndClientId == null) ? 0 : EndClientId.hashCode());
		result = prime * result + ((EndClientName == null) ? 0 : EndClientName.hashCode());
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
		if (EndClientId == null) {
			if (other.EndClientId != null)
				return false;
		} else if (!EndClientId.equals(other.EndClientId))
			return false;
		if (EndClientName == null) {
			if (other.EndClientName != null)
				return false;
		} else if (!EndClientName.equals(other.EndClientName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "EndClient [EndClientId=" + EndClientId + ", EndClientName=" + EndClientName + "]";
	}
	
	
}
