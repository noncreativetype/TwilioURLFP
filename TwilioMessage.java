package com.twilio.sdk.examples;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.TwilioRestResponse;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.AvailablePhoneNumber;
import com.twilio.sdk.resource.instance.Call;
import com.twilio.sdk.resource.instance.Conference;
import com.twilio.sdk.resource.instance.Participant;
import com.twilio.sdk.resource.list.AccountList;
import com.twilio.sdk.resource.list.AvailablePhoneNumberList;
import com.twilio.sdk.resource.list.ParticipantList;
import com.twilio.sdk.verbs.TwiMLException;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.*;

public class TwilioMessage {

	/** The Constant ACCOUNT_SID. Find it at twilio.com/user/account */
	public static final String ACCOUNT_SID = "ACd7f12bf28315a149aa20c0f7888957dd";

	/** The Constant AUTH_TOKEN. Find it at twilio.com/user/account */
	public static final String AUTH_TOKEN = "53afb8fd8988436059b29a59d1975fbc";

	public static void main(String[] args) throws TwilioRestException {

		// Create a rest client
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

		// Get the main account (The one we used to authenticate the client)
		Account mainAccount = client.getAccount();

		// Get all accounts including sub accounts
		AccountList accountList = client.getAccounts();

		// All lists implement an iterable interface, you can use the foreach
		// syntax on them
		for (Account a : accountList) {
			System.out.println(a.getFriendlyName());
		}

		// Send an sms (using the new messages endpoint)
		MessageFactory messageFactory = mainAccount.getMessageFactory();
		List<NameValuePair> messageParams = new ArrayList<NameValuePair>();
		messageParams.add(new BasicNameValuePair("To", "9142991173")); // Replace with a valid phone number
		messageParams.add(new BasicNameValuePair("From", "9142054512")); // Replace with a valid phone
		// number in your account
		messageParams.add(new BasicNameValuePair("Body", "Hello from Fabian Patino"));
		messageFactory.create(messageParams);
	}
	
}
