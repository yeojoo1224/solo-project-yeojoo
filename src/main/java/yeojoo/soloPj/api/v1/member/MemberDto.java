import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {

    @AllArgsConstructor
    @Getter
    public static class Response{
        private long userId;
        private String name;
        private String companyLocation;
        private String companyName;
        private String companyType;
    }
}