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
import com.google.protobuf.util.JsonFormat;
import ext.maps.booking.partner.v3.ApiV3;
import ext.maps.booking.partner.v3.Waitlist;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/** Booking REST Server for API v3 with authentication. */
@Path("/v3")
public class BookingService {

  private JsonFormat.Printer jsonPrinter() {
    return JsonFormat.printer().preservingProtoFieldNames();
  }

  @Path("/HealthCheck")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String checkServer() {
    return "200";
  }

  @Path("/CheckAvailability")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String checkAvailability(String request) throws InvalidProtocolBufferException {

    // use JsonFormat.Parser to convert Json String to protocol buffer
    ApiV3.CheckAvailabilityRequest.Builder requestBuilder =
        ApiV3.CheckAvailabilityRequest.newBuilder();
    JsonFormat.Parser jsonParser = JsonFormat.parser();
    jsonParser.merge(request, requestBuilder);
    ApiV3.CheckAvailabilityRequest checkAvailabilityRequest = requestBuilder.build();

    // Unexpected error: throw exception and handle it in BookingExceptionMapper class,
    // return corresponding response and HTTP code
    //
    // Normal path: get response object from the helper function
    ApiV3.CheckAvailabilityResponse response = performCheckAvailability(checkAvailabilityRequest);

    // use JsonFormat to convert protocol buffer to Json
    String jsonResponse = jsonPrinter().print(response);
    return jsonResponse;
  }

  // TODO(partner): Implement this method to perform availability check
  private ApiV3.CheckAvailabilityResponse performCheckAvailability(
      ApiV3.CheckAvailabilityRequest request) {

    //        Check availability business logic:
    //        e.g.
    //        ApiV3.Slot requestedSlot = request.getSlot();
    //        int available_spots = ...;
    //        ApiV3.CheckAvailabilityResponse response =
    //                ApiV3.CheckAvailabilityResponse.newBuilder()
    //                        .setSlot(requestedSlot)
    //                        .setCountAvailable(available_spots)
    //                        .build();
    //        return response;

    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Path("/BatchAvailabilityLookup")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String batchAvailabilityLookup(String request) throws InvalidProtocolBufferException {

    // use JsonFormat.Parser to convert Json String into protocol buffer
    ApiV3.BatchAvailabilityLookupRequest.Builder requestBuilder
        = ApiV3.BatchAvailabilityLookupRequest.newBuilder();
    JsonFormat.Parser jsonParser = JsonFormat.parser();
    jsonParser.merge(request, requestBuilder);
    ApiV3.BatchAvailabilityLookupRequest batchAvailabilityLookupRequest = requestBuilder.build();

    // Unexpected error: throw exception and handle it in BookingExceptionMapper class,
    // return corresponding response and HTTP code
    // Normal path: get response object from the helper function
    ApiV3.BatchAvailabilityLookupResponse response
        = performBatchAvailabilityLookup(batchAvailabilityLookupRequest);

    // use JsonFormat to convert protocol buffer to Json
    String jsonResponse = jsonPrinter().print(response);
    return jsonResponse;
  }

  // TODO(partner): Implement this method to perform batch availability lookup
  private ApiV3.BatchAvailabilityLookupResponse performBatchAvailabilityLookup(
      ApiV3.BatchAvailabilityLookupRequest request) {
    //        BatchAvailabilityLookup logic:
    //        e.g.
    //        String merchantId = request.getMerchantId();
    //        List<ApiV3.SlotTime> requestedSlotTimes = request.getSlotTimeList();
    //
    //        List<ApiV3.SlotTimeAvailability> slotTimeAvailabilities =
    //             new ArrayList<SlotTimeAvailability>();
    //
    //        loop through all requested slotTimes &
    //          populate slotTimeAvailabilities with availability status:
    //        e.g
    //        for (ApiV3.SlotTime slotTime : requestedSlotTimes) {
    //            slotTimeAvailabilities.add(SlotTimeAvailability.newBuilder()
    //                .setSlotTime(slotTime)
    //                .setAvailable(true)
    //                .build());
    //        }
    //
    //        ApiV3.BatchAvailabilityLookupResponse response =
    //            ApiV3.BatchAvailabilityLookupResponse.newBuilder()
    //                .addAllSlotTimeAvailability(slotTimeAvailabilities).build();
    //
    //        return response;

    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Path("/CreateBooking")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String createBooking(String request) throws InvalidProtocolBufferException {

    // use JsonFormat.Parser to convert Json String into protocol buffer
    ApiV3.CreateBookingRequest.Builder requestBuilder = ApiV3.CreateBookingRequest.newBuilder();
    JsonFormat.Parser jsonParser = JsonFormat.parser();
    jsonParser.merge(request, requestBuilder);
    ApiV3.CreateBookingRequest createBookingRequest = requestBuilder.build();

    // Unexpected error: throw exception and handle it in BookingExceptionMapper class,
    // return corresponding response and HTTP code
    //
    // Normal path: get response object from the helper function
    ApiV3.CreateBookingResponse response = performCreateBooking(createBookingRequest);

    // use JsonFormat to convert protocol buffer to Json
    String jsonResponse = jsonPrinter().print(response);
    return jsonResponse;
  }

  // TODO(partner): Implement this method to create a booking based on the request
  private ApiV3.CreateBookingResponse performCreateBooking(ApiV3.CreateBookingRequest request) {

    //        Create booking business logic:
    //        e.g.
    //        ApiV3.Booking createdBooking = ApiV3.Booking.newBuilder()
    //                .setBookingId("sampleBooking1")
    //                .setSlot(request.getSlot())
    //                .setUserInformation(request.getUserInformation())
    //                .setStatus(ApiV3.BookingStatus.CONFIRMED)
    //                .build();
    //
    //        ApiV3.CreateBookingResponse response = ApiV3.CreateBookingResponse.newBuilder()
    //                .setBooking(createdBooking)
    //                .build();
    //
    //        Business logic error -> set the BookingFailure in the response
    //        e.g.
    //        BookingServerModel.BookingFailure bookingFailure =
    // BookingServerModel.BookingFailure.newBuilder()
    //                .setCause(BookingServerModel.BookingFailure.Cause.SLOT_UNAVAILABLE)
    //                .setDescription("slot is not available now")
    //                .build();
    //        BookingServerModel.CreateBookingResponse response =
    // BookingServerModel.CreateBookingResponse.newBuilder()
    //                .setBookingFailure(bookingFailure).build();
    //
    //        return response;

    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Path("/UpdateBooking")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String updateBooking(String request) throws InvalidProtocolBufferException {

    // use JsonFormat.Parser to convert Json String into protocol buffer
    ApiV3.UpdateBookingRequest.Builder requestBuilder = ApiV3.UpdateBookingRequest.newBuilder();
    JsonFormat.Parser jsonParser = JsonFormat.parser();
    jsonParser.merge(request, requestBuilder);
    ApiV3.UpdateBookingRequest updateBookingRequest = requestBuilder.build();

    // Unexpected error: throw exception and handle it in BookingExceptionMapper class,
    // return corresponding response and HTTP code
    //
    // Normal path: get response object from the helper function
    ApiV3.UpdateBookingResponse response = performUpdateBooking(updateBookingRequest);

    // use JsonFormat to convert protocol buffer to Json
    String jsonResponse = jsonPrinter().print(response);
    return jsonResponse;
  }

  // TODO(partner): Implement this method to update the booking based on the request
  private ApiV3.UpdateBookingResponse performUpdateBooking(ApiV3.UpdateBookingRequest request) {

    //        Update booking business logic:
    //        e.g.
    //        ApiV3.Booking booking = request.getBooking();
    //        ApiV3.Booking updatedBooking = ...
    //        ApiV3.UpdateBookingResponse response = ApiV3.UpdateBookingResponse.newBuilder()
    //                .setBooking(updatedBooking)
    //                .build();
    //
    //        Business logic error -> set the BookingFailure in the response
    //        e.g.
    //        BookingServerModel.BookingFailure bookingFailure =
    // BookingServerModel.BookingFailure.newBuilder()
    //                .setCause(BookingServerModel.BookingFailure.Cause.BOOKING_NOT_CANCELLABLE)
    //                .setDescription("this booking is not cancellable")
    //                .build();
    //        BookingServerModel.CreateBookingResponse response =
    // BookingServerModel.CreateBookingResponse.newBuilder()
    //                .setBookingFailure(bookingFailure).build();
    //
    //        return response;

    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Path("/GetBookingStatus")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String getBookingStatus(String request) throws InvalidProtocolBufferException {

    // use JsonFormat.Parser to convert Json String into protocol buffer
    ApiV3.GetBookingStatusRequest.Builder requestBuilder =
        ApiV3.GetBookingStatusRequest.newBuilder();
    JsonFormat.Parser jsonParser = JsonFormat.parser();
    jsonParser.merge(request, requestBuilder);
    ApiV3.GetBookingStatusRequest getBookingStatusRequest = requestBuilder.build();

    // Unexpected error: throw exception and handle it in BookingExceptionMapper class,
    // return corresponding response and HTTP code
    //
    // Normal path: get response object from the helper function
    ApiV3.GetBookingStatusResponse response = performGetBookingStatus(getBookingStatusRequest);

    // use JsonFormat to convert protocol buffer to Json
    String jsonResponse = jsonPrinter().print(response);
    return jsonResponse;
  }

  // TODO(partner): Implement this method to get the booking status and prepayment status based on
  // the request
  private ApiV3.GetBookingStatusResponse performGetBookingStatus(
      ApiV3.GetBookingStatusRequest request) {

    //        Get booking status business logic:
    //        e.g.
    //        String bookingId = request.getBookingId();
    //        ...
    //        ApiV3.GetBookingStatusResponse response = ApiV3.GetBookingStatusResponse.newBuilder()
    //                .setBookingId(bookingId)
    //                .setBookingStatus(ApiV3.BookingStatus.CONFIRMED)
    //                .setPrepaymentStatus(ApiV3.PrepaymentStatus.PREPAYMENT_NOT_PROVIDED)
    //                .build();
    //
    //        If booking id is not found -> throw new NotFoundException("Booking id not found");
    //
    //        return response;

    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Path("/ListBookings")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String getListBooking(String request) throws InvalidProtocolBufferException {

    // use JsonFormat.Parser to convert Json String into protocol buffer
    ApiV3.ListBookingsRequest.Builder requestBuilder = ApiV3.ListBookingsRequest.newBuilder();
    JsonFormat.Parser jsonParser = JsonFormat.parser();
    jsonParser.merge(request, requestBuilder);
    ApiV3.ListBookingsRequest listBookingsRequest = requestBuilder.build();

    // Unexpected error: throw exception and handle it in BookingExceptionMapper class,
    // return corresponding response and HTTP code
    //
    // Normal path: get response object from the helper function
    ApiV3.ListBookingsResponse response = performGetListBooking(listBookingsRequest);

    // use JsonFormat to convert protocol buffer to Json
    String jsonResponse = jsonPrinter().print(response);
    return jsonResponse;
  }

  // TODO(partner): Implement this method to look up all bookings with the given userId
  private ApiV3.ListBookingsResponse performGetListBooking(ApiV3.ListBookingsRequest request) {

    //        List bookings business logic:
    //        e.g.
    //        String userId = request.getUserId();
    //        List<ApiV3.Booking> bookings = ...
    //
    //        ApiV3.ListBookingsResponse response = ApiV3.ListBookingsResponse.newBuilder()
    //                .addAllBookings(bookings)
    //                .build();
    //
    //        If user id not found -> throw new NotFoundException("User id not found");
    //
    //        return response;

    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Path("/CheckOrderFulfillability")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String checkOrderFulfillability(String request) throws InvalidProtocolBufferException {

    // use JsonFormat.Parser to convert Json String into protocol buffer
    ApiV3.CheckOrderFulfillabilityRequest.Builder requestBuilder =
        ApiV3.CheckOrderFulfillabilityRequest.newBuilder();
    JsonFormat.Parser jsonParser = JsonFormat.parser();
    jsonParser.merge(request, requestBuilder);
    ApiV3.CheckOrderFulfillabilityRequest checkOrderFulfillabilityRequest = requestBuilder.build();

    // For unexpected error: throw exception and handle it in BookingExceptionMapper class,
    // return corresponding response and HTTP code
    //
    // Normal path: get response object from the helper function
    ApiV3.CheckOrderFulfillabilityResponse response =
        performCheckOrderFulfillability(checkOrderFulfillabilityRequest);

    // use JsonFormat to convert protocol buffer to Json
    String jsonResponse = jsonPrinter().print(response);
    return jsonResponse;
  }

  // TODO(partner): Implement this method to perform order fulfillability check
  private ApiV3.CheckOrderFulfillabilityResponse performCheckOrderFulfillability(
      ApiV3.CheckOrderFulfillabilityRequest request) {

    //        Check order fulfillability business logic:
    //        e.g.
    //        String merchantId = request.getMerchantId();
    //        List<ApiV3.LineItem> lineItems = request.getItemList();
    //
    //        List<ApiV3.LineItemFulfillability> itemFulfillabilities =
    //                getLineItemFulfillability(merchantId,lineItems);
    //        ApiV3.OrderFulfillability.OrderFulfillabilityResult result =
    //                getOrderFulfillabilityResult(itemFulfillabilities);
    //
    //        ApiV3.OrderFulfillability.Builder orderFulfillability =
    // ApiV3.OrderFulfillability.newBuilder()
    //                .setResult(result);
    //        for (int i = 0; i < itemFulfillabilities.size(); i++) {
    //            orderFulfillability.setItemFulfillability(i, itemFulfillabilities.get(i));
    //        }
    //        ApiV3.Price total = ...   // total processing fees & taxes for this order
    //        ApiV3.CheckOrderFulfillabilityResponse response =
    // ApiV3.CheckOrderFulfillabilityResponse.newBuilder()
    //                .setFulfillability(orderFulfillability.build())
    //                .setFeesAndTaxes(total)
    //                .build();
    //
    //        return response;

    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Path("/CreateOrder")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String createOrder(String request) throws InvalidProtocolBufferException {

    // use JsonFormat.Parser to convert Json String into protocol buffer
    ApiV3.CreateOrderRequest.Builder requestBuilder = ApiV3.CreateOrderRequest.newBuilder();
    JsonFormat.Parser jsonParser = JsonFormat.parser();
    jsonParser.merge(request, requestBuilder);
    ApiV3.CreateOrderRequest createOrderRequest = requestBuilder.build();

    // For unexpected error: throw exception and handle it in BookingExceptionMapper class,
    // return corresponding response and HTTP code
    //
    // Normal path: get response object from the helper function
    ApiV3.CreateOrderResponse response = performCreateOrder(createOrderRequest);

    // use JsonFormat to convert protocol buffer to Json
    String jsonResponse = jsonPrinter().print(response);
    return jsonResponse;
  }

  // TODO(partner): Implement this method to create the order based on the request
  private ApiV3.CreateOrderResponse performCreateOrder(ApiV3.CreateOrderRequest request) {

    //        Create order business logic:
    //        e.g.
    //        ApiV3.Order order = request.getOrder();
    //
    //        normal case -> create this order in the backend, return response:
    //        ApiV3.CreateOrderResponse response = ApiV3.CreateOrderResponse.newBuilder()
    //                .setOrder(order)
    //                .build();
    //
    //        Business logic error -> set the BookingFailure in the response
    //        e.g.
    //        ApiV3.OrderFailure orderFailure = ApiV3.OrderFailure.newBuilder()
    //                .setCause(ApiV3.OrderFailure.Cause.ORDER_UNFULFILLABLE)
    //                .setFulfillability(orderFulfillability...)
    //                .build();
    //        ApiV3.CreateOrderResponse response = ApiV3.CreateOrderResponse.newBuilder()
    //                .setOrderFailure(orderFailure)
    //                .build();
    //
    //        return response;

    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Path("/ListOrders")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String listOrders(String request) throws InvalidProtocolBufferException {

    // use JsonFormat.Parser to convert Json String into protocol buffer
    ApiV3.ListOrdersRequest.Builder requestBuilder = ApiV3.ListOrdersRequest.newBuilder();
    JsonFormat.Parser jsonParser = JsonFormat.parser();
    jsonParser.merge(request, requestBuilder);
    ApiV3.ListOrdersRequest listOrdersRequest = requestBuilder.build();

    // For unexpected error: throw exception and handle it in BookingExceptionMapper class,
    // return corresponding response and HTTP code
    //
    // Normal path: get response object from the helper function
    ApiV3.ListOrdersResponse response = getListOrders(listOrdersRequest);

    // use JsonFormat to convert protocol buffer to Json
    String jsonResponse = jsonPrinter().print(response);
    return jsonResponse;
  }

  // TODO(partner): Implement this method to list orders based on user id or order ids
  private ApiV3.ListOrdersResponse getListOrders(ApiV3.ListOrdersRequest request) {

    //        List orders business logic:
    //        e.g.
    //        String userId = request.getUserId();
    //        ApiV3.ListOrdersRequest.OrderIds orderIds = request.getOrderIds();
    //        List<ApiV3.Order> orders = new ArrayList<ApiV3.Order>();
    //        if (userId != null) {
    //            orders = findOrdersByUserId(userId);
    //        } else if (orderIds != null) {
    //            List<String> orderId = orderIds.getOrderIdList();
    //            orders = getOrders(orderId);
    //        } else {
    //            throw new NotFoundException("No userId or orderId matched");
    //        }
    //        ApiV3.ListOrdersResponse.Builder response = ApiV3.ListOrdersResponse.newBuilder();
    //        for (int i = 0; i < orders.size(); i++) {
    //            response.setOrder(i, orders.get(i));
    //        }
    //
    //        return response.build();

    throw new UnsupportedOperationException("Not implemented yet");
  }


  /**
   * Waitlist Implementation
   * Proto File -
   * https://developers.google.com/maps-booking/reference/rest-api-v3/waitlists/proto-bundle
   */
  @Path("/BatchGetWaitEstimates")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String batchGetWaitEstimates(String request) throws InvalidProtocolBufferException {

    // use JsonFormat.Parser to convert Json String into protocol buffer
    Waitlist.BatchGetWaitEstimatesRequest.Builder requestBuilder
        = Waitlist.BatchGetWaitEstimatesRequest.newBuilder();
    JsonFormat.Parser jsonParser = JsonFormat.parser();
    jsonParser.merge(request, requestBuilder);
    Waitlist.BatchGetWaitEstimatesRequest batchGetWaitEstimatesRequest = requestBuilder.build();

    // Unexpected error: throw exception and handle it in BookingExceptionMapper class,
    // return corresponding response and HTTP code
    //
    // Normal path: get response object from the helper function
    Waitlist.BatchGetWaitEstimatesResponse response
        = performBatchGetWaitEstimates(batchGetWaitEstimatesRequest);

    // use JsonFormat to convert protocol buffer to Json
    String jsonResponse = jsonPrinter().print(response);
    return jsonResponse;
  }

  // TODO(partner): Implement this method to return wait estimates based on party size
  private Waitlist.BatchGetWaitEstimatesResponse performBatchGetWaitEstimates(
      Waitlist.BatchGetWaitEstimatesRequest request) {
    // String merchantId = request.getMerchantId();
    // String serviceId = request.getServiceId();
    //
    // List<Integer> requestedPartySizes = request.getPartySizeList();
    //
    // Waitlist.BatchGetWaitEstimatesResponse response
    //     = Waitlist.BatchGetWaitEstimatesResponse.newBuilder().setWaitlistStatus(
    //           WaitlistStatus.OPEN).addAllWaitEstimate(...).build();
    //
    // return response;

    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Path("/CreateWaitlistEntry")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String createWaitlistEntry(String request) throws InvalidProtocolBufferException {

    // use JsonFormat.Parser to convert Json String into protocol buffer
    Waitlist.CreateWaitlistEntryRequest.Builder requestBuilder
        = Waitlist.CreateWaitlistEntryRequest.newBuilder();
    JsonFormat.Parser jsonParser = JsonFormat.parser();
    jsonParser.merge(request, requestBuilder);
    Waitlist.CreateWaitlistEntryRequest createWaitlistEntryRequest = requestBuilder.build();

    // Unexpected error: throw exception and handle it in BookingExceptionMapper class,
    // return corresponding response and HTTP code
    //
    // Normal path: get response object from the helper function
    Waitlist.CreateWaitlistEntryResponse response
        = performCreateWaitlistEntry(createWaitlistEntryRequest);

    // use JsonFormat to convert protocol buffer to Json
    String jsonResponse = jsonPrinter().print(response);
    return jsonResponse;
  }

  // TODO(partner): Implement this method to create wait list entry based on request
  private Waitlist.CreateWaitlistEntryResponse performCreateWaitlistEntry(
      Waitlist.CreateWaitlistEntryRequest request) {
    // String merchantId = request.getMerchantId();
    // String serviceId = request.getServiceId();
    // int partySize = request.getPartySize();
    //
    // Waitlist.UserInformation userInformation = request.getUserInformation();
    // String idempotencyToken = request.getIdempotencyToken();
    //
    // Normal Case -> return a unique waitlist_entry_id e.g
    // Waitlist.CreateWaitlistEntryResponse response
    //     = Waitlist.CreateWaitlistEntryResponse.newBuilder().setWaitlistEntryId(...).build();
    //
    // Business logic error -> set the WaitlistBusinessLogicFailure in the response
    //
    // Waitlist.WaitlistBusinessLogicFailure waitlistBusinessLogicFailure
    //     = Waitlist.WaitlistBusinessLogicFailure.newBuilder()
    //         .setCause(Cause.WAITLIST_FULL).setDescription("").build();
    //
    // Waitlist.CreateWaitlistEntryResponse response
    //     = Waitlist.CreateWaitlistEntryResponse.newBuilder()
    //         .setWaitlistBusinessLogicFailure(waitlistBusinessLogicFailure).build();
    //
    // return response;

    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Path("/GetWaitlistEntry")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String getWaitlistEntry(String request) throws InvalidProtocolBufferException {

    // use JsonFormat.Parser to convert Json String into protocol buffer
    Waitlist.GetWaitlistEntryRequest.Builder requestBuilder
        = Waitlist.GetWaitlistEntryRequest.newBuilder();
    JsonFormat.Parser jsonParser = JsonFormat.parser();
    jsonParser.merge(request, requestBuilder);
    Waitlist.GetWaitlistEntryRequest getWaitlistEntryRequest = requestBuilder.build();

    // Unexpected error: throw exception and handle it in BookingExceptionMapper class,
    // return corresponding response and HTTP code
    //
    // Normal path: get response object from the helper function
    Waitlist.GetWaitlistEntryResponse response
        = performGetWaitlistEntry(getWaitlistEntryRequest);

    // use JsonFormat to convert protocol buffer to Json
    String jsonResponse = jsonPrinter().print(response);
    return jsonResponse;
  }

  // TODO(partner): Implement this method to return waitlist entry
  private Waitlist.GetWaitlistEntryResponse performGetWaitlistEntry(
      Waitlist.GetWaitlistEntryRequest request) {
    // String waitlistEntryId = request.getWaitlistEntryId();
    //
    // Waitlist.GetWaitlistEntryResponse response = Waitlist.GetWaitlistEntryResponse.newBuilder()
    //     .setWaitlistEntry(WaitlistEntry...).build();
    //
    // return response;

    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Path("/DeleteWaitlistEntry")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String deleteWaitlistEntry(String request) throws InvalidProtocolBufferException {

    // use JsonFormat.Parser to convert Json String into protocol buffer
    Waitlist.DeleteWaitlistEntryRequest.Builder requestBuilder
        = Waitlist.DeleteWaitlistEntryRequest.newBuilder();
    JsonFormat.Parser jsonParser = JsonFormat.parser();
    jsonParser.merge(request, requestBuilder);
    Waitlist.DeleteWaitlistEntryRequest deleteWaitlistEntryRequest = requestBuilder.build();

    // Unexpected error: throw exception and handle it in BookingExceptionMapper class,
    // return corresponding response and HTTP code
    //
    // If entry exists, delete it. Otherwise throw 404
    performDeleteWaitlistEntry(deleteWaitlistEntryRequest);

    return "";
  }

  // TODO(partner): Implement this method to return waitlist entry
  private void performDeleteWaitlistEntry(Waitlist.DeleteWaitlistEntryRequest request) {

    // String waitlistEntryId = request.getWaitlistEntryId();
    // If waitlist entry Id exists, delete it
    // If waitlist entry id doesn't exist, return 404
    // throw new WebApplicationException(404);

    throw new UnsupportedOperationException("Not implemented yet");
  }
}
