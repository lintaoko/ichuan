package App.Domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin implements UserDetails, Serializable {
   private Integer userLoginId;
   private String accountNumber;
   private String password;
   private String email;
   private String phone;
   private Integer type;
   //安全模块
   private String role;
   private boolean accountNonExpired;
   private boolean accountNonLocked;
   private boolean credentialsNonExpired;
   private boolean enabled;
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return AuthorityUtils.commaSeparatedStringToAuthorityList(role);
   }
   @Override
   public String getUsername() {
      return accountNumber;
   }
   @Override
   public boolean isAccountNonExpired() {
      return accountNonExpired;
   }
   @Override
   public boolean isAccountNonLocked() {
      return accountNonLocked;
   }
   @Override
   public boolean isCredentialsNonExpired() {
      return accountNonExpired;
   }
   @Override
   public boolean isEnabled() {
      return enabled;
   }
}
