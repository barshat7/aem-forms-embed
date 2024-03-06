package com.mysite.core.internal.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.drew.lang.annotations.Nullable;
import com.mysite.core.models.FormsEmbed;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = SlingHttpServletRequest.class,
    adapters = {FormsEmbed.class, ComponentExporter.class},
    resourceType = FormsEmbedImpl.RESOURCE_TYPE
)
@Exporter(
    name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
    extensions = ExporterConstants.SLING_MODEL_EXTENSION
)
public class FormsEmbedImpl implements FormsEmbed {

  public static final String RESOURCE_TYPE = "mysite/components/formsembed";

  @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
  @Nullable
  protected String formsUrl;


  @Override
  public String getFormsUrl() {
    return formsUrl;
  }
}
