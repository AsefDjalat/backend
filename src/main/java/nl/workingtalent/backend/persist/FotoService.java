package nl.workingtalent.backend.persist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalent.backend.model.Foto;

@Service
public class FotoService {
	@Autowired
	private IFotoRepository repo;
	
	public Iterable<Foto> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Foto findById(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	public Foto save(String fileName,String contentType, byte[] data) {
		// TODO Auto-generated method stub
		Foto foto = new Foto();
		foto.setContentType(contentType);
		//foto.setId(1);
		foto.setFileName(fileName);
		foto.setData(data);
		//fotoService.save(foto.getId(), newFoto);
		
		repo.save(foto);
		return foto;
	}

	public void update(Foto newFoto) {
		// TODO Auto-generated method stub
		repo.save(newFoto);
	}

}
