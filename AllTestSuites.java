package com.perscholas.homeinsurance.dao.JUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/* @Author Neerja Balasubramanian
 */
@RunWith(Suite.class)
@SuiteClasses(
		{
			UserDAOTest.class,
			LocationPageDAOTest.class,
			QuoteDetailsDAOTest.class,
			PolicyDetailsDAOTest.class,
			PropertyDetailsDAOTest.class,
			HomeOwnerDAOTest.class
		}
		)
public class AllTestSuites {	

}
