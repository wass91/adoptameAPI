package com.adoptame.services;

public interface ServiceDirectory {
	
	//Specie
	public static final String SPECIE_GET_ALL = "/species";
	public static final String SPECIE_GET_BY_ID = "/species/getById";
	public static final String SPECIE_CREATE = "/species/create";
	public static final String SPECIE_UPDATE = "/species/update";
	
	//Vaccine
	public static final String VACCINE_GET_ALL = "/vaccines";
	public static final String VACCINE_GET_BY_ID = "/vaccines/getById";
	public static final String VACCINE_CREATE = "/vaccines/create";
	public static final String VACCINE_UPDATE = "/vaccines/update";
	
	//Breed
	public static final String BREED_GET_ALL = "/breed";
	public static final String BREED_GET_BY_ID = "/breed/getById";
	public static final String BREED_CREATE = "/breed/create";
	public static final String BREED_UPDATE = "/breed/update";
	public static final String BREED_GET_BY_SPECIE = "/breed/getBySpecie";
	
	//Pet
	public static final String PET_GET_ALL = "/pet";
	public static final String PET_GET_BY_ID = "/pet/getById";
	public static final String PET_CREATE = "/pet/create";
	public static final String PET_UPDATE = "/pet/update";
	public static final String PET_GET_BY_SPECIE = "/pet/getBySpecie";
	public static final String PET_GET_BY_BREED = "/pet/getByBreed";
	public static final String PET_ADD_VACCINE = "/pet/addVaccine";
	public static final String PET_REMOVE_VACCINE = "/pet/removeVaccine";
	public static final String PET_LIST_VACCINE = "/pet/listVaccine";
	
	//Post
	public static final String POST_GET_ALL = "/post";
	public static final String POST_GET_ACTIVE = "/post/getActive";
	public static final String POST_ACTIVATE = "/post/activate";
	public static final String POST_GET_BY_ID = "/post/getById";
	public static final String POST_CREATE = "/post/create";
	public static final String POST_UPDATE = "/post/update";
	public static final String POST_GET_BY_PET = "/post/getByPet";
	public static final String POST_GET_BY_SPECIE = "/post/getBySpecie";
	public static final String POST_GET_BY_BREED = "/post/getByBreed";
	public static final String POST_GET_BY_USER = "/post/getByUser";
	public static final String POST_ADD_VISIT = "/post/addVisit";
	
	//Adoption
	public static final String ADOPTION_GET_ALL = "/adoption";
	public static final String ADOPTION_GET_ACTIVE = "/adoption/getActive";
	public static final String ADOPTION_GET_BY_ID = "/adoption/getById";
	public static final String ADOPTION_CREATE = "/adoption/create";
	public static final String ADOPTION_UPDATE = "/adoption/update";
	public static final String ADOPTION_GET_BY_PET = "/adoption/getByPet";
	public static final String ADOPTION_GET_BY_SPECIE = "/adoption/getBySpecie";
	public static final String ADOPTION_GET_BY_BREED = "/adoption/getByBreed";
	public static final String ADOPTION_GET_BY_USER = "/adoption/getByUser";
	public static final String ADOPTION_GET_PET_ID = "/adoption/getPetId";
	
	
}
