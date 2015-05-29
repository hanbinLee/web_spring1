import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class test {
	public static void main(String[] args) {
		BasicConfigurator.configure(); 
		Logger logger = LoggerFactory.getLogger(test.class);
		
		logger.info("hello");
		logger.warn("warn");
	}
}
