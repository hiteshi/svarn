package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the KIT database table.
 * 
 */
@Entity
@Table(name="KIT")
public class Kit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="KIT_NO")
	private int kitNo;

	@Column(name="LOGIN_ID")
	private String loginId;

	@Column(name="LOGIN_PASSWORD")
	private String loginPassword;

    public Kit() {
    }

	public int getKitNo() {
		return this.kitNo;
	}

	public void setKitNo(int kitNo) {
		this.kitNo = kitNo;
	}

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

}