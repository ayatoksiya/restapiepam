package org.example;


import io.restassured.response.Response;
import org.example.entities.Pet;
import org.example.steps.PetStoreSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Random;

public class PetTests {

    @Test
    public void addPetToStore() {
        Pet expectedPet = createPet();
        Pet createdPet = PetStoreSteps.createNewPet(expectedPet);
        Assert.assertEquals(createdPet.getName(), expectedPet.getName(), "Expected pet doesn't have correct name");
    }
    @Test
    public void getPetById() {
        Pet expectedPet = createPet();
        PetStoreSteps.createNewPet(expectedPet);
        Pet createdPet = PetStoreSteps.getPetById(expectedPet.getId());
        Assert.assertEquals(createdPet.getId(), expectedPet.getId(), "Expected pet doesn't have correct ID");
    }

    @Test
    public void deletePet() {
        Pet createdPet = PetStoreSteps.createNewPet(createPet());
        PetStoreSteps.deletePetById(createdPet.getId());
        Pet getPetById = PetStoreSteps.getDeletedPetById(createdPet.getId());
        Assert.assertFalse(getPetById.getId() == createdPet.getId(), "Pet not deleted!");
    }

    private Pet createPet() {
        Random random = new Random();
        HashMap category = new HashMap();
        category.put("id", random.nextInt(20));
        category.put("name", "dog");

        return new Pet()
                .setName("Szi" + random.nextInt(20))
                .setId(random.nextInt(20))
                .setCategory(category)
                .setPhotoUrls(null)
                .setStatus("available");
    }
}
