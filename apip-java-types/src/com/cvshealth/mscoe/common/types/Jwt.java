package com.cvshealth.mscoe.common.types;

import java.util.Map;

class JwtHeader {
    public String alg;
    public String typ;
    public String cty;
    public String[] crit;
    public String kid;
    public String jku;
    public String[] x5u;
    public String x5tS256;
    public String x5t;
    public String[] x5c;
}

class JwtPayload {
    public Map<String, Object> claims;
    public String iss;
    public String sub;
    public Object aud;
    public Long exp;
    public Long nbf;
    public Long iat;
    public String jti;
}

public class Jwt {
    public JwtHeader header;
    public Object payload; // can be JwtPayload or String
    public String signature;
}

enum Algorithm {
    HS256, HS384, HS512,
    RS256, RS384, RS512,
    ES256, ES384, ES512,
    PS256, PS384, PS512,
    none
}

