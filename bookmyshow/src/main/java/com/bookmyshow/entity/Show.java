package com.bookmyshow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "SHOW")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Show implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SID", nullable = false)
    private long id;
    @Column(name = "SHOW_NAME", nullable = false)
    private String name;
    @Column(name = "TIME", nullable = false)
    private LocalDateTime time;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MID")
    private Movie movie;

    @ManyToOne
    @JsonIgnore
    private Theatre theatre;

}
