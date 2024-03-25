package nl.workingtalent.backend.rest;

import java.io.IOException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(maxAge = 3600)
public class FotoController {
	@Autowired
	private FotoService fotoService;
	
	@RequestMapping("/foto")
	public Iterable<Foto> findAll(){
		return fotoService.getAll();
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value="foto/create")
	public Foto create(@RequestPart("data") MultipartFile file)throws IOException{
		System.out.println("abc");
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getContentType());
		System.out.println(file.getBytes());
		return fotoService.save(file.getOriginalFilename(),file.getContentType(), file.getBytes());

	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="foto/{id}/delete")
	public void delete(@PathVariable("id") long id){
		fotoService.delete(id);
		
	}
	
	@RequestMapping("/foto/{id}")
	public ResponseEntity<byte[]> getFoto(@PathVariable("id") long id){
			Foto foto = fotoService.findById(id);
			if (foto == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			byte[] data = foto.getData();
	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf(foto.getContentType()));
		ContentDisposition build = ContentDisposition.builder("inline")
				.filename(foto.getFileName())
				.build();
				headers.setContentDisposition(build);
		return new ResponseEntity<>(data,headers,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="foto/{id}/update")
	public void update(@PathVariable("id") long id, @RequestPart("data") MultipartFile updatedFoto) {
		
		Foto dbFoto = fotoService.findById(id);
		if (dbFoto == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		dbFoto.setFileName(updatedFoto.getOriginalFilename());
	    dbFoto.setContentType(updatedFoto.getContentType());
	    try {
			dbFoto.setData(updatedFoto.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    fotoService.update(dbFoto);
	
	}
	

	

}
