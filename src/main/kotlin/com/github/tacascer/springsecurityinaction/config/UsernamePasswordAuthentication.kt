package com.github.tacascer.springsecurityinaction.config

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority

class UsernamePasswordAuthentication : UsernamePasswordAuthenticationToken {
    constructor(principal: Any, credentials: Any) : super(principal, credentials)

    constructor(principal: Any, credentials: Any, authorities: Collection<GrantedAuthority>)
            : super(principal, credentials, authorities)


}