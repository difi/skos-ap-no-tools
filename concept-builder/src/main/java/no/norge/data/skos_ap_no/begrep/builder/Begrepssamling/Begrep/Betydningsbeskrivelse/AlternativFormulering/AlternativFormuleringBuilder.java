package no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.AlternativFormulering;

import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.BegrepBuilder;
import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.AlternativFormulering.Kildebeskrivelse.KildebeskrivelseBuilder;
import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.AlternativFormulering.URITekst.URITekstBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.AlternativeWording.AlternativeWordingBuilder;
import no.norge.data.skos_ap_no.concept.builder.generelt.MålgruppeType;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;

import java.time.LocalDate;


public class AlternativFormuleringBuilder {

    private BegrepBuilder parent;
    private AlternativeWordingBuilder alternativeWordingBuilder;


    public AlternativFormuleringBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder) {
        this.parent = begrepBuilder;
        alternativeWordingBuilder = conceptBuilder.alternativeWordingBuilder();
    }

    public Model getModel() {
        return alternativeWordingBuilder.getModel();
    }

    public Resource getResource() {
        return alternativeWordingBuilder.getResource();
    }

    public KildebeskrivelseBuilder kildebeskrivelseBuilder() {
        return new KildebeskrivelseBuilder(this, alternativeWordingBuilder);
    }

    public AlternativFormuleringBuilder tekst(final String tekst, final String språk) {
        alternativeWordingBuilder.text(tekst, språk);
        return this;
    }

    public AlternativFormuleringBuilder eksempel(final String tekst, final String språk) {
        alternativeWordingBuilder.example(tekst, språk);
        return this;
    }

    public AlternativFormuleringBuilder merknad(final String tekst, final String språk) {
        alternativeWordingBuilder.scopeNote(tekst, språk);
        return this;
    }

    public AlternativFormuleringBuilder målgruppe(final MålgruppeType.Målgruppe målgruppe) {
        alternativeWordingBuilder.audience(målgruppe.toAudience());
        return this;
    }

    public URITekstBuilder omfangBuilder() {
        return new URITekstBuilder(this, alternativeWordingBuilder);
    }

    public AlternativFormuleringBuilder sistOppdatert(final LocalDate dato) {
        alternativeWordingBuilder.modified(dato);
        return this;
    }

    public BegrepBuilder build() {
        alternativeWordingBuilder.build();
        return parent;
    }

}
