package com.yaroslavtir.sample.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author ymolodkov on 27.03.17.
 */
@MappedSuperclass
@Getter
@Setter
public class AbstractEntity implements Serializable {

    @Id
    @Type(type="uuid-char")
    @Column(name = "id", length = 36)
    private UUID id;

    @PrePersist
    protected void prePersist() {
        if(this.id == null) {
            this.id = UUID.randomUUID();
        }
    }


    //todo this method is not correct but it is fine for demo application
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;

        AbstractEntity that = (AbstractEntity) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
