package com.yaroslavtir.sample.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ymolodkov on 24.03.17.
 */
@Table
@Entity
@Data
public class ProductLine {

    @Id
    private Long id = 0L;

    @Column
    private String line;

    @Column
    private String textDescription;

}
