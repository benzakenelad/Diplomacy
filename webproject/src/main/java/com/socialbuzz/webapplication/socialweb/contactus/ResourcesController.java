package com.socialbuzz.webapplication.socialweb.contactus;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResourcesController {
	@Autowired
	private ContactUsRepository contactUsRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public void getImage(HttpServletResponse response) throws IOException {

		ClassPathResource imgFile = new ClassPathResource("/static/index.html");

		response.setContentType(MediaType.TEXT_HTML_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	}

	@RequestMapping(value = "/contactus", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public void createUser(@RequestParam String name, @RequestParam String phone, @RequestParam String businessname,
			@RequestParam String body, HttpServletResponse response) throws IOException {
		ContactUs addedContactUs = new ContactUs(null, name.substring(0, min(name.length(), 256)),
				businessname.substring(0, min(businessname.length(), 256)),
				phone.substring(0, min(phone.length(), 256)), body.substring(0, min(body.length(), 256)), new Date());
		addedContactUs = contactUsRepository.save(addedContactUs);

		ClassPathResource imgFile = new ClassPathResource("/static/contactus.html");

		response.setContentType(MediaType.TEXT_HTML_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());

	}

	public static int min(int a, int b) {
		if (a < b)
			return a;
		else
			return b;
	}
}
