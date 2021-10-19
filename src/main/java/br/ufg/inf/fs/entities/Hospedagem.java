package br.ufg.inf.fs.entities;

import java.util.Date;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_hospedagem")
public class Hospedagem implements Serializable {
    
	private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hospedagem")
    private Integer idHospedagem;

    @Column(name = "id_quarto")
    private Integer idQuarto;

    @Column(name = "id_hospede")
    private Integer idHospede;

    @Column(name = "dt_checkin")
    private String dtCheckin;

    @Column(name = "dt_checkout")
    private String dtCheckout;

    public Hospedagem() {
        super();
    }

    public Hospedagem(Integer idHospedagem, Integer idQuarto, Integer idHospede, String dtCheckin, String dtCheckout) {
        this.idHospedagem = idHospedagem;
        this.idQuarto = idQuarto;
        this.idHospede = idHospede;
        this.dtCheckin = dtCheckin;
        this.dtCheckout = dtCheckout;
    }

    public Integer getIdHospedagem() {
        return idHospedagem;
    }

    public void setIdHospedagem(Integer idHospedagem) {
        this.idHospedagem = idHospedagem;
    }

    public Integer getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Integer idQuarto) {
        this.idQuarto = idQuarto;
    }

    public Integer getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(Integer idHospede) {
        this.idHospede = idHospede;
    }

    public String getDtCheckin() {
        return dtCheckin;
    }

    public void setDtCheckin(String dtCheckin) {
        this.dtCheckin = dtCheckin;
    }

    public String getDtCheckout() {
        return dtCheckout;
    }

    public void setDtCheckout(String dtCheckout) {
        this.dtCheckout = dtCheckout;
    }

    @Override
    public String toString() {
        return "Hospedagem [dtCheckin=" + dtCheckin + ", dtCheckout=" + dtCheckout + ", idHospedagem=" + idHospedagem
                + ", idHospede=" + idHospede + ", idQuarto=" + idQuarto + "]";
    }

}