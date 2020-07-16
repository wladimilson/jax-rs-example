package br.com.treinaweb.model;

import java.util.List;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;
import org.glassfish.jersey.linking.InjectLink.Style;
import org.glassfish.jersey.linking.Binding;

import br.com.treinaweb.adapters.LinkAdapter;
import br.com.treinaweb.resources.PessoaResource;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    

    @InjectLinks({
        @InjectLink(
            resource = PessoaResource.class,
            style = Style.ABSOLUTE,
            rel = "self",
            bindings = @Binding(name = "id", value = "${instance.id}"),
            method = "GET"
        ),
        @InjectLink(
                resource = PessoaResource.class,
                style = Style.ABSOLUTE,
                rel = "update",
                bindings = @Binding(name = "id", value = "${instance.id}"),
                method = "PUT"
        ),
        @InjectLink(
                resource = PessoaResource.class,
                style = Style.ABSOLUTE,
                rel = "delete",
                bindings = @Binding(name = "id", value = "${instance.id}"),
                method = "DELETE"
        )
    })
    @XmlJavaTypeAdapter(LinkAdapter.class)
    List<Link> links;

    public int getId() {
        return id;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLink(List<Link> links) {
        this.links = links;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }
}