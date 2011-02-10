package com.foo.download;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.wicket.Resource;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.WebResource;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.target.resource.ResourceStreamRequestTarget;
import org.apache.wicket.util.file.File;
import org.apache.wicket.util.resource.AbstractResourceStream;
import org.apache.wicket.util.resource.FileResourceStream;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.ResourceStreamNotFoundException;
import org.apache.wicket.util.resource.StringResourceStream;

public class PhotoListingPage extends WebPage {

	public PhotoListingPage() {
		final IResourceStream fileStream = new FileResourceStream(new File(
				"/home/geraldo/foobar.jpg"));

		final IResourceStream stream = new AbstractResourceStream() {

			private static final long serialVersionUID = 1L;
			InputStream in;

			@Override
			public InputStream getInputStream()
					throws ResourceStreamNotFoundException {
				try {
					in = new FileInputStream("/home/geraldo/foobar.jpg");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				return in;
			}

			@Override
			public void close() throws IOException {
				in.close();
			}

			@Override
			public String getContentType() {
				return "image/jpg";
			}
		};
		final Resource resource = new WebResource() {

			private static final long serialVersionUID = 1L;

			@Override
			public IResourceStream getResourceStream() {

				return fileStream;
			}
		};
		ResourceReference ref = new ResourceReference("foobar") {
			private static final long serialVersionUID = 1L;

			@Override
			protected Resource newResource() {
				return resource;
			}
		};
		add(new Image("photo", ref));
		add(new Link<Void>("download1") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				IResourceStream stream = new StringResourceStream(
						"\u1111\u2222\u3333\u4444", "image/jpg");
				getRequestCycle().setRequestTarget(
						new ResourceStreamRequestTarget(stream)
								.setFileName("foo.png"));

			}
		});

		add(new Link<Void>("download2") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				getRequestCycle().setRequestTarget(
						new ResourceStreamRequestTarget(stream)
								.setFileName("foo.png"));

			}

		});

		add(new Link<Void>("download3") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				getRequestCycle().setRequestTarget(
						new ResourceStreamRequestTarget(fileStream)
								.setFileName("foo.png"));

			}

		});
	}

}
