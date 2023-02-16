package b3_web_csv_uploader.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UploadFileResponse {
	private String filename;
	private String filedownloadUri;
	private String filetype;
	private Long size;
}
