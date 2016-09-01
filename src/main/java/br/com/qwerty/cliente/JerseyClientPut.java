package br.com.qwerty.cliente;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.qwerty.entidade.Usuario;

public class JerseyClientPut {

	public static void main(String[] args) {
		try {

			Client client = Client.create();

			WebResource webResource = client.resource("http://localhost:8080/barpp/hello/atualizar");

			Gson gson = new Gson();

			Usuario u = new Usuario();
			u.setId(3);
			u.setApelido("Fulano");
			u.setEmail("aaa@a.com");
			u.setNome("Ciclano");
			u.setSenha("123456");
			u.setSobrenome("Silva");
			u.setTipo("novo");

			String input = gson.toJson(u);

			ClientResponse response = webResource.type("application/json").put(ClientResponse.class, input);

			System.out.println("Resposta do serviço .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}