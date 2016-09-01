package br.com.qwerty.cliente;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.qwerty.entidade.Usuario;

public class JerseyClientGet {

	public static void main(String[] args) {
		try {

			Client client = Client.create();

			WebResource webResource = client.resource("http://localhost:8080/barpp/hello/buscar/10");

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			Usuario usuario = response.getEntity(Usuario.class);

			System.out.println("Resposta do serviço .... \n");
			System.out.println("ID: "+usuario.getId());
			System.out.println("Nome: "+usuario.getNome());
			System.out.println("Sobrenome: "+usuario.getSobrenome());
			System.out.println("Apelido: "+usuario.getApelido());
			System.out.println("E-mail: "+usuario.getEmail());
			System.out.println("Tipo: "+usuario.getTipo());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}