package org.example.steps;

import org.example.entities.Pet;
import org.example.petstore.PetService;

public class PetStoreSteps {

    private static final PetService PET_SERVICE = PetService.getInstance();

    public static Pet getPetById(int id) {
        String mode = "other";
        return PET_SERVICE.getRequest(id, mode).as(Pet.class);
    }

    public static Pet getDeletedPetById(int id) {
        String mode = "deleted";
        return PET_SERVICE.getRequest(id, mode).as(Pet.class);
    }
    public static Pet createNewPet(Object body) {
        return PET_SERVICE.postRequest("pet", body).as(Pet.class);
    }

    public static Pet updateExistingPet(Object body) {
        return PET_SERVICE.putRequest("pet", body).as(Pet.class);
    }

    public static void deletePetById(int id) {
        PET_SERVICE.deleteRequest(id);
    }
}
