/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebssas.wsrestapicoopedac.seguridad;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Brayan F Silva R
 */
public class JwtTokenHelper {

    private final Long currentTimeInMillis = System.currentTimeMillis();

    public JwtTokenHelper() {
    }

    public String generateJwtTokenSucces(HashMap<String, Object> valToken) {
        Map<String, Object> map = new HashMap<>();
        //SE ESTABLECE LA CABECERA
        map.put("typ", "JWT");
        map.put("alg", "HS512");
        return Jwts
                .builder()
                .setHeader(map)//Se agregan los encabezados
                .setIssuer("WSRestAPIPINC")
                .setSubject("WS_CONSUMES_API_REST_PINC")
                .setIssuedAt(new Date(currentTimeInMillis))
                .setExpiration(getExpirationDate())
                .signWith(SignatureAlgorithm.HS512, RestSecurityFilter.KEY)
                .claim("valToken", valToken)
                .compact();
    }

    public String generateJwtTokenError(HashMap<String, Object> valToken) {
        Map<String, Object> map = new HashMap<>();
        //SE ESTABLECE LA CABECERA
        map.put("typ", "JWT");
        map.put("alg", "HS512");
        return Jwts
                .builder()
                .setHeader(map)//Se agregan los encabezados
                .setIssuer("WSRestAPIPINC")
                .setSubject("WS_CONSUMES_API_REST_PINC")
                .claim("valToken", valToken)
                .compact();
    }

    public String issueTokenAuth() {
        //Se crea token
        Map<String, Object> map = new HashMap<>();
        //SE ESTABLECE LA CABECERA
        map.put("typ", "JWT");
        map.put("alg", "HS512");
        //SE OBTIENE FECHA Y HORA PARA CALCULAR VIGENCIA DE TOKEN
        Calendar cal = Calendar.getInstance();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(cal.getTime());
        cal1.add(Calendar.SECOND, 120);
        String jwtToken = Jwts.builder()
                .setHeader(map)//Se agregan los encabezados
                .setIssuer("WSRestAPIPINC")
                .setSubject("WS_CONSUMES_API_REST_PINC")
                .claim("bGenerateToken", Boolean.TRUE)
                .setIssuedAt(cal.getTime())
                .setExpiration(cal1.getTime())
                .signWith(SignatureAlgorithm.HS512, RestSecurityFilter.KEY) //Algoritmo de encriptación
                .compact();
        return jwtToken;
    }

    private Date getExpirationDate() {
        String sTimeOutSession = "980";
        Long lTimeOutSession = new Long(sTimeOutSession);
        lTimeOutSession = lTimeOutSession * 100000;
        return new Date(currentTimeInMillis + lTimeOutSession);
    }
}
