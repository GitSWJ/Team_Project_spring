package com.example.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "DRAMA_LIKE")
@Data
@SequenceGenerator(
    name = "LIKE_DRAMA",
    sequenceName = "SEQ_LIKE_DRAMA_NO",
    initialValue = 1,
    allocationSize = 1
    )
public class Drama_Like {
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "LIKE_DRAMA"
         )
    @Column(name = "ID")
    Long id;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
    @Column(name = "REGDATE", updatable = false)
    private Date regdate = null;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "DRAMA_CODE", referencedColumnName = "ID")
    DramaContent dramacode;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    Member userid;

    
}