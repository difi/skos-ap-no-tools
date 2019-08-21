package no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse;

import no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.BegrepBuilder;
import no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Kildebeskrivelse.KildebeskrivelseBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.DefinitionBuilder;
import no.difi.skos_ap_no.concept.builder.SKOSNO;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;

import java.time.LocalDate;


public class DefinisjonBuilder {

    private BegrepBuilder parent;
    private DefinitionBuilder definitionBuilder;


    public DefinisjonBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder, final Resource definitionClass) {
        this.parent = begrepBuilder;
        definitionBuilder = definitionClass == SKOSNO.Definisjon ? conceptBuilder.definitionBuilder() : conceptBuilder.alternativeDefinitionBuilder();
    }

    public Model getModel() {
        return definitionBuilder.getModel();
    }

    public Resource getResource() {
        return definitionBuilder.getResource();
    }

    public KildebeskrivelseBuilder kildebeskrivelseBuilder() {
        return new KildebeskrivelseBuilder(this, definitionBuilder);
    }

    public DefinisjonBuilder tekst(final String tekst, final String språk) {
        definitionBuilder.text(tekst, språk);
        return this;
    }

    public DefinisjonBuilder merknad(final String tekst, final String språk) {
        definitionBuilder.scopeNote(tekst, språk);
        return this;
    }

    public DefinisjonBuilder målgruppe(final String tekst, final String språk) {
        definitionBuilder.audience(tekst, språk);
        return this;
    }

    public DefinisjonBuilder sistOppdatert(final LocalDate dato) {
        definitionBuilder.modified(dato);
        return this;
    }

    public BegrepBuilder build() {
        definitionBuilder.build();
        return parent;
    }

}
