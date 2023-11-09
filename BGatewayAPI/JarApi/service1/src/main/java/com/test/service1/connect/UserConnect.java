package com.test.service1.connect;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.springframework.stereotype.Service;

import com.test.service1.model.UserProfile;

import btm.com.common.integrationmessage.IntegrationMessage;
import btm.com.common.integrationmessage.IntegrationMessageBody;
import btm.com.common.integrationmessage.IntegrationMessageHeader;
import btm.com.common.model.UserProfileMessage;

@Service
public class UserConnect {
	public IntegrationMessage getAllUser(String msg) {
		IntegrationMessage msgResponse = new IntegrationMessage();
		try {
			ClientRequest request = new ClientRequest("http://localhost:9090/api/user/all");
			request.queryParameter("msg", msg);
			
			ClientResponse<IntegrationMessage> response = request.get(IntegrationMessage.class);
			msgResponse = response.getEntity();
			return msgResponse;
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return msgResponse;
	}
	
}
