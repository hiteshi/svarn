package com.cdac.svarn.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the REGISTER_CLOSING database table.
 * 
 */
@Entity
@Table(name="REGISTER_CLOSING")
public class RegisterClosing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLOSING_ID")
	private int closingId;

	@Column(name="ACCOUNT_NO")
	private int accountNo;

	@Column(name="FEEDBACK")
	private String feedback;

	@Column(name="USER_ID")
	private int userId;

    public RegisterClosing() {
    }

	public int getClosingId() {
		return this.closingId;
	}

	public void setClosingId(int closingId) {
		this.closingId = closingId;
	}

	public int getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getFeedback() {
		return this.feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}