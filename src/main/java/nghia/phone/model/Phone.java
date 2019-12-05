package nghia.phone.model;


import javax.persistence.*;

@Entity
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long phone_id;
    private String phoneName;
    private String dateOfPurchase;
    private Double phone_price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Phone() {
    }

    public Phone(String phoneName, String dateOfPurchase, Double phone_price, String description, Category category) {
        this.phoneName = phoneName;
        this.dateOfPurchase = dateOfPurchase;
        this.phone_price = phone_price;
        this.description = description;
        this.category = category;
    }

    public Long getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(Long phone_id) {
        this.phone_id = phone_id;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Double getPhone_price() {
        return phone_price;
    }

    public void setPhone_price(Double phone_price) {
        this.phone_price = phone_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
