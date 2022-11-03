package site.metacoding.miniproject2.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.UsersReqDto.JoinReqDto;
import site.metacoding.miniproject2.service.UsersService;

@RequiredArgsConstructor
@RestController
public class UsersApiController {
    private final UsersService usersService;
    // private final HttpSession session;

    // 성유 작업
    @PostMapping("/join")
    public CMRespDto<?> joinUser(@RequestBody JoinReqDto joinReqDto) {
        return new CMRespDto<>(1, "ok", usersService.insert(joinReqDto));
    }

    // @PostMapping("/login")
    // public CMRespDto<?> login(@RequestBody LoginReqDto loginReqDto) {
    // SessionUsers sessionUsers = usersService.findByUserId(loginReqDto);
    // session.setAttribute("sessionUsers", sessionUsers);
    // return new CMRespDto<>(1, "ok", sessionUsers);
    // }
    // 성유 작업 종료

    // 서현 작업
    @GetMapping("/s/mypage/{id}")
    public CMRespDto<?> findAllInfo(@PathVariable Integer id) {
        return new CMRespDto<>(1, "성공", usersService.findAllInfo(id));
    }
    // 서현 작업 종료

}