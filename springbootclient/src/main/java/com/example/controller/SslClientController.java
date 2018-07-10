package com.example.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.ssl.SSLContexts;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

public class SslClientController {
	private static final String SERVICE_URI="https://localhost:8084/";
	private static final String PASSWORD="123456";
	private static final String CERT_PATH="C:/Users/USER/git/Microservices_Stub/springboot/src/main/resources/server.jks";
    
	@RequestMapping("/getData")
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
		FileInputStream fin = new FileInputStream(CERT_PATH);
		KeyStore keyStore=KeyStore.getInstance("jsk");
		keyStore.load(fin, PASSWORD.toCharArray());
		
		SSLContext sslContext=SSLContexts.custom().loadTrustMaterial(keyStore).loadKeyMaterial(keyStore,PASSWORD.toCharArray()).build();
		
		return restTemplate;
	}
	
	
}