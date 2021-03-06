package no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Definisjon.URITekst;

import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Definisjon.DefinisjonBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.Definition.DefinitionBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.Definition.URIText.URITextBuilder;


public class URITekstBuilder extends no.norge.data.skos_ap_no.concept.builder.generelt.URITekstBuilder<URITekstBuilder> {

    private DefinisjonBuilder parent;
    private URITextBuilder uriTextBuilder;


    public URITekstBuilder(final DefinisjonBuilder definisjonBuilder, final DefinitionBuilder definitionBuilder) {
        this.parent = definisjonBuilder;
        uriTextBuilder = definitionBuilder.scopeBuilder();
    }

    public DefinisjonBuilder build() {
        uriTextBuilder.build();
        return parent;
    }

    public no.norge.data.skos_ap_no.concept.builder.generic.URITextBuilder getURITextBuilder() {
        return uriTextBuilder;
    }

}