package sample.Classes;

import javax.persistence.*;

/**
 * Created by Zinoviy on 29.05.16.
 */
@Entity
@Table(name = "kind")
public class Kind {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name= "kind", length=64)
    private String kind;

    public Kind() {
    }

    public Kind(String kind) {
        this.kind = kind;
    }

    public Kind(Long id, String kind) {
        this.id = id;
        this.kind = kind;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Kind{" +
                "id=" + id +
                ", kind='" + kind + '\'' +
                '}';
    }
}
