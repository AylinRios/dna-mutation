package adnmutation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;


@Entity
@Getter
@EqualsAndHashCode(exclude = {"id"})
@Table(name="user_info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36 , nullable = false)
    private String id;

    @Column(length = 100, nullable = false)
    private String  name;
    @Column(length = 100, nullable = false)
    private String  paternalName;

    @Column(length = 100)
    private String  maternalName;

    @Column(length = 100, nullable = false)
    private String  email;

    @Column(length = 100, nullable = false)
    private String  birthday;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public UserInfo(final String name, final String paternalName,final String maternalName, final String email, final String birthday, final User user) {
        this.name = name;
        this.paternalName = paternalName;
        this.maternalName = maternalName;
        this.email = email;
        this.birthday = birthday;
        this.user = user;
    }

}
