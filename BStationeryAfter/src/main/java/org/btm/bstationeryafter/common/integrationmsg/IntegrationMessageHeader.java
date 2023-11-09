package org.btm.bstationeryafter.common.integrationmsg;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class IntegrationMessageHeader implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("errorCode")
	private String errorCode;
	
	@JsonProperty("status")
	private String errorDetail;
	
	@JsonProperty("addressIp")
	private String addressIp;
	
	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public String getAddressIp() {
		return addressIp;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

	public void setAddressIp(String addressIp) {
		this.addressIp = addressIp;
	}

	public IntegrationMessageHeader(String errorCode, String errorDetail, String addressIp) {
		super();
		this.errorCode = errorCode;
		this.errorDetail = errorDetail;
		this.addressIp = addressIp;
	}

	public IntegrationMessageHeader() {

	}
}
