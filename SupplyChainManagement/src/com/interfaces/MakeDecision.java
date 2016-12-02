package com.interfaces;

import com.items.Request;

public interface MakeDecision {

	public void approveRequest(Request request);
	public void rejectRequest(Request request);
}
