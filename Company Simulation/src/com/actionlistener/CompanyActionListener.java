package com.actionlistener;

import java.util.EventListener;

public interface CompanyActionListener extends EventListener{

	public void companyActionOccurred(CompanyAction evt);

}
