package br.com.qwerty.cliente;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientDelete {

	public static void main(String[] args) {
		try {

			Client client = Client.create();

			WebResource webResource = client.resource("http://localhost:8080/barpp/hello/remover/21");

			ClientResponse response = webResource.accept("application/json").delete(ClientResponse.class);

			String retorno = response.getEntity(String.class);

			System.out.println("Resposta do serviço .... \n");
			System.out.println(retorno);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}