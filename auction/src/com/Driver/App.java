package com.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import com.model.Buyer;
import com.model.Seller;
import com.model.Auction;
import com.model.Bid;

public class App {

//	private static final String Auction = null;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
//		System.out.println(
//				"Enter option: 1.Add_Buyer 2.ADD_SELLER 3.Create_Auction 4.Create_Bid 5.Update_Bid 6.Close_Auction 7.Withdraw_Bid 8.Get_Profit 9.Exit");
		List<Buyer> buyerList = new LinkedList<>();
		List<Auction> auctionList = new LinkedList<>();
		List<Bid> bidList = new LinkedList<>();
		List<Seller> sellerList=new LinkedList<>();
		while (true) {
//			System.out.println(
//					"Enter option: 1.Add_Buyer 2.ADD_SELLER 3.Create_Auction 4.Create_Bid 5.Update_Bid 6.Close_Auction 7.Withdraw_Bid 8.Get_Profit 9.Exit");
			
			String option = sc.next();
			if (option.equals("1")) {
				// add buyer
				String buyerName = sc.next();
				Buyer buyer = new Buyer(buyerName);
				buyerList.add(buyer);

//				buyerList.get(0).getBuyerName();

			} else if (option.equals("2")) {
				// add seller
				String SellerName = sc.next();
				Seller seller = new Seller(SellerName);
				sellerList.add(seller);

			} else if (option.equals("3")) {
				// create_auction
				String auctionId = sc.next();
				int lowestBidLimit = sc.nextInt();
				int higestBidLimit = sc.nextInt();
				int participationCost = sc.nextInt();
				String sellerName = sc.next();
//				System.out.println(auctionId);
//				System.out.println(lowestBidLimit);
//				System.out.println(higestBidLimit);
//				System.out.println(participationCost);
//				System.out.println(sellerName);
				Seller seller = new Seller(sellerName);
				Auction auction = new Auction(auctionId, lowestBidLimit, higestBidLimit, participationCost, seller);

				auctionList.add(auction);

			} else if (option.equals("4")) {
				// create bid
				String BuyerName = sc.next();
				String auctionId = sc.next();
				int bidAmount = sc.nextInt();
				Bid bid = new Bid(BuyerName, auctionId, bidAmount);

				if (bid.validateBid(buyerList, auctionList)) {
					bidList.add(bid);
				}

			} else if (option.equals("5")) {
				// Update_Bid
				String BuyerName = sc.next();
				String auctionId = sc.next();
				int bidAmount = sc.nextInt();
				Bid bid = new Bid(BuyerName, auctionId, bidAmount);

				if (bid.validateBid(buyerList, auctionList)) {
					bid.updateBid(bidList);
				}

			} else if (option.equals("6")) {
				// Close_Auction
				String auctionId = sc.next();

				// check auction id valid or not
				boolean validAuctionId = false;

				for (int i = 0; i < auctionList.size(); i++) {
					if (auctionList.get(i).getAuctionId().equals(auctionId)) {
						validAuctionId = true;
						break;
					}
				}
				if (validAuctionId) {
					// find winner

//					find all bids for the auctionId
					TreeMap<Integer, Integer> bids = new TreeMap<>(Collections.reverseOrder());
//			
					for (int i = 0; i < bidList.size(); i++) {
						if (bidList.get(i).getAuctionId().equals(auctionId)) {
							int bidAmount = bidList.get(i).getBidAmount();
							bids.put(bidAmount, bids.getOrDefault(bidAmount, 0) + 1);
						}
					}
					int getWinnerAmount = 0;

					for (Entry<Integer, Integer> entry : bids.entrySet()) {

						if (entry.getValue() <= 1) {
							getWinnerAmount = entry.getKey();
							break;
						}
					}
					if (getWinnerAmount > 0) {
						for (int i = 0; i < bidList.size(); i++) {
							if (bidList.get(i).getBidAmount() == getWinnerAmount) {
								System.out.println(bidList.get(i).getBuyer() + " is winner.");
							}
						}
					} else {
						System.out.println("No winner");
					}

				} else {
					System.out.println("Not a valid auction Id");
				}

			} else if (option.equals("7")) {
				// withdraw ibd
				String buyer=sc.next();
				String auctionId=sc.next();
				boolean validWithdrawBid=false;
				for (int i = 0; i < bidList.size(); i++) {
					if (bidList.get(i).getBuyer().equals(buyer) && bidList.get(i).getAuctionId().equals(auctionId) ) {
						validWithdrawBid=true; bidList.remove(i);
					}
				}
				if(!validWithdrawBid) {
					System.out.println("Invalid inputs for withdraw");
				}
				
			} else if (option.equals("8")) {
				//get profit
				
				
			} else if (option.equals("9")) {
				System.exit(0);
			} else {
				System.out.println("enter valid input ");
			}
		}
	}

}
