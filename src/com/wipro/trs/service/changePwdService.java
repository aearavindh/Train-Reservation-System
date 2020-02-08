package com.wipro.trs.service;

import com.wipro.trs.bean.changePwdBean;
import com.wipro.trs.dao.changePwdDAO;

public class changePwdService {
	public String changePwd(changePwdBean CB)
	 {
		 String status="";
		 changePwdDAO CD=new changePwdDAO();
		 int count=CD.changePwd(CB);
		 if(count==1)
			 status="Success";
		 else
			 status="Fail";
		 return status;
	 }


}
