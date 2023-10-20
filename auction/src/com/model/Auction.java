package com.model;

public class Auction {
	String auctionId;
	int lowestBidLimit;
	int higestBidLimit;
	int participationCost;
	Seller seller;
	
	public Auction(String auctionId, int lowestBidLimit, int higestBidLimit, int participationCost, Seller seller) {
		super();
		this.auctionId = auctionId;
		this.lowestBidLimit = lowestBidLimit;
		this.higestBidLimit = higestBidLimit;
		this.participationCost = participationCost;
		this.seller = seller;
	}

	public String getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}

	public int getLowestBidLimit() {
		return lowestBidLimit;
	}

	public void setLowestBidLimit(int lowestBidLimit) {
		this.lowestBidLimit = lowestBidLimit;
	}

	public int getHigestBidLimit() {
		return higestBidLimit;
	}

	public void setHigestBidLimit(int higestBidLimit) {
		this.higestBidLimit = higestBidLimit;
	}

	public int getParticipationCost() {
		return participationCost;
	}

	public void setParticipationCost(int participationCost) {
		this.participationCost = participationCost;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	
}
