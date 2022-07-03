/*
 * Copyright 2018, Google Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.example.booking.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.StringTokenizer;


/** Check the credentials by validates the data included in authorization headers. */
public class AuthenticationService {

  Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

  // TODO(partner): set your user name and password
  private static String USERNAME = "admin";
  private static String PASSWORD = "password";

  public boolean authenticate(String credential) {
    if (null == credential) {
      return false;
    }
    // header value format will be "Basic encoded string" for Basic
    // authentication. Example "Basic YWRtaW46YWRtaW4="
    final String encodedUserPassword = credential.replaceFirst("Basic" + " ", "");
    byte[] decodedBytes = Base64.getDecoder().decode(encodedUserPassword);

    String usernameAndPassword = new String(decodedBytes, StandardCharsets.UTF_8);

    final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
    final String username = tokenizer.nextToken();
    final String password = tokenizer.nextToken();

    logger.info("authenticate {} / {}", username, password);

    return USERNAME.equals(username) && PASSWORD.equals(password);
  }
}
