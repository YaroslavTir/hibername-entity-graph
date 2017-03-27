package com.yaroslavtir.sample.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ymolodkov on 24.03.17.
 */
@Table
@Entity
@Setter
@Getter
public class ProductDetail extends AbstractEntity {


    @Column
    private String detail;


}
