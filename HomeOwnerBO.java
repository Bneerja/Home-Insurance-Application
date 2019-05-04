package com.perscholas.homeinsurance.bo;

import java.util.List;

import com.perscholas.homeinsurance.HomeOwner;
import com.perscholas.homeinsurance.dao.HomeOwnerDAO;

/* @Author Neerja Balasubramanian
 */
public class HomeOwnerBO {

	public int addHomeOwner(HomeOwner homeowner) {
		HomeOwnerDAO homeowner_dao = new HomeOwnerDAO();
		return homeowner_dao.addHomeOwner(homeowner);
	}

	public List<HomeOwner> getAllHomeOwners() {
		HomeOwnerDAO homeowner_dao = new HomeOwnerDAO();
		return homeowner_dao.getAllHomeOwners();
	}

	public HomeOwner getHomeOwner(int userid) {
		HomeOwnerDAO homeowner_dao = new HomeOwnerDAO();
		return homeowner_dao.getHomeOwner(userid);
	}
}
