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
@Table(name = "tb_hospede")
public class Hospede implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hospede")
    private Integer idHospede;

    @Column(name = "nm_hospede")
    private String nmHospede;

    @Column(name = "dt_nascimento")
    private Date dtNascimento;

    @Column(name = "cpf")
    private Integer cpf;

    public Hospede() {
        super();
    }

    public Hospede(Integer idHospede, String nmHospede, Date dtNascimento, Integer cpf) {
        super();
        this.idHospede = idHospede;
        this.nmHospede = nmHospede;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
    }

    public Integer getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(Integer idHospede) {
        this.idHospede = idHospede;
    }

    public String getNmHospede() {
        return nmHospede;
    }

    public void setNmHospede(String nmHospede) {
        this.nmHospede = nmHospede;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Hospede [cpf=" + cpf + ", dtNascimento=" + dtNascimento + ", idHospede=" + idHospede + ", nmHospede="
                + nmHospede + "]";
    }

}