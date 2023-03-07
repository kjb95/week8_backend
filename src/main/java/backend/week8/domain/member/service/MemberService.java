package backend.week8.domain.member.service;

import backend.week8.domain.member.dto.RoleResponseDto;
import backend.week8.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private static final String NOT_FOUND_USERNAME = " : 존재하지 않는 username 입니다.";
    private final MemberRepository memberRepository;

    public RoleResponseDto findRoles(String username) {
        List<String> allRoles = memberRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + NOT_FOUND_USERNAME))
                .getRole()
                .findAllRoles();
        return new RoleResponseDto(allRoles);
    }
}
