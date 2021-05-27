package com.example.demo.main;

import java.util.List;

import com.example.demo.dao.BusinessCardManagerDao;
import com.example.demo.dto.BusinessCard;
import com.example.demo.ui.CardManagerUI;

public class CardManager {

	public static void main(String[] args) throws Exception {
		
		BusinessCardManagerDao businessCardManagerDao = new BusinessCardManagerDao();
		
		CardManagerUI cardManagerUI = CardManagerUI.getInstance();

		//무한루프 시작 3일경우 나와짐
		while_loop: while (true) {
			cardManagerUI.printMainMenu();
			int menuNumber = cardManagerUI.getMenuNumber();
			switch (menuNumber) {
			case 1:
				BusinessCard businessCard = cardManagerUI.inputBusinessCard();
				System.out.println(businessCard.getName());
				businessCardManagerDao.addBusinessCard(businessCard);
				break;
			case 2:
				String searchKeyword = cardManagerUI.getSearchKeyword();
				List<BusinessCard> businessCardList = businessCardManagerDao.searchBusinessCard(searchKeyword);
				cardManagerUI.printBusinessCards(businessCardList);
				break;
			case 3:
				cardManagerUI.printExitMessage();
				break while_loop;
			default:
				cardManagerUI.printErrorMessage();
				break;
			}
		}
	}
}
