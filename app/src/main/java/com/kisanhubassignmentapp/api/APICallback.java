package com.kisanhubassignmentapp.api;

/**
 * Created by @author Prajakta on 27-09-2018.
 */
@SuppressWarnings("ALL")
public interface APICallback {
    <T> void onSuccess(T serviceResponse);

    <T> void onError(T apiErrorModel);

    <T> void onFailure(T apiErrorModel);
}
