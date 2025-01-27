/*
 * SonarQube
 * Copyright (C) 2009-2021 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.db.audit.model;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;
import org.apache.commons.lang.ObjectUtils;

public class ComponentNewValue extends NewValue {

  private String componentUuid;
  private String componentName;
  @Nullable
  private String description;
  private String rootComponentUuid;
  private String path;
  private String componentKey;
  private Boolean isPrivate;
  private Boolean isEnabled;
  private String qualifier;

  public ComponentNewValue(String componentUuid, String name, String componentKey, @Nullable String qualifier) {
    this.componentUuid = componentUuid;
    this.componentName = name;
    this.componentKey = componentKey;
    this.qualifier = getQualifier(qualifier);
  }

  public ComponentNewValue(String componentUuid, String name, String componentKey, boolean isPrivate, String qualifier) {
    this.componentUuid = componentUuid;
    this.componentName = name;
    this.componentKey = componentKey;
    this.isPrivate = isPrivate;
    this.qualifier = getQualifier(qualifier);
  }

  public ComponentNewValue(String uuid, String name, String componentKey, boolean enabled, String path, @Nullable String qualifier) {
    this.componentUuid = uuid;
    this.componentName = name;
    this.isEnabled = enabled;
    this.path = path;
    this.componentKey = componentKey;
    this.qualifier = getQualifier(qualifier);
  }

  public ComponentNewValue(String uuid, boolean isPrivate, String name, String componentKey, @Nullable String description, @Nullable String qualifier) {
    this.componentUuid = uuid;
    this.isPrivate = isPrivate;
    this.componentName = name;
    this.componentKey = componentKey;
    this.description = description;
    this.qualifier = getQualifier(qualifier);
  }

  public String getComponentUuid() {
    return componentUuid;
  }

  public String getComponentName() {
    return componentName;
  }

  @CheckForNull
  public String getDescription() {
    return description;
  }

  public String getComponentKey() {
    return componentKey;
  }

  public boolean isPrivate() {
    return isPrivate;
  }

  public String getQualifier() {
    return qualifier;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("{");
    addField(sb, "\"componentUuid\": ", this.componentUuid, true);
    addField(sb, "\"rootComponentUuid\": ", this.rootComponentUuid, true);
    addField(sb, "\"componentKey\": ", this.componentKey, true);
    addField(sb, "\"componentName\": ", this.componentName, true);
    addField(sb, "\"qualifier\": ", this.qualifier, true);
    addField(sb, "\"description\": ", this.description, true);
    addField(sb, "\"path\": ", this.path, true);
    addField(sb, "\"isPrivate\": ", ObjectUtils.toString(this.isPrivate), false);
    addField(sb, "\"isEnabled\": ", ObjectUtils.toString(this.isEnabled), false);
    endString(sb);
    return sb.toString();
  }

}
