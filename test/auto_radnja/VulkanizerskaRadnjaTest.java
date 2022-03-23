package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VulkanizerskaRadnjaTest extends RadnjaTest {

	@BeforeEach
	void setUp() throws Exception {
		vulkanizerskaRadnja = new VulkanizerskaRadnja();
	}

	@AfterEach
	void tearDown() throws Exception {
		vulkanizerskaRadnja = null;
	}


}
