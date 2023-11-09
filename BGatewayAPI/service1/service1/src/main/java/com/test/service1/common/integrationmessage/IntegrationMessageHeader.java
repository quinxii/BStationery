package com.test.service1.common.integrationmessage;

import java.io.Serializable;

public class IntegrationMessageHeader implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String ERROR_Code;
	private String ERROR_Detail;
	private String AddressIp;

	public String getERROR_Code() {
		return ERROR_Code;
	}

	public String getERROR_Detail() {
		return ERROR_Detail;
	}

	public String getAddressIp() {
		return AddressIp;
	}

	public void setERROR_Code(String eRROR_Code) {
		ERROR_Code = eRROR_Code;
	}

	public void setERROR_Detail(String eRROR_Detail) {
		ERROR_Detail = eRROR_Detail;
	}

	public void setAddressIp(String addressIp) {
		AddressIp = addressIp;
	}

	public IntegrationMessageHeader(String eRROR_Code, String eRROR_Detail, String addressIp) {
		super();
		ERROR_Code = eRROR_Code;
		ERROR_Detail = eRROR_Detail;
		AddressIp = addressIp;
	}

	public IntegrationMessageHeader() {

	}

}
