//    Copyright 2018 Google Inc.
//
//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at
//
//        https://www.apache.org/licenses/LICENSE-2.0
//
//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.

package com.google.fhir.stu3;

import com.google.fhir.common.ProtoUtils;
import com.google.fhir.r4.proto.Extension;
import com.google.fhir.r4.proto.Url;
import com.google.protobuf.MessageOrBuilder;

/** A wrapper around the Url FHIR primitive type. */
public class UrlWrapper extends PrimitiveWrapper<Url> {

  private static final Url NULL_URL =
      Url.newBuilder()
          .addExtension(ProtoUtils.fieldWiseCopy(getNoValueExtension(), Extension.newBuilder()))
          .build();

  /** Create an UrlWrapper from a Url. */
  public UrlWrapper(Url uri) {
    super(uri);
  }

  public UrlWrapper(MessageOrBuilder message) {
    super(ProtoUtils.fieldWiseCopy(message, Url.newBuilder()).build());
  }

  /** Create an UrlWrapper from a java String. */
  public UrlWrapper(String input) {
    super(input == null ? NULL_URL : parseAndValidate(input));
  }

  @Override
  protected String printValue() {
    return getWrapped().getValue();
  }

  private static Url parseAndValidate(String input) {
    return Url.newBuilder().setValue(input).build();
  }
}