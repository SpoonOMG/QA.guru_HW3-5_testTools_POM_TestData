package testdata;

import com.github.javafaker.Faker;
import testdata.listsofexamples.Subject;

import java.util.Random;

public class TestData {

    Faker faker = new Faker();

    public String firstName = faker.name().firstName(); // Emory
    public String lastName = faker.name().lastName(); // Barton
    public String email = faker.internet().emailAddress();
    public String mobile = faker.phoneNumber().subscriberNumber(10);
    public String address = faker.address().fullAddress();
    public  String subject = subjectRandomizer();

    public String hobbies =hobbiesRandomizer();


    public String state = "Haryana";
    public String city = "Karnal";

    public String monthRandom = monthRandomizer();
    public String dayRandom = dayRandomizer();
    public String yearRandom = yearRandomizer();
    public String selectedDate = dayRandom + " "+monthRandom+","+yearRandom;
    public String gender = genderRandomizer();
    public String pictureSrc = "src/test/resources/mario03.png";
    public String pictureName = "mario03.png";



    // Кастомные рандомизаторы тестовых данных
    public static String subjectRandomizer(){
        Subject[] subject = Subject.values();

        int index = randomizerInt(0, subject.length-1);
        String selectedSubject = String.valueOf(subject[index]);
        return selectedSubject;
    }

    public static String genderRandomizer(){
        String[] gender = {"Male", "Female", "Other"};
        int index = randomizerInt(0, gender.length-1);
        return gender[index];
    }

    public static String hobbiesRandomizer(){
        String[] hobbies = {"Sports", "Reading", "Music"};
        int index = randomizerInt(0, hobbies.length-1);
        return hobbies[index];
    }

    public static int randomizerInt(int min, int max){
        Random rand = new Random();
        return rand.nextInt((max-min)+1)+min;
    }

    public static String monthRandomizer(){
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int index = randomizerInt(0, month.length-1);
        return month[index];
    }

    public static String dayRandomizer(){
        int day = randomizerInt(1,28);
        for (int i=1; i<=9; i++){
            if (day==i){
                String dayStr="0"+day;
                return dayStr;
            }
        }
        return day+"";
    }

    public static String yearRandomizer(){
        int year = randomizerInt(1920,2010);
        return year+"";
    }

}







