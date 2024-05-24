package com.mysite.core.models;

import com.adobe.cq.wcm.core.components.models.Component;
import java.util.List;
import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface FormsEmbed extends Component {
  
  String getFormsUrl();

  String getHiddenDataValueAttributes();

  String getSubmissionRedirectUrl();
}
