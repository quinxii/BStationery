package com.test.service1.common.integrationmessage;

import java.io.Serializable;

public class IntegrationMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	private IntegrationMessageHeader header;
	private IntegrationMessageBody body;

	public IntegrationMessageHeader getHeader() {
		return header;
	}

	public IntegrationMessageBody getBody() {
		return body;
	}

	public void setHeader(IntegrationMessageHeader header) {
		this.header = header;
	}

	public void setBody(IntegrationMessageBody body) {
		this.body = body;
	}

	public IntegrationMessage(IntegrationMessageHeader header, IntegrationMessageBody body) {
		super();
		this.header = header;
		this.body = body;
	}

	public IntegrationMessage() {

	}

}
