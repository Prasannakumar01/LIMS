package org.NewaInsurance_GenrericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int count = 0;
		int countlimit = 3;

		while (count < countlimit) {
			count++;
			return true;
		}

		return false;
	}

}
