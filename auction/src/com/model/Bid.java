package com.model;

import java.util.List;

public class Bid {
	String buyer;
	String auctionId;
	int BidAmount;
	
	
	
	public Bid(String buyerName, String auctionId, int bidAmount) {
		
		super();
		this.buyer = buyerName;
		this.auctionId = auctionId;
		BidAmount = bidAmount;
		
	}



	public boolean validateBid(List<Buyer> buyerList, List<Auction> auctionList) {
		
		//check vbuyer exists or not
		boolean validBuyer=false;
		boolean validAuction=false;
		
		for(int i=0;i<buyerList.size();i++) {
			if(buyerList.get(i).getBuyerName().equals(buyer)) {
				validBuyer = true; break;
			}
		}
		
		//check auction id  exists or not
		for(int i=0;i<auctionList.size();i++) {
			if(auctionList.get(i).getAuctionId().equals(auctionId)) {
				validAuction = true; break;
			}
		}
		
		return (validAuction && validBuyer);
		
	}



	public void  withdraw(Buyer buyer, Auction auction) {
		
	}

	public void updateBid(List<Bid> bidList) {
		
		for(int i=0;i<bidList.size();i++) {
			if(bidList.get(i).getBuyer().equals(buyer) && bidList.get(i).getAuctionId().equals(auctionId)) {
				bidList.get(i).setBidAmount(BidAmount);
			}
		}
		
	}



	public String getBuyer() {
		return buyer;
	}



	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}



	public String getAuctionId() {
		return auctionId;
	}



	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}



	public int getBidAmount() {
		return BidAmount;
	}



	public void setBidAmount(int bidAmount) {
		BidAmount = bidAmount;
	}
}
