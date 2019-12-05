package nghia.phone.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "catergories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long catergory_id;
    private String catergory_name;
    private String catergory_description;

    @OneToMany(targetEntity = Phone.class)
    private Set<Phone> phones;


    public Category() {
    }

    public Category(String catergory_name, String catergory_description, Set<Phone> phones) {
        this.catergory_name = catergory_name;
        this.catergory_description = catergory_description;
        this.phones = phones;
    }

    public Long getCatergory_id() {
        return catergory_id;
    }

    public void setCatergory_id(Long catergory_id) {
        this.catergory_id = catergory_id;
    }

    public String getCatergory_name() {
        return catergory_name;
    }

    public void setCatergory_name(String catergory_name) {
        this.catergory_name = catergory_name;
    }

    public String getCatergory_description() {
        return catergory_description;
    }

    public void setCatergory_description(String catergory_description) {
        this.catergory_description = catergory_description;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}
