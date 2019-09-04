package com.techprimers.springbootwebsocketexample.entity;

import java.sql.Timestamp;
import javax.persistence.*;


@Entity
@Table(name = "sensor_h11")
public class Sensor_h11 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_temp")
    private String name_temp;

    @Column(name = "name_hum")
    private String name_hum;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "value_temp")
    private float valuee_temp;

    @Column(name = "value_hum")
    private float valuee_hum;

    @Column(name = "tmsp_crea")
    private Timestamp tmspCrea;
 // ---------------------------------------------------------------------

    public Sensor_h11() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_temp() {
        return name_temp;
    }

    public void setName_temp(String name_temp) {
        this.name_temp = name_temp;
    }

    public String getName_hum() {
        return name_hum;
    }

    public void setName_hum(String name_hum) {
        this.name_hum = name_hum;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public float getValuee_temp() {
        return valuee_temp;
    }

    public void setValuee_temp(float valuee_temp) {
        this.valuee_temp = valuee_temp;
    }

    public float getValuee_hum() {
        return valuee_hum;
    }

    public void setValuee_hum(float valuee_hum) {
        this.valuee_hum = valuee_hum;
    }

    public Timestamp getTmspCrea() {
        return tmspCrea;
    }

    public void setTmspCrea(Timestamp tmspCrea) {
        this.tmspCrea = tmspCrea;
    }
}
