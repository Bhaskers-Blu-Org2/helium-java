package com.microsoft.azure.helium;

import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.credentials.AppServiceMSICredentials;
import com.microsoft.azure.helium.app.actor.ActorsController;
import com.microsoft.azure.helium.app.movie.MoviesController;
import com.microsoft.azure.helium.app.movie.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Properties;

@EnableSwagger2
@SpringBootApplication
public class Application implements CommandLineRunner {


	@Value("${azure.keyvault.uri}")
	private String keyUri;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... varl) throws Exception {
		System.out.println("keyUri: " + keyUri);

		/*String kvName = getKeyVaultUrl(keyUri);
		Properties properties = new Properties();
		properties.setProperty("azure.keyvault.uri", kvName);
		System.out.println("updated keyUri: " + properties.getProperty("azure.keyvault.uri"));*/
	}
	public static String getKeyVaultUrl(String keyUri)
	{
		String kvName = "";
		// command line arg overrides environment variable
		if (keyUri.length() > 0 && ! keyUri.startsWith("-")){
			kvName = keyUri.trim();
		}
		// build the URL
		if (!kvName.isEmpty() && ! kvName.startsWith("https://")){
			return "https://" + kvName + ".vault.azure.net/";
		}
		return kvName;
	}

}
