package yeojoo.soloPj.api.v1.member;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final MemberService memberService;
    private final MemberMapper mapper;

    @GetMapping
    public ResponseEntity getUsers(@Positive @RequestParam int page,
                                   @Positive @RequestParam int size){

        Page<Member> users = userService.findUsers(page-1, size);
        List<MemberDto.Response> data = mapper.usersToUsersResponseDtos(users.getContent());
        return new ResponseEntity(new MultiResponseDto(data, users), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity getUsersByCondition(@Positive @RequestParam int page,
                                              @Positive @RequestParam int size,
                                              @RequestParam(required = false) String country,
                                              @RequestParam(required = false) String class1,
                                              @RequestParam(required = false) String class2,
                                              @RequestParam(required = false) String type){
        String[] location = new String[]{country, class1, class2};
        Page<User> pageUsers = userService.findUsersByCondition(page-1, size, location, type);
        System.out.println(pageUsers);
        List<UserDto.Response> data = mapper.usersToUsersResponseDtos(pageUsers.getContent());
        return new ResponseEntity(new MultiResponseDto<>(data, pageUsers), HttpStatus.OK);
    }
}