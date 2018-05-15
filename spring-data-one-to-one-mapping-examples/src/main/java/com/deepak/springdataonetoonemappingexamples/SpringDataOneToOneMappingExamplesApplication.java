package com.deepak.springdataonetoonemappingexamples;

import com.deepak.springdataonetoonemappingexamples.domain.Gender;
import com.deepak.springdataonetoonemappingexamples.domain.User;
import com.deepak.springdataonetoonemappingexamples.domain.UserProfile;
import com.deepak.springdataonetoonemappingexamples.repository.UserProfileRepository;
import com.deepak.springdataonetoonemappingexamples.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class SpringDataOneToOneMappingExamplesApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataOneToOneMappingExamplesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userProfileRepository.deleteAllInBatch();
		userRepository.deleteAllInBatch();

		User user = new User(145L, "Rajeev", "Singh", "rajeev@callicoder.com",
				"MY_SUPER_SECRET_PASSWORD");

		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.set(1992, 7, 21);

        UserProfile userProfile = new UserProfile(145L, "+91-8197882053", Gender.MALE, dateOfBirth.getTime(),
                "747", "2nd Cross", "Golf View Road, Kodihalli", "Bangalore",
                "Karnataka", "India", "560008");

	    user.setUserProfile(userProfile);

	    userProfile.setUser(user);

	    userRepository.save(user);

        System.out.println("Saved ");





	}
}
