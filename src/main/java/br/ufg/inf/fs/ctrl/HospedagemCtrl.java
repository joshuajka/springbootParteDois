package br.ufg.inf.fs.ctrl;

import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.exceptions.HospedagemException;
import br.ufg.inf.fs.Messages;
import br.ufg.inf.fs.business.HospedagemBusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "hospedagem")
public class HospedagemCtrl {
    @Autowired
    HospedagemBusiness business;

    @GetMapping
	public ResponseEntity<List<Hospedagem>> findAll(){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		List<Hospedagem> list = new ArrayList<Hospedagem>();
		try {
			list = business.findAll();
			if(list.size() == 0) {
				headers.add("message", Messages.get("0107"));
			}
		}catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Messages.get("0002"));
		}
		return new ResponseEntity<List<Hospedagem>>(list, headers, status);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hospedagem> findById(@PathVariable Integer id){
		Hospedagem retorno = new Hospedagem();
		
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		try {
			retorno = business.findById(id);
			if(retorno == null) {
				headers.add("message", Messages.get("0107"));
			}
		}catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Messages.get("0002"));
		}
		return new ResponseEntity<Hospedagem>(retorno, headers, status);
	}
	
	
	@PostMapping
	public ResponseEntity<Hospedagem> insert(@RequestBody Hospedagem hotel){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.CREATED;
		
		try {
			hotel = business.insert(hotel);
			headers.add("message", Messages.get("0101"));
		} catch (HospedagemException e) {
			headers.add("message", Messages.get(e.getMessage()));
			status = HttpStatus.BAD_REQUEST;
		} catch (Exception e) {
			headers.add("message", Messages.get("0102"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Hospedagem>(hotel, headers, status);
	}
	
	@PutMapping
	public ResponseEntity<Hospedagem> update(@RequestBody Hospedagem hotel){
		
		
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		
		try {
			hotel = business.update(hotel);
			headers.add("message", Messages.get("0103"));
		} catch (HospedagemException e) {
			headers.add("message", Messages.get(e.getMessage()));
			status = HttpStatus.BAD_REQUEST;
		} catch (Exception e) {
			headers.add("message", Messages.get("0104"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Hospedagem>(hotel, headers, status);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.NO_CONTENT;
		
		try {
			business.delete(id);
		} catch (Exception e) {
			headers.add("message", Messages.get("0106"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Void>(headers, status);
	}
	
	@GetMapping("/hospedagem/{id}")
	public ResponseEntity<List<Hospedagem>> findIdDeHospedagem(@PathVariable Integer qtd){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		List<Hospedagem> list = new ArrayList<Hospedagem>();
		try {
			list = business.findIdHospedagem(qtd);
			if(list.size() == 0) {
				headers.add("message", Messages.get("0107"));
			}
		}catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Messages.get("0002"));
		}
		return new ResponseEntity<List<Hospedagem>>(list, headers, status);

		
	}

}