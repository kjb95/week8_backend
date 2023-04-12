package backend.week8.jwt.service;

import backend.week8.jwt.dto.request.AuthenticateClientRequestDto;
import backend.week8.jwt.dto.response.FindRolesResponseDto;
import backend.week8.jwt.token.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtService {
	private final AuthenticationManager authenticationManager;
	private final TokenProvider tokenProvider;

	/**
	 * 유효한 사용자면 jwt 토큰 반환
	 * 유효하지 않은 사용자면 authenticate() 에서 예외를 던짐
	 *
	 * @see backend.week8.security.service.CustomUserDetailsService#loadUserByUsername(String)
	 * authenticate() 호출시 CustomUserDetailsService.loadUserByUsername()가 호출됨
	 */
	@Transactional
	public String authenticateMember(AuthenticateClientRequestDto authenticateClientRequestDto) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authenticateClientRequestDto.getUsername(), authenticateClientRequestDto.getPassword());
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext()
				.setAuthentication(authentication);
		return tokenProvider.createToken(authentication);
	}

	/**
	 * 유저가 가진 모든 권한 조회
	 */
	public FindRolesResponseDto findRoles() {
		List<String> roles = SecurityContextHolder.getContext()
				.getAuthentication()
				.getAuthorities()
				.stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());
		return new FindRolesResponseDto(roles);
	}
}
