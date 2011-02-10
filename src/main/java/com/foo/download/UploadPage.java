package com.foo.download;

import java.io.File;
import java.io.IOException;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;

public class UploadPage extends WebPage {
	private FileUploadField upload = null;

	public UploadPage() {
		Form<Void> f = new Form<Void>("f") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				FileUpload fileUpload = upload.getFileUpload();
				try {

					if (fileUpload == null) {
						return;
					}

					fileUpload.writeTo(new File("/tmp/101.png"));

					// OutputStream out = new FileOutputStream(
					// "/home/geraldo/foobar2.jpg");
					// // out.write(fileUpload.getBytes());
					// InputStream in = fileUpload.getInputStream();
					// for (;;) {
					// int aByte = in.read();
					// if (aByte == -1) {
					// break;
					// }
					// out.write(aByte);
					// }
					//
					// out.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		};
		add(f);
		upload = new FileUploadField("upload");
		f.add(upload);
	}

}
