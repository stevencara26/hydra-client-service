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
@Table(name = "CALIBER_CLIENT")
@Cacheable
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1671197112642064698L;

	@Id
	@Column(name = "CLIENT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_ID_SEQUENCE")
	@SequenceGenerator(name = "CLIENT_ID_SEQUENCE", sequenceName = "CLIENT_ID_SEQUENCE")
	private Integer ClientId;
	
	@NotEmpty
	@Column(name = "CLIENT_NAME")
	private String ClientName;
	
	
	
	public Client() {
		super();
	}
	
	public Client(Integer clientId, String clientName) {
		super();
		ClientId = clientId;
		ClientName = clientName;
	}
	
	public Integer getClientId() {
		return ClientId;
	}
	public void setClientId(Integer clientId) {
		ClientId = clientId;
	}
	public String getClientName() {
		return ClientName;
	}
	public void setClientName(String clientName) {
		ClientName = clientName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ClientId == null) ? 0 : ClientId.hashCode());
		result = prime * result + ((ClientName == null) ? 0 : ClientName.hashCode());
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
		if (ClientId == null) {
			if (other.ClientId != null)
				return false;
		} else if (!ClientId.equals(other.ClientId))
			return false;
		if (ClientName == null) {
			if (other.ClientName != null)
				return false;
		} else if (!ClientName.equals(other.ClientName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [ClientId=" + ClientId + ", ClientName=" + ClientName + "]";
	}
	
	
	
}
