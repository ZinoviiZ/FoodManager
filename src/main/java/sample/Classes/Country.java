package sample.Classes;

import javax.persistence.*;

/**
 * Created by Zinoviy on 29.05.16.
 */
@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name= "country", length=64)
    private String country;

    public Country() {
    }

    public Country(String country) {
        this.country = country;
    }

    public Country(Long id, String country) {
        this.id = id;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", country='" + country + '\'' +
                '}';
    }
}
