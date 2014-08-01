package sqample.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import sample.data.UserLogin;
import sample.data.UserLoginRepository;



public class UserLoginRepositoryUserDetailsService implements UserDetailsService{

	 private final UserLoginRepository userRepository;

	    @Autowired
	    public UserLoginRepositoryUserDetailsService(UserLoginRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    /* (non-Javadoc)
	     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	     */
	    @Override
	    public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException {
	        UserLogin user = userRepository.findByEmail(username);
	        if(user == null) {
	            throw new UsernameNotFoundException("Could not find user " + username);
	        }
	        return new UserLoginRepositoryUserDetails(user);
	    }

	    private final static class UserLoginRepositoryUserDetails extends UserLogin implements UserDetails {

	        private UserLoginRepositoryUserDetails(UserLogin user) {
	            super(user);
	        }

	        @Override
	        public Collection<? extends GrantedAuthority> getAuthorities() {
	            return AuthorityUtils.createAuthorityList("ROLE_USER");
	        }

	        @Override
	        public String getUsername() {
	            return getEmail();
	        }

	        @Override
	        public boolean isAccountNonExpired() {
	            return true;
	        }

	        @Override
	        public boolean isAccountNonLocked() {
	            return true;
	        }

	        @Override
	        public boolean isCredentialsNonExpired() {
	            return true;
	        }

	        @Override
	        public boolean isEnabled() {
	            return true;
	        }

	        private static final long serialVersionUID = 5639683223516504866L;
	    }
}
