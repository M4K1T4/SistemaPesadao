package br.com.senai.email;

import com.guilhermechapiewski.fluentmail.email.EmailMessage;
import com.guilhermechapiewski.fluentmail.transport.EmailTransportConfiguration;

public class GeradorEmail {

	public static void main(String[] args) {
		// put your e-mail address here
		final String yourAddress = "noreply.pesadao@gmail.com";

		// configure programatically your mail server info
		EmailTransportConfiguration.configure("smtp.gmail.com", true,
				false, "noreply.pesadao@gmail.com", "oitocaracteres");

		// and go!
		
		new EmailMessage().from("noreply.pesadao@gmail.com").to(yourAddress)
				.withSubject("Nota Fiscal - Sistema Pesadão")
				.withAttachment("file_name")
				.withBody("<html><head><style>div{text-color: red;}</style></head><body><div>PEDOU FDP</div></body></html>").send();

		System.out.println("Check your inbox!");

	}
}
