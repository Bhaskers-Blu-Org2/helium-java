package com.microsoft.azure.helium;

import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.credentials.AppServiceMSICredentials;
import com.microsoft.azure.credentials.MSICredentials;
import com.microsoft.azure.keyvault.KeyVaultClient;
import com.microsoft.azure.keyvault.models.SecretBundle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Value("${azure.cosmosdb.key}")
	private String cosmosDBkey;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... varl) throws Exception {
		System.out.println("property your-property-name value is: " + cosmosDBkey);

	/*	AppServiceMSICredentials credentials = new AppServiceMSICredentials(AzureEnvironment.AZURE);
		KeyVaultClient keyVaultClient = new KeyVaultClient(credentials);
		SecretBundle bundle = keyVaultClient.getSecret("https://demoheliumkeyvault.vault.azure.net/","azure-cosmosdb-key");
		System.out.println("Secret " + bundle.value());*/

	}
}
