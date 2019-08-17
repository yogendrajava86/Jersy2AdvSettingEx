package org.mausaminfotech.app.config;

import javax.ws.rs.ApplicationPath;

import org.eclipse.persistence.jaxb.BeanValidationMode;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.moxy.xml.MoxyXmlFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import io.swagger.jaxrs.config.BeanConfig;
@ApplicationPath("/rest")
public class AppConfig extends ResourceConfig {

	public AppConfig() {
		BeanConfig beanConfig = new BeanConfig();
	    beanConfig.setTitle("Swagger - Employee API");
	    beanConfig.setVersion("1.0.0");        
	    beanConfig.setSchemes(new String[] { "http" });
	    beanConfig.setHost("localhost:8085/Jersy2AdvSettingEx");
	    beanConfig.setContact("Yogendra Dixit");
	    beanConfig.setLicense("Apache 2.0");
	    beanConfig.setLicenseUrl("http://apache.org");
	    
	    //String inf="{ \"title\": \"Sample Pet Store App\", \"description\": \"This is a sample server for a pet store.\", \"termsOfService\": \"http://example.com/terms/\", \"contact\": { \"name\": \"API Support\", \"url\": \"http://www.example.com/support\", \"email\": \"support@example.com\" }, \"license\": { \"name\": \"Apache 2.0\", \"url\": \"https://www.apache.org/licenses/LICENSE-2.0.html\" }, \"version\": \"1.0.1\"}";
	   
	    
	    beanConfig.setBasePath("/rest");
	    beanConfig.setResourcePackage(
	            "org.mausaminfotech.app.rest");
	    beanConfig.setScan(true);        
	    property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, Boolean.TRUE);
		packages("org.mausaminfotech.app.rest");
		packages("io.swagger.jaxrs.listing");
	    register(MoxyJsonFeature.class);
	    // register(BadRequestExceptionMapper.class);
	    register(new MoxyJsonConfig().setFormattedOutput(true)
	    // Turn off BV otherwise the entities on server would be validated by MOXy as well.
	    .property(MarshallerProperties.BEAN_VALIDATION_MODE, BeanValidationMode.NONE).resolver());

	    register(MoxyXmlFeature.class);
	    register(RolesAllowedDynamicFeature.class);
	}
	
	
}
