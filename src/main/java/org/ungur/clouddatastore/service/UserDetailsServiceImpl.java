package org.ungur.clouddatastore.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ungur.clouddatastore.model.Role;
import org.ungur.clouddatastore.model.User;

/*@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
	@Autowired(required=true)
    private org.ungur.clouddatastore.repository.UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String fullName) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(fullName);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getFullName(), user.getPassword(), grantedAuthorities);
	}
}*/


