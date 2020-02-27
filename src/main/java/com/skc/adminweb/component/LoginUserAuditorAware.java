package com.skc.adminweb.component;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginUserAuditorAware implements AuditorAware {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("AdminServer");
    }

}
