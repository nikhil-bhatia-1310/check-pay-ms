package com.checkpay.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity()
@Table(name = "account", schema = "public")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String accountNumber;
	private String ifscCode;
	private String bank;
	private Date createdOn;
	private String status;
	
	//@OneToMany(fetch = FetchType.LAZY)
    //@JoinColumn(name="user_id", referencedColumnName = "id")
	//private User user;
	
	@ManyToOne()
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
