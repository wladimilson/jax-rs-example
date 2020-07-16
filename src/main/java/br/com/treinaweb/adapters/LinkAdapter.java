package br.com.treinaweb.adapters;

import java.net.URI;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LinkAdapter extends XmlAdapter<LinkJaxb, Link> {

    public LinkAdapter() {}

    public Link unmarshal(LinkJaxb p1) {
        Link.Builder builder = Link
                                .fromUri(p1.getUri())
                                .rel(p1.getRel())
                                .type(p1.getType());

        return builder.build();
    }

    public LinkJaxb marshal(Link p1) {
        return new LinkJaxb(
                        p1.getUri(), 
                        p1.getRel(), 
                        p1.getType()
                    );
    }
}

class LinkJaxb {

    private URI uri;
    private String rel;
    private String type;

    public LinkJaxb() {
        this(null, null, null);
    }

    public LinkJaxb(URI uri, 
                    String rel, 
                    String type) 
    {
        this.uri = uri;
        this.rel = rel;
        this.type = type;
    }

    @XmlAttribute(name = "href")
    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    @XmlAttribute(name = "rel")
    public String getRel(){
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    @XmlAttribute(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}