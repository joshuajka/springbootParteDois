package br.ufg.inf.fs.ctrl;

import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.fs.Messages;
import br.ufg.inf.fs.business.HospedeBusiness;
import br.ufg.inf.fs.entities.Hospede;
import br.ufg.inf.fs.exceptions.HospedeException;

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
@RequestMapping(value = "hospede")
public class HospedeCtrl {

    @Autowired
    HospedeBusiness business;

    @GetMapping
	public ResponseEntity<List<Hospede>> findAll(){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		List<Hospede> list = new ArrayList<Hospede>();
		try {
			list = business.findAll();
			if(list.size() == 0) {
				headers.add("message", Messages.get("0107"));
			}
		}catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Messages.get("0002"));
		}
		return new ResponseEntity<List<Hospede>>(list, headers, status);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hospede> findById(@PathVariable Integer id){
		Hospede retorno = new Hospede();
		
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
		return new ResponseEntity<Hospede>(retorno, headers, status);
	}
	
	
	@PostMapping
	public ResponseEntity<Hospede> insert(@RequestBody Hospede hotel){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.CREATED;
		
		try {
			hotel = business.insert(hotel);
			headers.add("message", Messages.get("0101"));
		} catch (HospedeException e) {
			headers.add("message", Messages.get(e.getMessage()));
			status = HttpStatus.BAD_REQUEST;
		} catch (Exception e) {
			headers.add("message", Messages.get("0102"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Hospede>(hotel, headers, status);
	}
	
	@PutMapping
	public ResponseEntity<Hospede> update(@RequestBody Hospede hotel){
		
		
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		
		try {
			hotel = business.update(hotel);
			headers.add("message", Messages.get("0103"));
		} catch (HospedeException e) {
			headers.add("message", Messages.get(e.getMessage()));
			status = HttpStatus.BAD_REQUEST;
		} catch (Exception e) {
			headers.add("message", Messages.get("0104"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Hospede>(hotel, headers, status);
		
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
	
	@GetMapping("/name/{str}")
	public ResponseEntity<List<Hospede>> findByName(@PathVariable String str){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		List<Hospede> list = new ArrayList<Hospede>();
		try {
			list = business.findNomeHospede(str);
			if(list.size() == 0) {
				headers.add("message", Messages.get("0107"));
			}
		}catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Messages.get("0002"));
		}
		return new ResponseEntity<List<Hospede>>(list, headers, status);

	}
	

}