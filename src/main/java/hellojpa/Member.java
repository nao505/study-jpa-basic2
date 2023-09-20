package hellojpa;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "member-seq_generator", sequenceName = "member-seq")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member-seq_generator")
    private Long id;

    @Column(name = "name", nullable = false)
    private String userName;

    public Member() {
    }

    public Member(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}