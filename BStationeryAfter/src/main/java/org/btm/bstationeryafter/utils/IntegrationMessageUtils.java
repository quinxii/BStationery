package org.btm.bstationeryafter.utils;

import java.io.IOException;
import java.net.MalformedURLException;


import org.btm.bstationeryafter.common.integrationmsg.IntegrationMessage;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

public class IntegrationMessageUtils {
    public static IntegrationMessage sendAndReceiveMessagePost(IntegrationMessage msg, String apiUrl) throws MalformedURLException {
    	try {
            // Serialize the IntegrationMessage to JSON
            String msgRequest = JsonUtility.marshal(msg);
            IntegrationMessage msgResponse = new IntegrationMessage();
            // Create a client request to send the message
            ClientRequest request = createRequest(apiUrl, msgRequest);

            // Send the request and receive the response
            ClientResponse<IntegrationMessage> response = request.post(IntegrationMessage.class);
            msgResponse = response.getEntity();

            return msgResponse;
            
        } catch (MalformedURLException e) {

			e.printStackTrace();
			
        } catch (IOException e) {
        	
            e.printStackTrace();
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            
        }

        return null;
    }
    
    public static IntegrationMessage sendAndReceiveMessagePut(IntegrationMessage msg, String apiUrl) throws MalformedURLException {
    	try {
    		// Serialize the IntegrationMessage to JSON
    		String msgRequest = JsonUtility.marshal(msg);
    		IntegrationMessage msgResponse = new IntegrationMessage();
    		// Create a client request to send the message
    		ClientRequest request = createRequest(apiUrl, msgRequest);
    		
    		// Send the request and receive the response
    		ClientResponse<IntegrationMessage> response = request.put(IntegrationMessage.class);
    		msgResponse = response.getEntity();
    		
    		return msgResponse;
    		
    	} catch (MalformedURLException e) {
    		
    		e.printStackTrace();
    		
    	} catch (IOException e) {
    		
    		e.printStackTrace();
    		
    	} catch (Exception e) {
    		
    		e.printStackTrace();
    		
    	}
    	
    	return null;
    }

    private static ClientRequest createRequest(String apiUrl, String msgRequest) throws MalformedURLException {
        ClientRequest request = new ClientRequest(apiUrl);
        request.body("application/json", msgRequest);
        return request;
    }
}


