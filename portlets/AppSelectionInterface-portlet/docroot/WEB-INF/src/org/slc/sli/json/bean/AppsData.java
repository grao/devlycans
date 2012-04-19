package org.slc.sli.json.bean;

import java.io.Serializable;
import java.util.List;

public class AppsData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private String name;
		private String description;
		private String behaviour;
		private String image_url;
		private String application_url;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getBehaviour() {
			return behaviour;
		}

		public void setBehaviour(String behaviour) {
			this.behaviour = behaviour;
		}

		public String getImage_url() {
			return image_url;
		}

		public void setImage_url(String image_url) {
			this.image_url = image_url;
		}

		public String getApplication_url() {
			return application_url;
		}

		public void setApplication_url(String application_url) {
			this.application_url = application_url;
		}

	}
