package yeojoo.soloPj.api.v1.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Auditable;

import javax.persistence.*;

@Entity(name = "MEMBER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private String company_name;

    @ManyToOne
    @Column(nullable = false)
    @JoinColumn(name = "COMPANY_TYPE")
    private long company_type;

    @ManyToOne
    @Column(nullable = false)
    @JoinColumn(name = "COMPANY_LOCATION")
    private long company_location;

}
