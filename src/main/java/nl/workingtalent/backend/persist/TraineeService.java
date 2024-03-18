package nl.workingtalent.backend.persist;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import nl.workingtalent.backend.model.Foto;
import nl.workingtalent.backend.model.TalentManager;
import nl.workingtalent.backend.model.Trainee;

@Service
public class TraineeService {
	@Autowired
	private ITraineeRepository repo;
	
	@Autowired
    private ITalentManagerRepository talentManagerRepository;
	
	@Autowired
    private IFotoRepository fotoRepo;

	public Iterable<Trainee> vindAlleTrainees() {
		//raadplegen van de database!
		return repo.findAll();

	}

	public Optional<Trainee> findById(long id) {
		// security, Permissies
		return repo.findById(id);
	}

	public Trainee create(Trainee newTrainee) {
		return repo.save(newTrainee);
	}

	public void update(Trainee trainee) {
		repo.save(trainee);
	}

	public void delete(long id) {
		repo.deleteById(id);
	}

	public List<Trainee> getAlltraineesByTalentManagerId(long talentManagerId) {
		// TODO Auto-generated method stub
		 TalentManager talentManager = talentManagerRepository.findById(talentManagerId)
	                .orElse(null);

	        if (talentManager == null) {
	            System.out.println("TalentManager with ID " + talentManagerId + " does not exist.");
	            return Collections.emptyList();
	        }

	        List<Trainee> trainees = talentManager.getTrainee();
	        if (trainees.isEmpty()) {
	            System.out.println("TalentManager with ID " + talentManagerId + " has no trainees.");
	        }
		return repo.findAllTraineesByTalentManagerId(talentManagerId);
	}

	public Trainee createTraineeForTalentManager(long talentManagerId, long traineeId) {
		// TODO Auto-generated method stub
		
		Optional<TalentManager> optionalTalentManager = talentManagerRepository.findById(talentManagerId);
		
        if(optionalTalentManager.isPresent()) {
        	TalentManager dBTalentManager = optionalTalentManager.get();
        	
        	 if (dBTalentManager.getTrainee().isEmpty()) {
                 System.out.println("TalentManager with ID " + talentManagerId + " has no trainees.");
             } else {
               
                 for (Trainee trainee : dBTalentManager.getTrainee()) {
                     if (trainee.getId() == traineeId) {
                         System.out.println("TalentManager with ID " + talentManagerId + " already has Trainee with ID " + traineeId);
                         return null;
                     }
                 }
             }
        	  Optional<Trainee> optionalTrainee = repo.findById(traineeId);
              if(optionalTrainee.isPresent()) {
              	Trainee dbTrainee = optionalTrainee.get();
              	dbTrainee.setTalentManager(dBTalentManager);
              	return repo.save(dbTrainee);
              }else {
                  System.out.println("Trainee with ID " + traineeId + " does not exist.");
                  return null;
              }
        }else {
            System.out.println("TalentManager with ID " + talentManagerId + " does not exist.");
            return null;
        }   
      
	}

	public  ResponseEntity<byte[]>  getFotoByTraineeId(long traineeId) {
		// TODO Auto-generated method stub
		Optional<Trainee> optionalTrainee = repo.findById(traineeId);
		
		if(optionalTrainee.isPresent()) {
			Trainee dbTrainee = optionalTrainee.get();
			
			Foto foto = dbTrainee.getFoto();
			
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
		return null;
	}

	public Foto createTraineeFotoByTraineeId(long traineeId, MultipartFile file) {
		// TODO Auto-generated method stub
		Optional<Trainee> optionalTrainee = repo.findById(traineeId);
		
		if(optionalTrainee.isPresent()) {
			Trainee dBTrainee = optionalTrainee.get();
			
			Foto fotoTrainee = dBTrainee.getFoto();
			
			if (fotoTrainee == null) {
	                fotoTrainee = new Foto();
	                
	                fotoTrainee.setFileName(file.getOriginalFilename());
	                fotoTrainee.setContentType(file.getContentType());
	                try {
						fotoTrainee.setData(file.getBytes());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	               fotoRepo.save(fotoTrainee);
	               dBTrainee.setFoto(fotoTrainee);
	               
	               repo.save(dBTrainee);
	         
//	               fotoTrainee.setTrainee(dBTrainee);
	             
	               
	               return fotoTrainee;
	            }
				
		
		}
		return null;
		
	
	}


}