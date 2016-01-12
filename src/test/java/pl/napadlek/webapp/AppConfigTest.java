package pl.napadlek.webapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppConfigTest {

	@Autowired(required = true)
	private String message;
	
	@Autowired
	private Author author;

	@Test
	public void shouldGetBeanMessage() {
		Assert.assertNotNull(message);
		Assert.assertEquals("Hello world!", message);
	}
	
	@Test
	public void shouldGetPrimaryAuthor() {
		Assert.assertNotNull(author);
		Assert.assertEquals("Mark", author.getFirstName());
		Assert.assertEquals("Twain", author.getLastName());
	}
}
