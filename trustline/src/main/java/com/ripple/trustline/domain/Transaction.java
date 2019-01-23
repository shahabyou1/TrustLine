package com.ripple.trustline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
public class Transaction implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private BigDecimal amount;
	
	@ManyToOne
	private Party payedTo;
	
	@Column
	public Date createdAt;
	
	public Transaction(BigDecimal amount, Party payedTo) {
		super();
		this.amount = amount;
		this.payedTo = payedTo;
		createdAt();
	}

	protected Transaction() {
		super();
	}
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Party getPayedTo() {
		return payedTo;
	}

	public void setPayedTo(Party payedTo) {
		this.payedTo = payedTo;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	@PrePersist
	void createdAt() {
		this.createdAt =  new Date();
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", payedTo=" + payedTo + ", createdAt=" + createdAt
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((payedTo == null) ? 0 : payedTo.hashCode());
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
		Transaction other = (Transaction) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id != other.id)
			return false;
		if (payedTo == null) {
			if (other.payedTo != null)
				return false;
		} else if (!payedTo.equals(other.payedTo))
			return false;
		return true;
	}
	
	
	
	
}
