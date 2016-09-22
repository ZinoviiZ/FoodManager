package sample.Classes;

import javax.persistence.*;

/**
 * Created by Zinoviy on 29.05.16.
 */
@Entity
@Table(name = "producer")
public class Producer {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name= "firm", length=64)
    private String firm;
    @Column(name= "rating")
    private int rating;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name= "country")
    private Country country;

    public Producer() {
    }

    public Producer( String firm, int rating) {
        this.rating = rating;
        this.firm = firm;
    }

    public Producer(String firm, int rating, Country country) {
        this.firm = firm;
        this.rating = rating;
        this.country = country;
    }

    public Producer(Long id, String firm,  Country country,  int rating) {
        this.country = country;
        this.firm = firm;
        this.id = id;
        this.rating = rating;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", firm='" + firm + '\'' +
                ", rating=" + rating +
                ", country=" + country +
                '}';
    }
}
