package com.kisanhubassignmentapp.api;

import android.text.TextUtils;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.SocketTimeoutException;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by @author Prajakta on 27-09-2018.
 */

public class ErrorUtils {
    private final static String TAG = ErrorUtils.class.getName();

    public final static String API_STATUS_CODE_NO_INTERNET = "420";
    public static final String STR_TIME_OUT_ERROR = "Time out exception";
    public static final String STR_NETWORK_FAILURE = "Network failure";

    public static APIError parseError(Response<?> response) {
        Converter<ResponseBody, APIError> converter =
                ApiServiceGenerator.getRetrofit()
                        .responseBodyConverter(APIError.class, new Annotation[0]);

        APIError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new APIError();
        }

        return error;
    }


    public static APIError parseThrowable(Throwable t) {
        APIError apiResponse = new APIError();
        try {

            if (t instanceof IOException) {
                if (t instanceof SocketTimeoutException) {

                    apiResponse.setStatusCode(API_STATUS_CODE_NO_INTERNET);
                    apiResponse.setMessage(STR_TIME_OUT_ERROR);
                } else {//UnknownHostException
                    apiResponse.setStatusCode(API_STATUS_CODE_NO_INTERNET);
                    apiResponse.setMessage(STR_NETWORK_FAILURE);
                }

            } else if (t instanceof HttpException) {
                HttpException error = (HttpException) t;
                try {
                    Converter<ResponseBody, APIError> converter =
                            ApiServiceGenerator.getRetrofit()
                                    .responseBodyConverter(APIError.class, new Annotation[0]);

                    apiResponse = converter.convert(error.response().errorBody());

                    apiResponse.setStatusCode("" + error.response().code());

                } catch (Exception e) {
                    apiResponse.setStatusCode("" + error.response().code());
                    apiResponse.setMessage(error.getMessage());
                }
            } else if (t instanceof NumberFormatException) {

                apiResponse.setMessage("NumberFormatException");

            } else if (t instanceof Exception) {

                apiResponse.setMessage("Exception");
            }
            if (TextUtils.isEmpty(apiResponse.getMessage()))
                apiResponse.setMessage("Unknown error occurred!");

        } catch (Exception e) {
            apiResponse.setMessage("Unknown error occurred!");

        }
        return apiResponse;
    }

}
