package sample.Classes;

import javax.persistence.*;

/**
 * Created by Zinoviy on 29.05.16.
 */
@Table
@Entity(name = "head")
public class Head
{
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "name", length=64)
    private String name;

    @Column(name= "info", length=64)
    private String info;

    @Column(name= "ussing", length=64)
    private String ussing;

    @Column(name= "price")
    private int price;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name= "producer")
    private Producer producer;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name= "packing")
    private Packing packing;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name= "kind")
    private Kind kind;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name= "target")
    private Target target;

    public Head() {
    }

    public Head(String name, String info, String using, int price, Producer producer, Packing packing, Kind kind, Target target) {
        this.name = name;
        this.info = info;
        this.ussing = using;
        this.price = price;
        this.producer = producer;
        this.packing = packing;
        this.kind = kind;
        this.target = target;
    }

    @Override
    public String toString() {
        return "Head{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", ussing='" + ussing + '\'' +
                ", price=" + price +
                ", producer=" + producer +
                ", packing=" + packing +
                ", kind=" + kind +
                ", target=" + target +
                '}';
    }

    public Head(Long id, String name, String info, String ussing, int price, Producer producer, Packing packing, Kind kind, Target target) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.ussing = ussing;
        this.price = price;
        this.producer = producer;
        this.packing = packing;
        this.kind = kind;
        this.target = target;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUsing() {
        return ussing;
    }

    public void setUsing(String using) {
        this.ussing = using;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Packing getPacking() {
        return packing;
    }

    public void setPacking(Packing packing) {
        this.packing = packing;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }
}
