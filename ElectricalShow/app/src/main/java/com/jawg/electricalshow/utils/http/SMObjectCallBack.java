package com.jawg.electricalshow.utils.http;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class SMObjectCallBack<T> {
	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public SMObjectCallBack() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

    public void onSuccess(T t) {

    }

    public void onSuccessArray(List<T> t) {

    }

    public abstract void onError(int error, String msg);

	public  void onLoading(long total, long current, boolean isUploading){

	}

	public Class<T> getClazz() {
		return clazz;
	}



}
