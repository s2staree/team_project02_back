package site.metacoding.miniproject2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.users.Users;
import site.metacoding.miniproject2.domain.users.UsersDao;
import site.metacoding.miniproject2.dto.UsersReqDto.JoinReqDto;
import site.metacoding.miniproject2.dto.UsersRespDto.InfoAllRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.InfoCountRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.InfoRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.JoinRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.RecommendByPositionRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.StatusCountRespDto;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersDao usersDao;

    public JoinRespDto insert(JoinReqDto joinReqDto) {
        Users users = joinReqDto.toEntity();
        usersDao.insert(users);
        return new JoinRespDto(users);
    }

    // public SessionUsers findByUserId(LoginReqDto loginReqDto) {
    // Users usersPS = usersDao.findByUserId(loginReqDto.getId());
    // if (usersPS.getUserPassword().equals(loginReqDto.getUserPassword())) {
    // return null;
    // } else {
    // throw new RuntimeException("아이디 혹은 패스워드가 잘못 입력되었습니다.");
    // }
    // }

    public void findById() {
        usersDao.findById(null);
    }

    public void update() {
        usersDao.update();
    }

    public void updateByPassword() {
        usersDao.updateByPassword(null);
    }

    public void deleteById() {
        usersDao.deleteById(null);
    }

    public void updateProfile() {
        usersDao.updateProfile();
    }

    // 서현 작업
    public InfoAllRespDto findAllInfo(Integer id) {
        List<InfoRespDto> infoRespDtos = usersDao.findInfo(id);
        List<InfoCountRespDto> infoCountRespDtos = usersDao.findInfoCounts(id);
        List<RecommendByPositionRespDto> recommendByPositionRespDtos = usersDao.findByPosition(id);
        if (recommendByPositionRespDtos.size() == 0) {
            recommendByPositionRespDtos = usersDao.findByPositionIfNull();
        }
        List<StatusCountRespDto> statusCountRespDtos = usersDao.findStatusCounts(id);
        InfoAllRespDto InfoAllRespDto = new InfoAllRespDto(infoRespDtos, infoCountRespDtos, recommendByPositionRespDtos,
                statusCountRespDtos);
        return InfoAllRespDto;
    }
    // 서현 작업 종료
}