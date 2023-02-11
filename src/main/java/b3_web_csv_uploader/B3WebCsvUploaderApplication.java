package b3_web_csv_uploader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import b3_web_csv_uploader.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class B3WebCsvUploaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(B3WebCsvUploaderApplication.class, args);
	}

}
