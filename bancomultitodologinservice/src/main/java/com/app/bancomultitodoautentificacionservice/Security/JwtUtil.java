package com.app.bancomultitodoautentificacionservice.Security;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Base64;
import org.springframework.stereotype.Component;
import java.util.Date;
import javax.crypto.SecretKey;
import io.jsonwebtoken.Jwts;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ferna
 */

@Component
public class JwtUtil {
    
    private final String mi_clave = "Mi_super_clave_secreta_mira_como_es_secreta_jijo_12345678901234567890";
    private final long duracion = 1000*60*60;
    
    private SecretKey Llave_secreta(){
        
       
        return Keys.hmacShaKeyFor(mi_clave.getBytes());
    }
    
    public String GenerarToken(String usuario){
        
     return Jwts.builder().setSubject(usuario).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + duracion)).signWith( Llave_secreta(), SignatureAlgorithm.HS512).compact();
    }
    
    public String ExtraerUsuario(String token){
        
     return Jwts.parserBuilder().setSigningKey(Llave_secreta()).build().parseClaimsJws(token).getBody().getSubject();
        
        
    }
    
    
    public boolean ValidarToken(String token){
        
       try{
            Jwts.parserBuilder().setSigningKey(Llave_secreta()).build().parseClaimsJws(token);
            return true;
        }catch(Exception e){
            
            return false;
        }
    }
    
}
