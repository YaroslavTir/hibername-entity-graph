package com.yaroslavtir.sample.domain;

/**
 * @author ymolodkov on 23.03.17.
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity
@Data
public class Product implements Serializable {
    @Id
    private Long id = 0L;

    @Column
    private String name;

}
