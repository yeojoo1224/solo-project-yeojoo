package yeojoo.soloPj.api.v1.member;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    public Page<Member> findUsers(int page, int size){
        return null;
    }

    public Page<Member> findUsersByCondition(int page, int size, String[] location, String companyType){
        return null;
    }


}