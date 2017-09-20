package com.xyyh.web.common;

public class RestResponse<T> {

	private boolean success;
	private T data;

	public static RestResponse<?> success() {
		return success(null);
	}

	public static <T> RestResponse<T> success(T data) {
		RestResponse<T> response = new RestResponse<T>();
		response.success = true;
		response.data = data;
		return response;
	}

	public static <T> RestResponse<T> failure(T data) {
		RestResponse<T> response = new RestResponse<T>();
		response.success = false;
		response.data = data;
		return response;
	}

	public static RestResponse<?> failure() {
		return failure(null);
	}

	public boolean isSuccess() {
		return success;
	}

	public T getData() {
		return data;
	}

}
