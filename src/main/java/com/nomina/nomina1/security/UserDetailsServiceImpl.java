package com.nomina.nomina1.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import com.nomina.nomina1.model.IEmpleado;
import com.nomina.nomina1.model.Cargo;
//import com.nomina.nomina1.model.Cargo;
import com.nomina.nomina1.model.Empleado;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

   @Autowired
    private IEmpleado empleadoI;

    /*
     * @Override
     * public UserDetails loadUserByUsername(String emailEmpleado) throws
     * UsernameNotFoundException {
     * Empleado empleado = empleadoI.findByEmailEmpleado(emailEmpleado);
     * System.out.println(empleado.getApellidoEmpleado());
     * UserBuilder builder = null;
     * 
     * if (empleado != null) {
     * builder = User.withUsername(emailEmpleado);
     * builder.disabled(false);
     * builder.password(empleado.getPassword());
     * builder.authorities(getAuthorities(empleado));
     * } else {
     * throw new UsernameNotFoundException("empleado no encontrado");
     * }
     * 
     * return builder.build();
     * }*/
     

    @Override
    public UserDetails loadUserByUsername(String docEmpleado) throws UsernameNotFoundException {
        /*final Empleado usu = empleadoI.findByDocEmpleado(docEmpleado);
        System.out.println(docEmpleado);
        if (usu == null) {
            throw new UsernameNotFoundException(docEmpleado);
        }

        final UserDetails user = User.withUsername(usu.getDocEmpleado())
                .password(usu.getPassword())
                .authorities(getAuthorities(usu)).build()
                ;

        return user;*/
        Empleado empleado = empleadoI.findByDocEmpleado(docEmpleado);
        UserBuilder builder = null;

        if (empleado != null) {
            builder = User.withUsername(docEmpleado);
            builder.disabled(false);
            builder.password(empleado.getPassword());
            builder.authorities(getAuthorities(empleado));
        } else {
            throw new UsernameNotFoundException("usuario no encontrado");
        }

        return builder.build();
    }

    private GrantedAuthority getAuthorities(Empleado user){
        Cargo userGroups = user.getFKcargo();
        GrantedAuthority authorities = new SimpleGrantedAuthority(userGroups.getNombreCargo().toUpperCase());

        return authorities;
    }
  }
