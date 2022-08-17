package yeojoo.soloPj.api.v1.member;

import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    default List<MemberDto.Response> usersToUsersResponseDtos(List<Member> users){
        return users.stream()
                .map(member -> {
                    return new MemberDto.Response(
                            member.getId(),
                            member.getName(),
                            member.getCompany_location(),
                            member.getCompany_name(),
                            member.getCompany_type()
                    );
                })
                .collect(Collectors.toList());
    }
}