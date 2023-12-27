package app.mailserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MailServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailServerApplication.class, args);
		// AttachmentModel x=new AttachmentModel("ha","ha","ha");
		// System.out.println(x);
		
		System.out.println("Domiaty");
	}

}
