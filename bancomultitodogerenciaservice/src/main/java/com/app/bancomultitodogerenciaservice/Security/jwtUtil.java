/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodogerenciaservice.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;

/**
 *
 * @author ferna
 */
public class jwtUtil {
    
    
    private final String mi_clave = "Mi_super_clave_secreta_mira_como_es_secreta_jijo_12345678901234567890";
    private final long duracion = 1000*60*60;
    
    private SecretKey Llave_secreta(){
        
       
        return Keys.hmacShaKeyFor(mi_clave.getBytes());
    }
    
    public String GenerarToken(String usuario){
        
     return Jwts.builder().setSubject(usuario).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + duracion)).signWith( Llave_secreta(), SignatureAlgorithm.HS512).compact();
    }
    
    public String ExtraerUsuario(String token){
        
     return Jwts.parser().setSigningKey(Llave_secreta()).parseClaimsJws(token).getBody().getSubject();
        
        
    }
    
    
    public boolean ValidarToken(String token){
        
       try{
            Jwts.parser().setSigningKey(Llave_secreta()).parseClaimsJws(token);
            return true;
        }catch(Exception e){
            
            return false;
        }
    }
    
}
