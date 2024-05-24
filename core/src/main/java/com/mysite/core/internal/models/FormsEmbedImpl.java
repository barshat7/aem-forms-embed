package com.mysite.core.internal.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.drew.lang.annotations.Nullable;
import com.mysite.core.models.FormsEmbed;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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

  @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
  @Nullable
  protected Boolean noTheme;

  @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
  @Nullable
  protected String submissionRedirectUrl;

  @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL, name = "hiddenFields")
  @Nullable
  protected String[] hiddenFields;


  @Override
  public String getFormsUrl() {
    return prepareFormsUrl();
  }

  @Override
  public String getHiddenDataValueAttributes() {
    StringBuilder result = new StringBuilder();
    if (hiddenFields != null) {
      for (String kv : hiddenFields) {
        result.append(kv).append(";");
      }
    }
    return result.toString();
  }

  @Override
  public String getSubmissionRedirectUrl() {
    return submissionRedirectUrl;
  }


  private String prepareFormsUrl() {
    String url = formsUrl;
    if (Boolean.TRUE.equals(noTheme) && StringUtils.isNotEmpty(formsUrl)) {
      if (formsUrl.contains("?")) {
        url = formsUrl + "&notheme=true";
      } else {
        url = formsUrl + "?notheme=true";
      }
    }
    return url;
  }
}
