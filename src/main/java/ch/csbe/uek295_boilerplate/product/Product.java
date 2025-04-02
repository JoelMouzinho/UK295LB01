package ch.csbe.uek295_boilerplate.product;

import ch.csbe.uek295_boilerplate.category.Category;
import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(columnDefinition = "VARCHAR(100)")
    private String sku;

    @Column(columnDefinition = "TINYINT")
    private int active;

    @Column(columnDefinition = "VARCHAR(500)")
    private String name;

    @Column(columnDefinition = "VARCHAR(1000)")
    private String image;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;

    @Column(columnDefinition = "FLOAT")
    private float price;

    @Column(columnDefinition = "INT")
    private int stock;

    @ManyToOne()private Category category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
