package com.mb.springbootjaxrssoap.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String code;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Enumerated(EnumType.STRING)
    private TypeAccount type;

    @ManyToOne
    private Customer customer;

    @PrePersist
    public void init(){
        if (createdDate==null)
               createdDate= new Date();
    }


}
