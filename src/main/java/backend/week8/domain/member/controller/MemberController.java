package backend.week8.domain.member.controller;

import backend.week8.domain.member.dto.response.RoleResponseDto;
import backend.week8.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Transactional
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    /**
     * 유저가 가진 모든 권한 조회
     */
    @GetMapping("/{username}")
    public ResponseEntity<RoleResponseDto> findRoles(@PathVariable String username) {
        RoleResponseDto rolesResponseDto = memberService.findRoles(username);
        return ResponseEntity.ok()
                .body(rolesResponseDto);
    }
}
