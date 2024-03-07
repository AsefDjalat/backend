package nl.workingtalent.backend.rest;

import java.io.IOException;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import nl.workingtalent.backend.model.Foto;
import nl.workingtalent.backend.persist.FotoService;

@RestController
public class FotoController {
	@Autowired
	private FotoService fotoService;
	
	@RequestMapping("/foto")
	public Iterable<Foto> findAll(){
		return fotoService.getAll();
	}
	
	@RequestMapping("/foto/{id}")
	public Foto get(@PathVariable("id") long id){
		Foto foto = fotoService.findById(id);
		if (foto == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return foto;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="foto/{id}/delete")
	public void delete(@PathVariable("id") long id){
		fotoService.delete(id);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="foto/create")
	public Foto create(@RequestPart("data") MultipartFile file)throws IOException{
		return fotoService.save(file.getOriginalFilename(),file.getContentType(), file.getBytes());
	
	}
	

	

}
