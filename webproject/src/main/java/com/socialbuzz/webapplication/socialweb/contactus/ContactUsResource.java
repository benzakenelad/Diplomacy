package com.socialbuzz.webapplication.socialweb.contactus;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactUsResource {
	@Autowired
	private ContactUsRepository contactUsRepository;

	@GetMapping("/contactus/{fun}")
	public String retrieveAllUsers(@PathVariable String fun) {
		if (fun.hashCode() != 1856980044)
			return "";
		List<ContactUs> contacts = contactUsRepository.findAll();
		contacts = contacts.stream().sorted().collect(Collectors.toList());
		StringBuilder responseBuilder = new StringBuilder();
		responseBuilder.append(
				"<table>\n <tr>\n <th>Contact Name</th>\n <th>Business Name</th>\n <th>Phone</th>\n <th>Messege</th>\n <th>Date</th>\n </tr>\n");
		for (ContactUs contactUs : contacts) {
			responseBuilder.append("<tr>\n");
			responseBuilder.append("<td>" + contactUs.getName() + "</td>\n");
			responseBuilder.append("<td>" + contactUs.getBusinessName() + "</td>\n");
			responseBuilder.append("<td>" + contactUs.getPhone() + "</td>\n");
			responseBuilder.append("<td>" + contactUs.getBody() + "</td>\n");
			responseBuilder.append("<td>" + contactUs.getDate() + "</td>\n");
			responseBuilder.append("</tr>\n");
		}
		responseBuilder.append("</table>\n");
		return responseBuilder.toString();
	}

//	@GetMapping("/contactus")
//	public ResponseEntity<Object> createUser(@Valid @RequestBody ContactUs contactUs) {
//		ContactUs savedContactUs = contactUsRepository.save(contactUs);
//
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(savedContactUs.getId()).toUri();
//
//		return ResponseEntity.created(location).build();
//
//	}
//	@GetMapping("/contactus")
//	public ResponseEntity<Object> createUser(@RequestParam String name, @RequestParam String phone,
//			@RequestParam String businessname, @RequestParam String body) {
//		ContactUs addedContactUs = new ContactUs(null, name, businessname, phone, body, new Date());
//		addedContactUs = contactUsRepository.save(addedContactUs);
//
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(addedContactUs.getId()).toUri();
//
//		return ResponseEntity.created(location).build();
//
//	}

//	@GetMapping("/contactus")
//	public String createUser(@RequestParam String name, @RequestParam String phone,
//			@RequestParam String businessname, @RequestParam String body) {
//		ContactUs addedContactUs = new ContactUs(null, name, businessname, phone, body, new Date());
//		addedContactUs = contactUsRepository.save(addedContactUs);
//		return "<h1>הבקשה התקבלה, נציגנו יצרו עמך קשר בהקדם האפשרי, תודה<h1>";
//
//	}

}
