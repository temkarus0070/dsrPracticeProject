package org.temkarus0070.dsrpracticeproject.security;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfigGlobalMethodSecurity extends GlobalMethodSecurityConfiguration {

}