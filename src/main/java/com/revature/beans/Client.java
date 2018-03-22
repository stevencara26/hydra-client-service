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
import org.springframework.stereotype.Component;

@Entity
@Table(name = "CALIBER_CLIENT")
@Cacheable
public class Client implements Serializable {

	/**
	 * Beans for Client table
	 */
	private static final long serialVersionUID = 1671197112642064698L;

	//id of client
	@Id
	@Column(name = "CLIENT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_ID_SEQUENCE")
	@SequenceGenerator(name = "CLIENT_ID_SEQUENCE", sequenceName = "CLIENT_ID_SEQUENCE")
	private Integer clientId; 
	
	//name of client
	@NotEmpty
	@Column(name = "CLIENT_NAME")
	private String clientName;
	
	
	
	public Client() {
		super();
	}
	
	public Client(Integer clientId, String clientName) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
	}
	
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((clientName == null) ? 0 : clientName.hashCode());
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
		Client other = (Client) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + "]";
	}
	
	
	
}
