package com.yaroslavtir.sample.domain;

/**
 * @author ymolodkov on 23.03.17.
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name = "product")
@Entity
@Data
public class Product implements Serializable {

    @Id
    private Long id = 0L;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProductLine line;


    @JoinColumn(name = "id")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProductDetail> detail = new HashSet<>();


    //we cannot use lazy field in equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (line != null ? !line.equals(product.line) : product.line != null) return false;
        return true;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (line != null ? line.hashCode() : 0);
//        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        return result;
    }
}
