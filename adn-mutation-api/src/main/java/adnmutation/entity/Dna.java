package adnmutation.entity;


import adnmutation.json.DnaBuild;
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
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@EqualsAndHashCode(exclude = {"id"})
@Table(name="dna")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Dna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36 , nullable = false)
    private String id;

    @JdbcTypeCode( SqlTypes.JSON )
    @Column
    private DnaBuild dna;

    @Column
    private boolean hasMuation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "human_id")
    private Human human;

    public Dna(final DnaBuild dna, final Human human){
        this.dna= dna;
        this.human= human;
    }

}
