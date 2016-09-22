package sample.Classes;

import javax.persistence.*;

/**
 * Created by Zinoviy on 29.05.16.
 */
@Entity
@Table(name = "packing")
public class Packing
{
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name= "packing", length=64)
    private String packing;
    @Column(name= "weight")
    private int weight;

    public Packing() {
    }

    public Packing(String packing, int weight) {
        this.packing = packing;
        this.weight = weight;
    }

    public Packing(Long id, String packing, int weight) {
        this.id = id;
        this.packing = packing;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Packing{" +
                "id=" + id +
                ", packing='" + packing + '\'' +
                ", weight=" + weight +
                '}';
    }
}
