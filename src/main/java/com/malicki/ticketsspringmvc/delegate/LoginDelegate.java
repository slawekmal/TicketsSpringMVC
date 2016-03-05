package com.malicki.ticketsspringmvc.delegate;

import com.malicki.ticketsspringmvc.service.ClientService;
import java.sql.SQLException;

public class LoginDelegate
{
	private ClientService clientService;

	public ClientService getClientService()
	{
		return this.clientService;
	}

	public void setClientService(ClientService clientService)
	{
		this.clientService = clientService;
	}

	public boolean isValidUser(String email, String password) throws SQLException
	{
	    return clientService.isValidUser(email, password);
	}
}

