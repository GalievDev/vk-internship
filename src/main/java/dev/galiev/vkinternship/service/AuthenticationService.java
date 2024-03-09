package dev.galiev.vkinternship.service;

import dev.galiev.vkinternship.auth.AuthRequest;
import dev.galiev.vkinternship.auth.AuthResponse;
import dev.galiev.vkinternship.auth.RegisterRequest;

public interface AuthenticationService {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse authenticate(AuthRequest request);
}
