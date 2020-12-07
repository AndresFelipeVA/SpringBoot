package com.andrew.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
/*El password es test codificado usando la clase "EncodeNewPass.java":
 * package com.andrew.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodeNewPass {
	public static void main(String[] args) {
		BCryptPasswordEncoder codificado= new BCryptPasswordEncoder();
		String codifString =codificado.encode("test");
		System.out.println(codifString);//metodo abreviado: Sysout
	}
}*/
  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "Andres",
        "$2a$10$/OjhmCesMn.iNNwxDC147.KZbkGmyuCTR7MF8Dy.ER0murTN1zKve", "ROLE_USER_2"));
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


