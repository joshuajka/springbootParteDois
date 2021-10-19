package br.ufg.inf.fs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.entities.Hospede;
import br.ufg.inf.fs.entities.Hotel;
import br.ufg.inf.fs.entities.Quarto;
import br.ufg.inf.fs.enums.CategoriaQuarto;
import br.ufg.inf.fs.repositories.HospedagemRepository;
import br.ufg.inf.fs.repositories.HospedeRepository;
import br.ufg.inf.fs.repositories.HotelRepository;
import br.ufg.inf.fs.repositories.QuartoRepository;

@Configuration
@Profile("dev")
public class Config  implements CommandLineRunner{

	@Autowired
	private HotelRepository hoteRepository;
	
	@Autowired
	private QuartoRepository quartoRepository;
	
	@Autowired
	private HospedeRepository hospedeRepository;
	
	@Autowired
	private HospedagemRepository hospedagemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String[] tipoH = new String[]{"Hotel", "Pousada", "Resort", "Hostel", "Pensão"};
		String[] nomeH = new String[]{"dos Pássados", "das Emas", "dos Imigrantes", "da Alegria", "da Cidade"};
		String[] localH = new String[]{"Goiânia","Anápolis","Brasília","Trindade", "Senador Canedo"};
		
		for(int i = 0; i <10; i++) {
			hoteRepository.save(new Hotel(
					null,
					tipoH[new Random().nextInt(5)]+" "+nomeH[new Random().nextInt(5)],
					localH[new Random().nextInt(5)],
					new Random().nextInt(5)+1
					));
		}
		/*
		 * INSERIR NO MEU BANCO DE DADOS INFORMAÇÕES INICIAIS...
		 * 
		 * */
		String dataRecebida = "23/11/2000";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date checkin = formato.parse(dataRecebida);
		Date checkout = formato.parse(dataRecebida);
		
		
		Hospede ho1 = new Hospede(null,"Joao da Cunha",dataRecebida,111515651);
		ho1 = hospedeRepository.save(ho1);
		Hospede ho2 = new Hospede(null,"Joao da Cunha",dataRecebida,111515651);
		ho2 = hospedeRepository.save(ho2);
		Hospede ho3 = new Hospede(null,"Joao da Cunha",dataRecebida,111515651);
		ho3 = hospedeRepository.save(ho3);
		Hospede ho4 = new Hospede(null,"Joao da Cunha",dataRecebida,111515651);
		ho4 = hospedeRepository.save(ho4);
		
		
		Hotel h1 = new Hotel(null, "Calderão Furado", "Beco Diagonal", 3);
		Hotel h2 = new Hotel(null, "Bates Hotel", "White Pine Bay", 2);
		Hotel h3 = new Hotel(null, "Hotel Overlook", "Colorado", 4);
		Hotel h4 = new Hotel(null, "Continental Hotel", "Ney York City", 5); 
		
		Hospedagem hh1 = new Hospedagem(null,1,1,"12/11/2021","15/11/2021"); 
		hh1 = hospedagemRepository.save(hh1);
		
		h1 = hoteRepository.save(h1);
		h2 = hoteRepository.save(h2);
		h3 = hoteRepository.save(h3);
		h4 = hoteRepository.save(h4);
		
		Quarto q1 = quartoRepository.save(new Quarto(null, h1, CategoriaQuarto.APARTAMENTO, 4, 1010, 200.0));
		Quarto q2 = quartoRepository.save(new Quarto(null, h2, CategoriaQuarto.SIMPLES, 1, 7, 100.0));
		Quarto q3 = quartoRepository.save(new Quarto(null, h3, CategoriaQuarto.PADRAO, 2, 306, 150.0));
		Quarto q4 = quartoRepository.save(new Quarto(null, h4, CategoriaQuarto.LUXO, 3, 1313, 500.0));
	}

}
