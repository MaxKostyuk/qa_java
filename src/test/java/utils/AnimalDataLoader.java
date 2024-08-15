package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnimalDataLoader {

    private static AnimalDataLoader instance;
    private final Map<String, Map<String, Object>> data;

    private AnimalDataLoader() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        data = mapper.readValue(new File("src/test/resources/animal-data.yml"), Map.class);
    }

    public static AnimalDataLoader getInstance() throws IOException {
        if (instance == null) {
            instance = new AnimalDataLoader();
        }
        return instance;
    }

    public String getAnimalType(String type) {
        Map<String, String> types = (Map<String, String>) data.get("animalData").get("types");
        return types.get(type);
    }

    public List<String> getFoodForType(String type) {
        Map<String, List<String>> food = (Map<String, List<String>>) data.get("animalData").get("food");
        return food.get(type);
    }

    public String getSoundForAnimal(String animal) {
        Map<String, String> sounds = (Map<String, String>) data.get("animalData").get("sounds");
        return sounds.get(animal);
    }

    public String getFamilyName(String animal) {
        Map<String, String> family = (Map<String, String>) data.get("animalData").get("family");
        return family.get(animal);
    }
}
