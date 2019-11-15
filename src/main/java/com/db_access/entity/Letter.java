package com.db_access.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "letter")
public class Letter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    @NotBlank
    @Column
    String recipient;

    @NotBlank
    @Length(min = 3, max = 128)
    @Column
    String subject;

    @NotBlank
    @Length(min = 3, max = 128)
    @Column
    String body;


    @Future
    @NotBlank
    @Column
    LocalDateTime deliveryTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Letter)) return false;
        Letter letter = (Letter) o;
        return Objects.equals(getId(), letter.getId()) &&
                Objects.equals(getRecipient(), letter.getRecipient()) &&
                Objects.equals(getSubject(), letter.getSubject()) &&
                Objects.equals(getBody(), letter.getBody()) &&
                Objects.equals(getDeliveryTime(), letter.getDeliveryTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRecipient(), getSubject(), getBody(), getDeliveryTime());
    }

}
