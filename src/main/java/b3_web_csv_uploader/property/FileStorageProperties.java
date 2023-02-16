package b3_web_csv_uploader.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix="file")
@Getter
@Setter
public class FileStorageProperties {

	private String dir;
}
