package com.adoptame.services.controller; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adoptame.services.BaseController;
import com.adoptame.services.PetService;
import com.adoptame.services.ServiceDirectory;
import com.adoptame.services.entities.Pet;
import com.adoptame.services.json.Response;

@RestController
public class PetController extends BaseController{
	
	@Autowired
	private PetService petService;
	
	@RequestMapping(value = ServiceDirectory.PET_GET_ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getAll(@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Pet> pets = null;
		try {
			pets = petService.getAll(--page, limit);
			response = this.createResponse(pets.getContent());
			Long total = pets.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.PET_CREATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response create(@RequestParam String birthdate, @RequestParam String image,@RequestParam boolean sterilized,
			@RequestParam Integer breedId, @RequestParam Integer specieId){
		Response response = null;
		Pet pet = null;
		try {
			pet = petService.create(formatter.parse(birthdate), image, sterilized, breedId, specieId);
			response = this.createResponse(pet);
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.PET_UPDATE, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response update(@RequestParam Integer petId, @RequestParam String birthdate, @RequestParam String image,@RequestParam boolean sterilized,
			@RequestParam Integer breedId, @RequestParam Integer specieId){
		Response response = null;
		Pet pet = null;
		try {
			pet = petService.update(petId, formatter.parse(birthdate), image, sterilized, breedId, specieId);
			response = this.createResponse(pet);
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.PET_GET_BY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getById(@RequestParam Integer id){
		Response response = null;
		try {
			response = createResponse(petService.getById(id));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.PET_GET_BY_SPECIE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getBySpecie(@RequestParam Integer specieId,@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Pet> pets = null;
		try {
			pets = petService.getBySpecie(specieId, --page, limit);
			response = this.createResponse(pets.getContent());
			Long total = pets.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.PET_GET_BY_BREED, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getByBreed(@RequestParam Integer breedId,@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Pet> pets = null;
		try {
			pets = petService.getByBreed(breedId, --page, limit);
			response = this.createResponse(pets.getContent());
			Long total = pets.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.PET_ADD_VACCINE, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getAddVaccine(@RequestParam Integer petId, @RequestParam Integer vaccineId){
		Response response = null;
		try {
			response = createResponse(petService.addVaccine(petId, vaccineId));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.PET_REMOVE_VACCINE, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getRemoveVaccine(@RequestParam Integer petId, @RequestParam Integer vaccineId){
		Response response = null;
		try {
			response = createResponse(petService.removeVaccine(petId, vaccineId));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.PET_LIST_VACCINE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getVaccinesByPet(@RequestParam Integer petId){
		Response response = null;
		try {
			response = createResponse(petService.listVaccines(petId));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
}
