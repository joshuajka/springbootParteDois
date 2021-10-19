package br.ufg.inf.fs.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tb_hospede")
public class Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hospede")
    private Integer idHospede;

    @Column(name = "nm_hospede")
    private String nmHospede;

    @Column(name = "dt_nasimento")
    private String dtNascimento;

    @Column(name = "cpf")
    private Integer cpf;

    public Hospede() {
        super();
    }

    public Hospede(Integer idHospede, String nmHospede, String checkin, Integer cpf) {
        super();
        this.idHospede = idHospede;
        this.nmHospede = nmHospede;
        this.dtNascimento = checkin;
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

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
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
        return "Hospede{" +
                "idHospede=" + idHospede +
                ", nmHospede='" + nmHospede + '\'' +
                ", dtNascimento=" + dtNascimento +
                ", cpf=" + cpf +
                '}';
    }
    
}