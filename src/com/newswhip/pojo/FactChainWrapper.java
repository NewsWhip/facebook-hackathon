package com.newswhip.pojo;

import java.sql.Timestamp;

public class FactChainWrapper {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	Object content;
	long lastHash;
	String lastAddress;
	Timestamp creationTime;

	// ===========================================================
	// Constructors
	// ===========================================================
	public FactChainWrapper(Object content, long lastHash, String lastAddress,
			Timestamp creationTime) {
		super();
		this.content = content;
		this.lastHash = lastHash;
		this.lastAddress = lastAddress;
		this.creationTime = creationTime;

	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public String toString() {

		return this.content.toString() + this.lastHash + this.lastAddress
				+ this.creationTime;
	}
	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
