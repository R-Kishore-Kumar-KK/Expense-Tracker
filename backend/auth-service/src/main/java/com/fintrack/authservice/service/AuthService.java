package com.fintrack.authservice.service;

import com.fintrack.authservice.dto.RegisterRequest;

public interface AuthService {

	public String register(RegisterRequest request);
}
