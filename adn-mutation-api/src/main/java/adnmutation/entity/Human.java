package adnmutation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="human")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Human implements Serializable {

    private static final long SerialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36 , nullable = false)
    private String id;

    @Column(length = 100, nullable=false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    public Human(String name){
        this.name= name;
    }

}
