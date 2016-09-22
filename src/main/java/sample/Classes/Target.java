package sample.Classes;

import javax.persistence.*;

/**
 * Created by Zinoviy on 29.05.16.
 */
@Entity
@Table(name = "target")
public class Target {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name= "target", length=64)
    private String target;

    public Target() {
    }

    public Target(String target) {
        this.target = target;
    }

    public Target(Long id, String target) {
        this.id = id;
        this.target = target;
    }

    public Long getId() {
        return id;
    }

    public String getTarget() {
        return target;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Target{" +
                "id=" + id +
                ", target='" + target + '\'' +
                '}';
    }
}
