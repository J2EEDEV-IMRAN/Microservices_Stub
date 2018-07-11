package com.example.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SslClientController {
	private static final String SERVICE_URI="https://localhost:8084/";
	private static final String PASSWORD="123456";
	private static final String CERT_PATH="C:/Users/USER/git/Microservices_Stub/springboot/src/main/resources/server.jks";
    
	@RequestMapping(value="/getData",method=RequestMethod.GET)
	public String demo() throws Exception
	{
		RestTemplate restTemplate=new RestTemplate();
		RequestEntity<Object> requestEntity=null;
		ResponseEntity<String> responseEntity=restTemplate.exchange(SERVICE_URI, HttpMethod.GET, requestEntity, String.class);
		
		return responseEntity.getHeaders()+"::"+responseEntity.getBody()+"::"+responseEntity.getStatusCode();
		
/*		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers); 
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);*/
}
	public RestTemplate getRestTemplate()throws NoSuchAlgorithmException, CertificateException, IOException,
	KeyManagementException, KeyStoreException
	{
		RestTemplate restTemplate=new RestTemplate();
		try {
			/*ApplicationContext appContext = null; 
			Resource fin = 
			           (Resource) appContext.getResource(CERT_PATH);
			 InputStream is = ((InputStreamSource) fin).getInputStream();*/
			FileInputStream fin = new FileInputStream(CERT_PATH);
			KeyStore keyStore=KeyStore.getInstance("jsk");
			keyStore.load(fin, PASSWORD.toCharArray());
			SSLContext sslContext=SSLContexts.custom().loadTrustMaterial((TrustStrategy) keyStore).loadKeyMaterial(keyStore,PASSWORD.toCharArray()).build();
			HttpClient httpClient=HttpClients.custom().setHostnameVerifier(SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER).setSSLContext(sslContext).build();
			restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
		} catch (UnrecoverableKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return restTemplate;
	}
	
	
}