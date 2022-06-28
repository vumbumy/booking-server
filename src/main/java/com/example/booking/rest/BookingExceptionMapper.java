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

package com.example.booking.rest;

import com.google.protobuf.InvalidProtocolBufferException;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/** Map exceptions to responses by implementing the ExceptionMapper interface,
 * which handles unexpected errors.
 */
@Provider
public class BookingExceptionMapper implements ExceptionMapper<Throwable> {

  public Response toResponse(Throwable ex) {
    Response.StatusType type = getStatusType(ex);
    Error error = new Error(type.getStatusCode(), type.getReasonPhrase(), ex.getMessage());

    return Response.status(type.getStatusCode())
        .entity(error)
        .type(MediaType.APPLICATION_JSON)
        .build();
  }

  private Response.StatusType getStatusType(Throwable ex) {
    if (ex instanceof InvalidProtocolBufferException) {
      return Response.Status.BAD_REQUEST;
    } else if (ex instanceof NotAuthorizedException) {
      return Response.Status.UNAUTHORIZED;
    } else if (ex instanceof NotFoundException) {
      return Response.Status.NOT_FOUND;
    } else if (ex instanceof UnsupportedOperationException) {
      return Response.Status.NOT_IMPLEMENTED;
    }
    // TODO(partner): implement handlers for other exception you throw
    return Response.Status.INTERNAL_SERVER_ERROR;
  }
}
