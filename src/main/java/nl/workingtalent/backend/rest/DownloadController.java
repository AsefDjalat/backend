package nl.workingtalent.backend.rest;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalent.backend.model.Foto;
import nl.workingtalent.backend.persist.FotoService;


@RestController
public class DownloadController {
	@Autowired
	private  FotoService fotoService;
	@RequestMapping("/download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable("id") long id){
			Foto foto = fotoService.findById(id);
	
			byte[] data = foto.getData();
	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf(foto.getContentType()));
		ContentDisposition build = ContentDisposition.builder("attachment")
				.filename(foto.getFileName())
				.build();
				headers.setContentDisposition(build);
		return new ResponseEntity<>(data,headers,HttpStatus.OK);
	}
}
