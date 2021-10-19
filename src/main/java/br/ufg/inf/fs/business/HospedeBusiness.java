package br.ufg.inf.fs.business;

import br.ufg.inf.fs.repositories.HospedeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fs.entities.Hospede;
import br.ufg.inf.fs.exceptions.HospedeException;

import java.util.List;
import java.util.Optional;

@Service
public class HospedeBusiness {
    @Autowired
    HospedeRepository repository;

    public List<Hospede> findAll() {
        return this.repository.findAll();
    }

    public Hospede findById(Integer id) {
        Optional<Hospede> optHospede = this.repository.findById(id);
        Hospede hospede = optHospede.get();
        return hospede;
    }

    public Hospede insert(Hospede hospede) throws HospedeException {
    	this.validaHospede(hospede);
        return this.repository.save(hospede);
    }

    public Hospede update(Hospede hospede) throws HospedeException {
    	this.validaHospede(hospede);
        return this.repository.save(hospede);
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }
    
    public List<Hospede> findNomeHospede(String str){
		return repository.findByNomeHospede(str);
	}
    
    private void validaHospede(Hospede hospede) throws HospedeException {
    	if(hospede.getNmHospede() == null || hospede.getNmHospede().length() == 0) {
            throw new HospedeException("0208");
        }
        if(hospede.getCpf() == null) {
            throw new HospedeException("0209");
        }
        if(hospede.getDtNascimento() == null) {
            throw new HospedeException("0210");
        }
	}
}